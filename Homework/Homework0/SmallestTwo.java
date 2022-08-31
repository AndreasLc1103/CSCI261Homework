import java.util.Scanner;

public class SmallestTwo {

    /**
     * @param inputStream
     */
    public static void smallestTwo(int[] inputStream) {
        // if input stream only has one value
        if (inputStream.length <= 1) {
            System.out.println(inputStream[0]);
        } else {
            // set smallest to be first
            int smallest = inputStream[0];
            // set second smallest
            int secondSmallest = inputStream[1];
            if (smallest > secondSmallest) {
                // swap so second smallest is greater
                int temp = smallest;
                // sets smallest to the smaller value
                smallest = secondSmallest;
                // this is set to be greater
                secondSmallest = temp;

            }
            // iterate the array and check the values
            for (int cursor = 0; cursor < inputStream.length; cursor++) {
                if (inputStream[cursor] < smallest) {
                    secondSmallest = smallest;
                    smallest = inputStream[cursor];
                } else if (inputStream[cursor] < secondSmallest && inputStream[cursor] > smallest) {
                    secondSmallest = inputStream[cursor];
                }
            }
            // print out the output of the dataset
            System.out.println(smallest);
            System.out.println(secondSmallest);
            
        }
    }

    public static void main(String[] args) {
        // create scanner instance
        Scanner input = new Scanner(System.in);
        // determines the length of the input stream
        int inputLength = input.nextInt();
        // creates a
        int[] numbers = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            numbers[i] = input.nextInt();
        }

        smallestTwo(numbers);
    }
}
