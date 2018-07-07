package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class OpenParen extends Terminal {
    public OpenParen() {
        super(Sym.openParen,"(");
    }
}
