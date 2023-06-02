import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] dp = new int[11];  //n<11
        
        dp[1] = 1;  //1
        dp[2] = 2;  //1+1, 2
        dp[3] = 4;  //1+1+1, 1+2, 2+1, 3
        
        for(int i=4; i<11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case=0; test_case<t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n"); 
        }
        System.out.print(sb);
    }
}