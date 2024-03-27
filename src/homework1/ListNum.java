/*
Задача 1.
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

package homework1;

import java.util.Arrays;
import java.util.List;

public class ListNum {

    public static void main(String[] args) {

        List<Integer> numberslist = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(averageOfEvenNumbers2(numberslist));

    }

    public static double averageOfEvenNumbers2(List<Integer> numbers){

        return numbers
                .stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .average()
                .getAsDouble();

    }

}