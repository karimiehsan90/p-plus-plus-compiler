package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class IntConst extends Terminal implements Const,Expr {
    public IntConst(String s) {
        super(Sym.ic,s);
    }
}
