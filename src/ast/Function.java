package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Function extends Terminal {
    public Function() {
        super(Sym.function,"function");
    }
}
