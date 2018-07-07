package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Continue extends Terminal {
    public Continue() {
        super(Sym.continueTer,"continue");
    }
}
