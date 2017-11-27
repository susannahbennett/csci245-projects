.PHONY: all clean

BINS = disassembler virtualmachine

all: $(BINS)

clean:
	$(RM) $(BINS)
