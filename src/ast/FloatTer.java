package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class FloatTer extends TerminalType {
    public FloatTer() {
        super(Sym.floatTer,"float");
    }
}
