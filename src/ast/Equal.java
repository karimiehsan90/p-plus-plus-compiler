package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Equal extends Terminal implements ConditionalOpr {
    public Equal() {
        super(Sym.eq,"==");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.EQ;
    }
}
