package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class NotCond extends Terminal implements ConditionalOpr {
    public NotCond() {
        super(Sym.notLog,"not");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.NOT_COND;
    }
}
