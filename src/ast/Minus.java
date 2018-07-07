package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Minus extends Terminal implements ArithmaticOpr {
    public Minus() {
        super(Sym.minus,"-");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.SUB;
    }
}
