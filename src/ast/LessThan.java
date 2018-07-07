package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class LessThan extends Terminal implements ConditionalOpr {
    public LessThan() {
        super(Sym.lt,"<");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.LT;
    }
}
