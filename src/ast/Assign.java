package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Assign extends Terminal implements AssignOpr {
    public Assign() {
        super(Sym.assign,"=");
    }
}
