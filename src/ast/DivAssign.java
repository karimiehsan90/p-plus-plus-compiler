package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class DivAssign extends Terminal implements AssignOpr {
    public DivAssign() {
        super(Sym.divAssign,"/=");
    }
}
