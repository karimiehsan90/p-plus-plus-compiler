package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class RealConst extends Terminal implements Const {
    public RealConst(String s) {
        super(Sym.real_const,s);
    }
}
