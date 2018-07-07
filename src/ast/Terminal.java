package ast;

import java_cup.runtime.Symbol;

public class Terminal implements ASTNode {
    public Symbol symbol;

    public Terminal(Symbol symbol) {
        this.symbol = symbol;
    }

    public Terminal(int type,String value) {
        this.symbol = new Symbol(type,value);
    }
}
