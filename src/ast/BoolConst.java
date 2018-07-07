package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class BoolConst extends Terminal implements Const,Expr {
    public BoolConst(String s) {
        super(Sym.bool_const,s);
    }
}
