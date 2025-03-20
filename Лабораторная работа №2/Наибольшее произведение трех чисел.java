import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] result = findMaxProductTriplet(arr);
        Arrays.sort(result);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    public static int[] findMaxProductTriplet(int[] arr) {
        Arrays.sort(arr);

        long option1 = (long) arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
        long option2 = (long) arr[0] * arr[1] * arr[arr.length - 1];

        if (option1 >= option2) {
            return new int[] {arr[arr.length - 3], arr[arr.length - 2], arr[arr.length - 1]};
        } else {
            return new int[] {arr[0], arr[1], arr[arr.length - 1]};
        }
    }
}
