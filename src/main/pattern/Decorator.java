package main.pattern;

public class Decorator {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Decorator d = new Decorator();
        OptionalWrapper something = d.new OptionalThree(
                d.new OptionalTwo(
                        d.new OptionalOne(
                                d.new CoreFunctionality())));
    }

    interface Interface {
        void doThis();
    }

    class CoreFunctionality implements Interface {
        public void doThis() {}
    }

    class OptionalWrapper implements Interface {
        public void doThis() {}
    }

    class OptionalOne extends OptionalWrapper {
        OptionalOne(CoreFunctionality o) {}
        public void doThis() {
            super.doThis();
        }
    }

    class OptionalTwo extends OptionalWrapper {
        OptionalTwo(OptionalOne o) {}
        public void doThis() {
            super.doThis();
        }
    }

    class OptionalThree extends OptionalWrapper {
        OptionalThree(OptionalTwo o) {}
        public void doThis() {
            super.doThis();
        }
    }
}