#include <stdio.h>
#include <stdlib.h>

#include "asm.h"

int
main(int argc, char **argv)
{
	FILE *source;
	int instr_words;
	int *memory;
	int ip;

	if (argc < 2) {
		fprintf(stderr,
				"Missing filename.\n"
				"Usage: %s program.vml\n", argv[0]);
		return 1;
	}

	source = fopen(argv[1], "r");
	fscanf(source, "%d\n", &instr_words);

	memory = (int *) calloc(sizeof(int), instr_words);

	for(ip = 0; ip < instr_words; ip++)
		fscanf(source, "%d\n", memory+ip);

	for (ip = 0; ip < instr_words; /* */) {
		int newip = disassemble(memory, ip);
		if (newip < 0)
			return 1;
		ip = newip;
	}

	return 0;
}
