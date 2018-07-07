package stp;

import java.util.LinkedList;
import java.util.List;

public class BST_STP implements STP {
    private List<Desc> descs = new LinkedList<>();

    public List<Desc> getDescs() {
        return descs;
    }

    @Override
    public void add(String varName, Desc object) {
        descs.add(object);
    }

    @Override
    public List<Desc> lookup(String var) {
        List<Desc> ans = new LinkedList<>();
        for (Desc desc:descs) {
            if (desc.getName().equals(var)){
                ans.add(desc);
            }
        }
        return ans;
    }

    @Override
    public Desc getLast() {
        return descs.get(descs.size() - 1);
    }

}
