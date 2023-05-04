import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int N;
    static int countMinus=0, countZero=0, countPlus=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //행렬 초기화
        matrix = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(countMinus).append("\n").append(countZero).append("\n").append(countPlus);

        System.out.print(sb);
    }

    public static void recursive(int y, int x, int n) {
        if(n == 0) return;  //더이상 나눌 수 없을 때

        if(sameCheck(y, x, n)) {
            if(matrix[y][x] == -1) {
                countMinus++;
            } else if(matrix[y][x] == 0) {
                countZero++;
            } else if(matrix[y][x] == 1){
                countPlus++;
            }
            return;
        } else {
            n /= 3;
            for(int i=y; i<y+n*3; i+=n) {
                for(int j=x; j<x+n*3; j+=n) {
                    recursive(i, j, n);
                }
            }
        }

    }

    //분할된 구간 다른 숫자로 이뤄져있는지 확인
    public static boolean sameCheck(int y, int x, int n) {
        int num = matrix[y][x];
        for(int i=y; i<y+n; i++) {
            for(int j=x; j<x+n; j++) {
                if(num != matrix[i][j]) return false;
            }
        }
        return true;
    }
}
