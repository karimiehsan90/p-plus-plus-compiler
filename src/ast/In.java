package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class In extends Terminal {
    public In() {
        super(Sym.in,"in");
    }
}
