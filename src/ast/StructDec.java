package ast;


public class StructDec implements ProgramInner {
    public Record record;
    public ID id;
    public Begin begin;
    public VarDclList varDcls;
    public End end;
    public Record record2;
    public SemiColon semiColon;

    public StructDec(Record record, ID id, Begin begin, VarDclList varDcls, End end, Record record2,SemiColon semiColon) {
        this.record = record;
        this.id = id;
        this.begin = begin;
        this.varDcls = varDcls;
        this.end = end;
        this.record2 = record2;
        this.semiColon = semiColon;
    }
}
