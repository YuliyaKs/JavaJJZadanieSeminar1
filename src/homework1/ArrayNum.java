/*
Задача 1.
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

package homework1;

import java.util.Arrays;

public class ArrayNum {

    public static void main(String[] args) {

        int[]  numbersArray = {1, 2, 3, 4, 5, 6 ,7, 8, 9, 10};
        System.out.println(averageOfEvenNumbers1(numbersArray));

    }

    public static double averageOfEvenNumbers1(int[] numbers){

        return Arrays
                .stream(numbers)
                .filter(numb -> numb % 2 == 0)
                .average().getAsDouble();

    }

}