package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Prod extends Terminal implements ArithmaticOpr {
    public Prod() {
        super(Sym.prod,"*");
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.MUL;
    }
}
