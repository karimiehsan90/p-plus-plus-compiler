package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Of extends Terminal {
    public Of() {
        super(Sym.of,"of");
    }
}
