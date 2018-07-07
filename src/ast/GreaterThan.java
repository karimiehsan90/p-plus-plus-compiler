package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class GreaterThan extends Terminal implements ConditionalOpr {
    public GreaterThan() {
        super(Sym.gt,">");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.GT;
    }
}
