package code_generation;

public class SwitchLabel extends Label {

    public SwitchLabel(int num) {
        super("s_label" + SwitchStatementCounter.count + "" + num);
    }
}
