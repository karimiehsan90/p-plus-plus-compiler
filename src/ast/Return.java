package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Return extends Terminal {
    public Return() {
        super(Sym.returnTer,"return");
    }
}
