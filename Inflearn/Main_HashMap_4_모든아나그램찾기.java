import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_HashMap_4_모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        int count = 0;
        HashMap<Character, Integer> word1 = new HashMap<>();
        HashMap<Character, Integer> word2 = new HashMap<>();

        for(char x : str2.toCharArray()) {
            word2.put(x, word2.getOrDefault(x, 0) + 1);
        }
        int lt=0;
        int len = str2.length();
        for(int rt=len; rt<str1.length(); rt++) {
            word1.put(str1.charAt(rt), word1.getOrDefault(str1.charAt(rt), 0) + 1);
            if(word1.equals(word2)) {
                count++;
            }
            word1.put(str1.charAt(lt), word1.get(str1.charAt(lt))-1);
            lt++;
        }
        return count;
    }
}
