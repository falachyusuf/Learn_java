public class GenericsAny <T> implements LookUp<Integer>{
    private T value1;
    private T value2;

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public void setValue2(T value2) {
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }

    @Override
    public Integer Look(Integer value1, Integer value2) {
        int result = value1 + value2;
        return result;
    }

}
