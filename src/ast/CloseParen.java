package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class CloseParen extends Terminal {
    public CloseParen() {
        super(Sym.closeParen,")");
    }
}
