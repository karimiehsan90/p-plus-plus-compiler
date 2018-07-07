package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Plus extends Terminal implements ArithmaticOpr {
    public Plus() {
        super(Sym.plus,"+");
    }

    @Override
    public String toString() {
        return "+";
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.ADD;
    }
}
