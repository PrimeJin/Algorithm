import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(i % 2 == 0) {  //최대pq에 먼저 값넣기
                maxPq.offer(num);
            } else {  //그다음 최소pq에 값 넣기
                minPq.offer(num);
            }

            if(i>=1 && maxPq.peek() > minPq.peek()) {  //최대pq의 최대값이 최소pq의 최소값보다 크면 서로 값교환
                int tmp = maxPq.poll();
                maxPq.offer(minPq.poll());
                minPq.offer(tmp);
            }
            sb.append(maxPq.peek()).append("\n");  //현재까지 진행된 값들 중 (조건에 해당하는) 중간값은 최대pq의 최대값(peek)임
        }
        System.out.print(sb);
    }
}
