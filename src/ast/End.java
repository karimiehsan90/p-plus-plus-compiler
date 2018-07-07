package ast;

import parsers.Sym;

public class End extends Terminal {
    public End() {
        super(Sym.end,"end");
    }
}
