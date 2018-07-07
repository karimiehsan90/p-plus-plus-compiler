package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Dot extends Terminal {
    public Dot() {
        super(Sym.dot,".");
    }
}
