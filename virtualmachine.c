#include <stdio.h>

/* Architecture definitions */
#define MEMSIZE 500
#define REGS 32
#define IP 0
#define RP 29
#define FP 30
#define SP 31

int main(int argc, char **argv)
{
	FILE *source;
	int memory[MEMSIZE];
	int instr_words;
	int registers[REGS];
	int i;

	source = fopen(argv[1], "r");
	fscanf(source, "%d\n", &instr_words);

	for(i = 0; i < instr_words; i++) 
		fscanf(source, "%d\n", memory + i);

	registers[IP] = 0;
	registers[FP] = registers[SP] = instr_words;

	for(;;) {
		int ip = registers[IP];
		int rd, rs, ra, imm;

		switch (memory[ip++]) 
		{
			case 1:  /* MOVI imm rd */
				imm = memory[ip++];
				rd = memory[ip++];
				registers[rd] = imm;
				break;

			case 2:  /* MOV  rs rd */
				rs = memory[ip++];
				rd = memory[ip++];
				registers[rd] = registers[rs];
				break;

			case 3:  /* ADD  rs rd */
				rs = memory[ip++];
				rd = memory[ip++];
				registers[rd] += registers[rs];
				break;

			case 4:  /* SUB  rs rd */
				rs = memory[ip++];
				rd = memory[ip++];
				registers[rd] -= registers[rs];
				break;

			case 5:  /* MUL  rs rd */
				rs = memory[ip++];
				rd = memory[ip++];
				registers[rd] *= registers[rs];
				break;

			case 6:  /* IDIV rs rd */
				rs = memory[ip++];
				rd = memory[ip++];
				registers[rd] /= registers[rs];
				break;

			case 7:  /* JMP  ra */
				ra = memory[ip++];
				ip = registers[ra];
				break;

			case 8:  /* JNZ  rs ra */
				rs = memory[ip++];
				ra = memory[ip++];
				if (registers[rs])
					ip = registers[ra];
				break;

			case 9:  /* OUT  rs */
				rs = memory[ip++];
				printf("%d\n", registers[rs]);
				break;

			case 10: /* HALT */
				return 0;

			case 11: /* LD   ra rd */
				ra = memory[ip++];
				rd = memory[ip++];
				registers[rd] = memory[registers[ra]];
				break;

			case 12: /* ST   ra rs */
				ra = memory[ip++];
				rs = memory[ip++];
				memory[registers[ra]] = registers[rs];
				break;

			case 13: /* JAL  ra */
				ra = memory[ip++];
				registers[RP] = ip;
				ip = registers[ra];
				break;

			case 14: /* RET */
				ip = registers[RP];
				break;

			case 15: /* PUSH rs */
				rs = memory[ip++];
				memory[registers[SP]++] = registers[rs];
				break;

			case 16: /* POP  rd */
				rd = memory[ip++];
				registers[rd] = memory[--registers[SP]];
				break;

			case 17: /* LDLO imm rd */
				imm = memory[ip++];
				rd = memory[ip++];
				registers[rd] = memory[registers[FP] + imm];
				break;

			case 18: /* STLO imm rs */
				imm = memory[ip++];
				rs = memory[ip++];
				memory[registers[FP] + imm] = registers[rs];
				break;

			default:
				fprintf(stderr, "invalid opcode: %d\n", memory[ip - 1]);
				return 1;
		}
		registers[IP] = ip;
	}
	return 0;
}
