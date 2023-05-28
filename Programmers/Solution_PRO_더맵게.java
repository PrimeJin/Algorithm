import java.util.*;
class Solution {
    static int K;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int count = 0;  //음식 섞는 횟수
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(a >= K) {
                break;
            }
            if(pq.isEmpty() && a<K) {  //모든 음식의 스코빌을 K이상으로 못만들 경우는 -1 return
                return -1;
            }
            int b = pq.poll();
            
            int scov = a + (b*2);
            pq.offer(scov);
            count++;
        }
        
        return count;
    }
}