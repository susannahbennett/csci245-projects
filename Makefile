# Set up default gcc settings and warnings/errors
CFLAGS = -g -std=c99 -Wall -Werror
CFLAGS += $(addprefix -Wno-,unused-variable unused-but-set-variable unused-function unused-label unused-local-typedefs comment)
CFLAGS += $(addprefix -Wno-error=,main misleading-indentation parentheses switch tautological-compare logical-not-parentheses pointer-sign)

# Declare that `all' and `clean' are not real files
.PHONY: all clean

# Build all the programs (default for `make' because this is the first rule)
all: vectest sieve

# Remove the build products
clean:
	$(RM) vectest sieve *.o

# Dependencies for executables
vectest: vectest.o bitvector.o
sieve: sieve.o bitvector.o

# Additional dependencies for object files
vectest.o: bitvector.h
bitvector.o: bitvector.h
sieve.o: bitvector.h
