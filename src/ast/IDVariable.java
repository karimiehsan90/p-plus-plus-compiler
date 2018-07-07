package ast;

public class IDVariable extends Variable {
    public ID id;
    public ArrayIndexList arrayIndexes;

    public IDVariable(ID id, ArrayIndexList arrayIndices) {
        this.id = id;
        this.arrayIndexes = arrayIndices;
    }
}
