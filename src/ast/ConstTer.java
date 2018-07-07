package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class ConstTer extends Terminal {
    public ConstTer() {
        super(Sym.constTer,"const");
    }
}
