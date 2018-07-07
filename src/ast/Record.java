package ast;

import java_cup.runtime.Symbol;
import parsers.Sym;

public class Record extends Terminal {
    public Record() {
        super(Sym.record,"record");
    }
}
