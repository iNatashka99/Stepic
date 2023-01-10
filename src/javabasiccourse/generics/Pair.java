package javabasiccourse.generics;

import java.util.Objects;

/*
Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не
запрещающий элементам принимать значение null.
Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод
of(). Конструктор должен быть закрытым (private).
*/
public class Pair <Type1, Type2> {
    private final Type1 value1;
    private final Type2 value2;

    private Pair(Type1 val1, Type2 val2) {
        value1 = val1;
        value2 = val2;
    }

    public Type1 getFirst() {
        return value1;
    }

    public Type2 getSecond() {
        return value2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Pair<?, ?> other = (Pair<?, ?>) obj;
        return obj != null
                && Objects.equals(value1, other.value1)
                && Objects.equals(value2, other.value2);
    }

    @Override
    public int hashCode() {
        return 31 * (value1 != null ? value1.hashCode() : 0) + (value2 != null ? value2.hashCode() : 0);
    }

    public static <Type1, Type2> Pair<Type1, Type2> of(Type1 val1, Type2 val2) {
        return new Pair<>(val1, val2);
    }
}

