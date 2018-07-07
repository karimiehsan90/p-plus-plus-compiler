package ast;

import code_generation.Opcode;
import parsers.Sym;

public class AndArith extends Terminal implements ArithmaticOpr {
    public AndArith() {
        super(Sym.andArith,"&");
    }

    public Opcode getOpcode() {
        return Opcode.AND_ARITH;
    }
}
