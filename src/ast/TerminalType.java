package ast;

import java_cup.runtime.Symbol;

public class TerminalType extends Terminal implements Type {
    public TerminalType(int key,String val) {
        super(key,val);
    }
}
