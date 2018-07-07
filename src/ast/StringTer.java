package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class StringTer extends TerminalType {
    public StringTer() {
        super(Sym.string,"string");
    }
}
