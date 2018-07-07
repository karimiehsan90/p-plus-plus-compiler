package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class Mod extends Terminal implements ArithmaticOpr {
    public Mod() {
        super(Sym.mod,"%");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.MOD;
    }
}
