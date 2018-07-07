package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class LongTer extends TerminalType {
    public LongTer() {
        super(Sym.longTer,"long");
    }
}
