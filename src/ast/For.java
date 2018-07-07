package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class For extends Terminal {
    public For() {
        super(Sym.forTer,"for");
    }
}
