package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Else extends Terminal {
    public Else() {
        super(Sym.elseTer,"else");
    }
}
