package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Break extends Terminal {
    public Break() {
        super(Sym.breakTer,"break");
    }
}
