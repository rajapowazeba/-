import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        String[] cStr = reader.readLine().split(" ");
        int k = Integer.parseInt(reader.readLine());
        String[] pStr = reader.readLine().split(" ");
        
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(cStr[i]);
        }
        
        int[] presses = new int[n];
        for (int i = 0; i < k; i++) {
            int key = Integer.parseInt(pStr[i]) - 1;
            presses[key]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (presses[i] > c[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
