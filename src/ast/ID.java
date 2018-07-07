package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class ID extends TerminalType {
    public ID(String s) {
        super(Sym.id,s);
    }
}
