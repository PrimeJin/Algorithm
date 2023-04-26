import java.util.*;
    public class Main_DFS_가장가까운큰수 {
        static int len;
        static boolean[] visited;  //방문 체크 배열
        static List<Integer> list;  //순열 경우의 수 담은 list
        static boolean flag;  //n보다 큰 수가 나온이상 넘기기 위한 flag
        public int solution(int n){
            //정수 각 자리수 배열에 담기
            String nStr = "" + n;
            len = nStr.length();
            visited = new boolean[len];
            list = new ArrayList<>();
            int[] intArr = new int[len];

            for(int i=0; i<len; i++) {
                intArr[i] = nStr.charAt(i) - '0';
            }

            Arrays.sort(intArr);  //오름차순 정렬
            flag = false;
            dfs(0, 0, intArr, n);

            return list.size()==0?-1:list.get(0);  //list 중에서 n보다 큰 수 없으면 -1반환
        }

        public void dfs(int level, int result, int[] intArr, int n) {
            if(flag) return;

            if(level == len) {
                if(result > n) {
                    list.add(result);
                    flag = true;
                }
                return;
            }

            for(int i=0; i<len; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(level + 1,  result*10 + intArr[i], intArr, n);
                    visited[i] = false;
                }
            }
        }

        public static void main(String[] args){
            Main_DFS_가장가까운큰수 T = new Main_DFS_가장가까운큰수();

            //정답 테스트케이스 출력
            System.out.println(T.solution(123));  //132
            System.out.println(T.solution(321));  //-1
            System.out.println(T.solution(20573));  //20735
            System.out.println(T.solution(27711));  //71127
            System.out.println(T.solution(54312));  //54321
        }
    }
