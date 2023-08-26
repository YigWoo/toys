package ast;

import org.assertj.core.util.Arrays;

public class TestASTViewClass {
    public static class U {
        public Integer res = 0;
    }

    public static class Z {
        public String str = "zstr";
        public Integer integer = 0;
        public String[] list = Arrays.array("a", "b", "c");
        public U methodU() {
            return new U();
        }
    }

    public static class Y {
        public Z z;
    }

    public static class X {
        public Double aDouble = 1.0;
        public Y y;
    }
}
