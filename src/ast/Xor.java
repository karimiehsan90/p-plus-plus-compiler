package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Xor extends Terminal implements ArithmaticOpr {

    public Xor() {
        super(Sym.xor,"^");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.XOR;
    }
}
