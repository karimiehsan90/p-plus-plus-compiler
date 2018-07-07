package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class OpenBrace extends Terminal {
    public OpenBrace() {
        super(Sym.openBrace,"[");
    }
}
