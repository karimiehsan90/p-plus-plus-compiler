package stp;


import java.util.LinkedList;
import java.util.List;

public class StructDesc implements Desc {
    private String name;
    private STP fields;
    private Integer size;
    public StructDesc(String name, STP fields) {
        this.name = name;
        this.fields = fields;
    }

    public StructDesc(String name,Integer size) {
        this.name = name;
        this.fields = new BST_STP();
        this.size = size;
    }

    public Integer getSize() {
        if (size != null) {
            return size;
        }
        LinkedList<Desc> descs = (LinkedList<Desc>) ((BST_STP)fields).getDescs();
        int size = 0;
        for (Desc desc:descs) {
            size += ((VarDesc)desc).getVarType().getSize();
        }
        return size;
    }

    public STP getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return Desc.STRUCT;
    }
}
