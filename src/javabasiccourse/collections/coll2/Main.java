package javabasiccourse.collections.coll2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность
в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int num = 0;
        while (scanner.hasNextInt()){
            if (num % 2 == 1) {
                result.add(scanner.nextInt());
            }
            else {
                scanner.nextInt();
            }
            num ++;
        }
        for (int i = result.size() - 1; i >=0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
