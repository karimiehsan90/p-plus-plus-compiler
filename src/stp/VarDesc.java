package stp;

public class VarDesc implements Desc {
    private StructDesc type;
    private String name;
    private boolean isConst;

    public VarDesc(StructDesc type, String name, boolean isConst) {
        this.type = type;
        this.name = name;
        this.isConst = isConst;
    }

    public String getName() {
        return name;
    }

    public StructDesc getVarType(){
        return type;
    }

    public boolean isConst() {
        return isConst;
    }

    @Override
    public String getType() {
        return Desc.VAR;
    }
}
