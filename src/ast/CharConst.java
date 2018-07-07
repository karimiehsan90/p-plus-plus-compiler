package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class CharConst extends Terminal implements Const {
    public CharConst(String s) {
        super(Sym.char_const,s);
    }
}
