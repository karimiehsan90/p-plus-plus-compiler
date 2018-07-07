package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class MinusMinus extends Terminal {
    public MinusMinus() {
        super(Sym.MinusMinus,"--");
    }
}
