package javabasiccourse.collections.coll1;

import java.util.HashSet;
import java.util.Set;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
*/
public class Main {
    public static void main(String[] args) {
        Set set1 = new HashSet();
        for (int j : new int[]{1, 2, 5}) set1.add(j);
        Set set2 = new HashSet();
        for (int i : new int[]{0, 4, 2}) set2.add(i);
        Set res = symmetricDifference(set1, set2);
        System.out.println(res);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> s1 = new HashSet<>(set1);
        s1.removeAll(set2);
        Set<T> s2 = new HashSet<>(set2);
        s2.removeAll(set1);
        s1.addAll(s2);
        return s1;
    }
}
