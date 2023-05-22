import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //우선순위 큐 이용
        for(int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if(N == 1) {  //카드 묶음이 1개인 경우
            int num = pq.poll();
            System.out.print(num==1?0:num);  //카드가 1장일 때는 비교할 필요가 없으므로 0출력
        } else {  //카드 묶음이 여러개인 경우
            int sum = 0;
            while(!pq.isEmpty()) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                sum += num1+num2;  //두 개의 카드묶음 비교횟수
                if(!pq.isEmpty()) {
                    pq.offer(num1+num2);  //다음으로 비교할 묶음이 있으면 pq에 sum추가
                }
            }
            System.out.print(sum);
        }
    }
}
