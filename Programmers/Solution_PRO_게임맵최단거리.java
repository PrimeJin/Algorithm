import java.util.*;
class Solution {
    static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
    static int[] dx = {1, 0, -1, 0};  //우 하 좌 상
    static int n, m;  //n:세로 길이, m:가로 길이
    static boolean[][] check;
    static boolean goal;  //상대방에게 도달할 수 있는지 여부
    static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        check = new boolean[n][m];
        bfs(0, 0, maps);
        if(!goal) return -1;  //상대방에게 도착할 수 없는 경우 -1 리턴
        return answer;
    }
    
    public static void bfs(int y, int x, int[][] maps) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(y, x, 1));
        check[y][x] = true;        
        
        while(!queue.isEmpty()) {
            Position cur = queue.poll();
            answer++;
            
            if(cur.y == n-1 && cur.x == m-1) {
                answer = cur.cost;
                goal = true;
                return;
            }
            
            for(int i=0; i<4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int cost = cur.cost;
                if(0<=ny&&ny<n && 0<=nx&&nx<m && !check[ny][nx] && maps[ny][nx] == 1) {
                    check[ny][nx] = true;
                    queue.offer(new Position(ny, nx, cost+1));
                }
                
            }
        }
    }
    
    static class Position {
		int y;
		int x;
        int cost;  //이동한 칸 수
		
		public Position(int y, int x, int cost) {
			this.y = y;
			this.x = x;
		    this.cost = cost;
        }
	}
}

