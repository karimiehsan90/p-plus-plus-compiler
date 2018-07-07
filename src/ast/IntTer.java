package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class IntTer extends TerminalType {
    public IntTer() {
        super(Sym.intTer,"int");
    }
}
