package ast;

import java.util.ArrayList;
import java.util.List;

public class TestASTView {
    public static void main(String[] args) {
        TestASTViewClass.X x = new TestASTViewClass.X();
        TestASTViewClass.Y y = new TestASTViewClass.Y();
        y.z = new TestASTViewClass.Z();
        x.y = y;

        List<String> list = new ArrayList<>();
        list.add("a");
        list.get(0);

        String[] s = new String[10];
        s[0] = "a";
    }

    private static String ToString(int sum) {
        return String.valueOf(sum);
    }
}
