package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Sizeof extends Terminal {
    public Sizeof() {
        super(Sym.sizeof,"sizeof");
    }
}
