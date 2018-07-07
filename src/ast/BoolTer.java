package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class BoolTer extends TerminalType {
    public BoolTer() {
        super(Sym.bool,"bool");
    }
}
