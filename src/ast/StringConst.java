package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class StringConst extends Terminal implements Const,Expr {
    public StringConst(String s) {
        super(Sym.string_const,s);
    }
}
