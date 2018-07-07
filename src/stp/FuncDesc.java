package stp;

import java.util.List;

public class FuncDesc implements Desc {
    private String name;
    private List<StructDesc> argumentsDesc;
    private List<String> argumentNames;
    private StructDesc returnType;
    private boolean isComplete;
    private int number;

    public FuncDesc(String name, List<StructDesc> argumentsDesc,List<String> argumentNames, StructDesc returnType, boolean isComplete,int number) {
        this.name = name;
        this.argumentsDesc = argumentsDesc;
        this.returnType = returnType;
        this.isComplete = isComplete;
        this.number = number;
        this.argumentNames = argumentNames;
    }

    public List<String> getArgumentNames() {
        return argumentNames;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public StructDesc getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }
    public String getLLVMName(){
        return name + "." + number;
    }

    public List<StructDesc> getArgumentsDesc() {
        return argumentsDesc;
    }

    @Override
    public String getType() {
        return Desc.FUNCTION;
    }
}