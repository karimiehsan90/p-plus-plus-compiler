package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class LongConst extends Terminal implements Const {
    public LongConst(String s) {
        super(Sym.long_const,s);
    }
}
