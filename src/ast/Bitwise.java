package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Bitwise extends Terminal {
    public Bitwise() {
        super(Sym.not,"~");
    }
}
