import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            cnt = 0;
            dfs(n, 0);
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int target, int cur) {
        if(cur == target) {
            cnt++;
            return;
        }

        if(cur > target) return;

        for(int i=1; i<=3; i++) {
            dfs(target, cur + i);
        }
    }
}
