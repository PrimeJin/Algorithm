import java.util.*;
class Solution {
    static boolean[][] connect;
    static boolean[] check;
    static int count;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        connect = new boolean[n+1][n+1];
        
        //전력망 연결상태 초기화
        for(int i=0; i<wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;
        }
        
        //전력망 연결 하나씩 끊어보기
        for(int i=0; i<wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = false;
            connect[wires[i][1]][wires[i][0]] = false;
            
            check = new boolean[n+1];
            count = 0;
            dfs(1, 1, n, wires);
            int cnt1 = count;  //1을 포함한 전력망 개수
            int cnt2 = n - cnt1;  //1을 포함하지 않는 전력망 개수
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
            
            //끊어뒀던 전력망 다시 연결처리
            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;
        }
        
        return answer;
    }
    
    public void dfs(int idx, int cnt, int n, int[][] wires) {
        check[idx] = true;
        count++;
        
        for(int i=1; i<=n; i++) {
            if(!check[i] && connect[idx][i]) {
                dfs(i, cnt+1, n, wires);
            }
        }
        
    }
}