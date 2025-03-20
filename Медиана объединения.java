import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);
        
        List<int[]> sequences = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] seq = reader.readLine().split(" ");
            int[] sequence = new int[L];
            for (int j = 0; j < L; j++) {
                sequence[j] = Integer.parseInt(seq[j]);
            }
            sequences.add(sequence);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                List<Integer> merged = new ArrayList<>();
                for (int num : sequences.get(i)) {
                    merged.add(num);
                }
                for (int num : sequences.get(j)) {
                    merged.add(num);
                }
                
                Collections.sort(merged);
                System.out.println(merged.get(L - 1));
            }
        }
    }
}
