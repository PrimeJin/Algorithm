import java.util.*;
class Solution {
    static boolean[][] connect;
    static boolean[] check;
    static int count;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        connect = new boolean[n+1][n+1];
        
        
        for(int i=0; i<wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;
        }
        
        
        for(int i=0; i<wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = false;
            connect[wires[i][1]][wires[i][0]] = false;
            
            check = new boolean[n+1];
            count = 0;
            dfs(wires[i][0], 1, n, wires);
            int cnt1 = count;
            int cnt2 = n - cnt1;
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
            
            connect[wires[i][0]][wires[i][1]] = false;
            connect[wires[i][1]][wires[i][0]] = false;
        }
        
        return answer;
    }
    
    public void dfs(int idx, int cnt, int n, int[][] wires) {
        check[idx] = true;
        count = Math.max(count, cnt);
        
        for(int i=1; i<=n; i++) {
            if(!check[i] && connect[idx][i]) {
                dfs(i, cnt+1, n, wires);
            }
        }
        
    }
}