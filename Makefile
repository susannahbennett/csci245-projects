.PHONY: all clean

BINS = disassembler virtualmachine
CFLAGS = -g
LDFLAGS = -g

all: $(BINS)

clean:
	$(RM) $(BINS)
