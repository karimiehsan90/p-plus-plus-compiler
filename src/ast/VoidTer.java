package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class VoidTer extends TerminalType {
    public VoidTer() {
        super(Sym.voidTer,"void");
    }
}
