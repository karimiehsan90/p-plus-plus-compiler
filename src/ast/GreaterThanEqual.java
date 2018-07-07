package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class GreaterThanEqual extends Terminal implements ConditionalOpr {
    public GreaterThanEqual() {
        super(Sym.gte,">=");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.GTE;
    }
}
