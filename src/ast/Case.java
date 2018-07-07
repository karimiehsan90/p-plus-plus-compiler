package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Case extends Terminal {
    public Case() {
        super(Sym.caseTer,"case");
    }
}
