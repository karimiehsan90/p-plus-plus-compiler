package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class AddAssign extends Terminal implements AssignOpr {
    public AddAssign() {
        super(Sym.addAssign,"+=");
    }
}
