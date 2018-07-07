package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class PlusPlus extends Terminal {
    public PlusPlus() {
        super(Sym.PlusPlus,"++");
    }
}
