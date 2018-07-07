package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class SubAssign extends Terminal implements AssignOpr {
    public SubAssign() {
        super(Sym.subAssign,"-=");
    }
}
