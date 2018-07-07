package stp;

import java.util.List;

public interface STP {
    void add(String varName, Desc object);
    List<Desc> lookup(String var);
    Desc getLast();
}
