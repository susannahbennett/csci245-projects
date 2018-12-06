#!/usr/bin/python2

import sys

# Exception for when the IMM or REG functions find an inappropriate operand
class OperandException(Exception):
    def __init__(self, msg):
        self.msg = msg
    def __str__(self):
        return self.msg

regnames = {
        'IP': 'R0',
        'RP': 'R29',
        'FP': 'R30',
        'SP': 'R31',
        }

# convert a literal operand as it appears in the source file to
# how it should appear in the intermediate representation.
# If it's a number, then keep it as it is;
# if it looks like a register, raise an exception;
# if it looks like a label (most other things), prepend it with a #
def IMM(operand):
    if operand.isdigit():
        return operand
    elif operand[0] == '-' and operand[1:].isdigit():
        return operand
    elif operand[0] == 'R' and operand[1:].isdigit():
        num = int(operand[1:])
        if num in range(32):
            raise OperandException("Needs literal or label, found %s" % operand)
        else:
            return str(num)
    elif operand.isalnum():
        return "#" + operand
    else:
        raise OperandException("Needs literal or label, found %s" % operand)

# convert a register operand as it appears in the source file
# to how it should appear in the intermediate representation.
# Specifically, it better begin with R and then have a number from 0 to 32.
# If not, raise an appropriate exception
def REG(operand):
    try:
        operand = regnames[operand.upper()]
    except KeyError:
        pass
    if operand[0] != 'R' or not operand[1:].isdigit():
        raise OperandException("Needs register, found %s" % operand)
    elif int(operand[1:]) not in range(32):
        raise OperandException("%s is not a valid register" % operand)
    else:
        return operand[1:]


# map from instruction mnemonics to lists describing the format of that
# instruction (numeric code + functions to convert/check the operands)
instructions = {
        'MOVI': [1, IMM, REG],
        'MOV': [2, REG, REG],
        'ADD': [3, REG, REG],
        'SUB': [4, REG, REG],
        'MUL': [5, REG, REG],
        'IDIV': [6, REG, REG],
        'JMP': [7, REG],
        'JNZ': [8, REG, REG],
        'OUT': [9, REG],
        'HALT': [10],
        'LD': [11, REG, REG],
        'ST': [12, REG, REG],
        'JAL': [13, REG],
        'RET': [14],
        'PUSH': [15, REG],
        'POP': [16, REG],
        'LDLO': [17, IMM, REG],
        'STLO': [18, IMM, REG],
        }


# check to make sure there's a filename
if len(sys.argv) < 2:
    print "Usage: ./assembler filename.asm"
    sys.exit(1)

# try to open the file
try:
    asm_file = open(sys.argv[1])
except IOError:
    print "Can't find file %s (or some similar problem)" % sys.argv[1]
    sys.exit(1)


# dump the file into a list (so that I can refer back to lines for error reporting)
lines = []
for line in asm_file:
    lines.append(line)


# ******* first pass: make a list of instructions and map of labels, and flag
# any unknown instructions or instructions used with wrong operands

# if there's an error, I don't want to quit right away (so that other
# errors can be reported on the same run), but I do want to quit
# at the end of the pass
error = False

# list of "intermediate code" instructions, each a list
instr_seq = []

# map labels to the bytes where they are defined (which thus
# also is the label's value)
lab_def_byte = {}

# map labels to the lines where they are defined (for error reporting)
lab_def_line = {}

# map labels to the first line in which they are used (for error reporting)
lab_use_line = {}

# how many bytes have we processed?
byte_num = 0

# which line are we on?
line_num = 1

for line in lines:
    # get rid of comments and spaces
    comment_begin = line.find('//')
    if comment_begin != -1:
        working_line = line[:comment_begin]
    else:
        working_line = line
    working_line = working_line.strip().upper()

    #grab any labels
    while True:
        lab_end = working_line.find(':')
        if lab_end == -1:
            break
        label = working_line[:lab_end]
        if not label.isalnum():
            print "Bad label %s in line %s" %(label, str(line_num))
            print line
            error = True
        elif label in lab_def_byte:
            assert label in lab_def_line
            print "Label %s previously defined on line %s" % (label, lab_def_line[label])
            print line
            error = True
        else:
            lab_def_byte[label] = byte_num
            lab_def_line[label] = line_num
        working_line = working_line[lab_end+1:].strip()

    #read the instruction, if any
    instr_pieces = working_line.split()
    if len(instr_pieces) > 0:
        op_code = instr_pieces[0].upper()  # the mnemonic code for the instruction
        # is it a valid instruction?
        if op_code not in instructions:
            print "Unknown instruction %s in line %s" %(instr_pieces[0], str(line_num))
            print line
            error = True

        else :  # ok, it's a real instruction
            instr_format = instructions[op_code]
            # does it have the right number of operands?
            if len(instr_format) != len(instr_pieces):
                print "Wrong number of operands to %s instruction in line %s" % (op_code, str(line_num))
                print "Needs %s, found %s" % (str(len(instr_format) - 1),
                        str(len(instr_pieces) - 1))
                print line
                error = True
            else: # ok, it has the right number of operands
                # the "intermediate code" for this instruction
                instr_byte_seq = [str(instr_format[0])]
                # check each operand, adding it to the intermediate code for this
                # instruction if ok
                for i in range(1, len(instr_format)):
                    try:
                        next_byte = instr_format[i](instr_pieces[i])
                        if next_byte[0] == '#' and next_byte[1:] not in lab_use_line:
                            lab_use_line[next_byte[1:]] = line_num
                        instr_byte_seq.append(instr_format[i](instr_pieces[i]))
                    except OperandException as e:
                        print "Bad operand %s in line %s" % (str(i), str(line_num))
                        print e.msg
                        print line
                        error = True
                # increment our byte count by the number of instructions
                byte_num += len(instr_format)
                # add this instruction to our intermediate code list
                instr_seq.append(instr_byte_seq)
    # increment the line counter no matter what (even if the line is blank),
    # since this is for debugging
    line_num += 1

# check to see that all defined labels are used somewhere
for label in lab_def_line:
    if label not in lab_use_line:
        print "Warning: label %s unused" % label

# don't do a second pass if there was an error on the first
if error:
    sys.exit(1)

# ****** Second pass: go over the intermediate code, populating
# a list with the target code (the only reason we don't just write
# to a file here is because we're still checking for errors)

# the target code
instr_bytes = []
# the list of labels we've already produced "undefined" errors for;
# we want to generate an error only for the first use of an undefined label
bad_labels = []

for instr in instr_seq:
    for x in instr:
        # is it a label?
        if x[0] == '#':
            # strip off the #
            lab = x[1:]
            # is it defined somewhere?
            if lab not in lab_def_byte and lab not in bad_labels:
                print "Undefined label % used on line %" % (lab, lab_use_map[lab])
                print lines[lab_use_map[lab]]
                error = True
                bad_labels.append(lab)
            else:
                # ok, it's properly defined, emit its value
                instr_bytes.append(str(lab_def_byte[lab]))
        else:
            # not a label; just emit it as is
            instr_bytes.append(x)

# if something bad happened (that is, an undefined label),
# then don't write to the file
if error:
    sys.exit(1)

# if the source file ends with .asm, then replace it with .vml, otherwise
# just add .vml
src_file_name = sys.argv[1]
if src_file_name[-4:] == '.asm':
    src_file_name = src_file_name[:-4]
targ_file_name = src_file_name + '.vml'

# write the program
f = open(targ_file_name, 'w')
f.write(str(len(instr_bytes)) + '\n')
for x in instr_bytes:
    f.write(x + '\n')
f.close()
