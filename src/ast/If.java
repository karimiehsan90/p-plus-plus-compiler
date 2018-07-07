package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class If extends Terminal {
    public If() {
        super(Sym.ifTer,"if");
    }
}
