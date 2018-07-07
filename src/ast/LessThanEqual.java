package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class LessThanEqual extends Terminal implements ConditionalOpr {
    public LessThanEqual() {
        super(Sym.lte,"<=");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.LTE;
    }
}
