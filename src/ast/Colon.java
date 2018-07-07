package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Colon extends Terminal {
    public Colon() {
        super(Sym.colon,":");
    }
}
