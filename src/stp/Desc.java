package stp;

public interface Desc {
    String FUNCTION = "func";
    String STRUCT = "struct";
    String VAR = "int";
    String EXTERN = "extern";
    String getType();
    String getName();
}
