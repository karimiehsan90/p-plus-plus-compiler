package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class NotEqual extends Terminal implements ConditionalOpr {
    public NotEqual() {
        super(Sym.neq,"!=");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.NEQ;
    }
}
