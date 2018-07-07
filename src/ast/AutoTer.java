package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class AutoTer extends TerminalType {
    public AutoTer() {
        super(Sym.auto,"auto");
    }
}
