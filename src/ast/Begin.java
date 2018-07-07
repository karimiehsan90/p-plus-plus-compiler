package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Begin extends Terminal {
    public Begin() {
        super(Sym.begin,"begin");
    }
}
