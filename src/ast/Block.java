package ast;

public class Block implements ASTNode {
    public Begin begin;
    public BlockInnerList blockInners;
    public End end;

    public Block(Begin begin, BlockInnerList blockInners, End end) {
        this.begin = begin;
        this.blockInners = blockInners;
        this.end = end;
    }
}
