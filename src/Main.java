import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        String instruction = "Input a number:";
        System.out.println(instruction);
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        final int arraySize = 10;
        int[] arr1 = getFilledArray(arraySize, input, (a, b) -> a + b);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = getFilledArray(arraySize, input, (a, b) -> a * b);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = getFilledArray(arraySize, input, (a, b) -> {
            if (a % 2 == 0) {
                return a / 2 + b;
            } else {
                return a * a - b;
            }
        });
        System.out.println(Arrays.toString(arr3));
//  число = модификатор в степени индекса
        int[] arr4 = getFilledArray(arraySize, input, (a, b) -> {
            int c = b;
            for (int j = 0; j < a; j++) {
                c = c * b;
            }
            return c;
        });
        System.out.println(Arrays.toString(arr4));
/*
    число = случайное число в диапазоне суммы индекса и модификатора, если эта сумма больше 0,
        или случайное число в диапазоне длины массива, если сумма индекса не положительная
*/
        int[] arr5 = getFilledArray(arraySize, input, (a, b) -> {
            if (a + b > 0) {
                return new Random().nextInt(a + b);
            } else {
                return new Random().nextInt(arraySize);
            }
        });
        System.out.println(Arrays.toString(arr5));
        in.close();
    }

    public static int[] getFilledArray(final int arraySize, final int input, final Modifier modifier) {
        int[] theArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = modifier.process(i, input);
        }
        return theArray;
    }

}
