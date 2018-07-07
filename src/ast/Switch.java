package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Switch extends Terminal {
    public Switch() {
        super(Sym.switchTer,"switch");
    }
}
