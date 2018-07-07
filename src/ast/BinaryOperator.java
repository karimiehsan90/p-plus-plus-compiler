package ast;

import code_generation.Opcode;

public interface BinaryOperator extends ASTNode {
    Opcode getOpcode();
}
