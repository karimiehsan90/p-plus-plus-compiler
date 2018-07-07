package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Extern extends Terminal {
    public Extern() {
        super(Sym.extern,"extern");
    }
}
