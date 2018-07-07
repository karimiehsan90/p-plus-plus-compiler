package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class CloseBrace extends Terminal {
    public CloseBrace() {
        super(Sym.closeBrace,"]");
    }
}
