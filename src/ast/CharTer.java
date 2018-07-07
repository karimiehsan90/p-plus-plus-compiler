package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class CharTer extends TerminalType {
    public CharTer() {
        super(Sym.charTer,"char");
    }
}
