package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class SemiColon extends Terminal {
    public SemiColon() {
        super(Sym.semiColon,";");
    }
}
