package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class ProdAssign extends Terminal implements AssignOpr {
    public ProdAssign() {
        super(Sym.prodAssign,"*=");
    }
}
