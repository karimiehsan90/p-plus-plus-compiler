package code_generation;

import stp.Desc;
import stp.FuncDesc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectCode {
    private Map<Desc,List<Instruction>> code = new HashMap<>();

    public void add(Desc desc,List<Instruction> instructions){
        code.put(desc,instructions);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Desc d:code.keySet()) {
            if (d != null) {
                s.append(d.getName()).append("\n");
                for (Instruction i : code.get(d)) {
                    s.append(i.toString()).append("\n");
                }
            }
        }
        return s.toString();
    }

    Map<Desc, List<Instruction>> getCode() {
        return code;
    }
}
