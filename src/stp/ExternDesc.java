package stp;

public class ExternDesc implements Desc {
    private StructDesc externType;
    private String name;

    public ExternDesc(StructDesc externType, String name) {
        this.externType = externType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StructDesc getExternType() {
        return externType;
    }

    @Override
    public String getType() {
        return Desc.EXTERN;
    }
}
