package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Until extends Terminal {
    public Until() {
        super(Sym.until,"until");
    }
}
