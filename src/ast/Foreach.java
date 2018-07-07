package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Foreach extends Terminal {
    public Foreach() {
        super(Sym.foreach,"foreach");
    }
}
