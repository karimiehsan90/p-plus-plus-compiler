package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Div extends Terminal implements ArithmaticOpr {
    public Div() {
        super(Sym.div,"/");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.DIV;
    }
}
