package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Repeat extends Terminal {
    public Repeat() {
        super(Sym.repeat,"repeat");
    }
}
