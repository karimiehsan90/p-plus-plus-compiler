package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Default extends Terminal {
    public Default() {
        super(Sym.defaultTer,"default");
    }
}
