import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;
        
        List<Request> list = new ArrayList<>();
        for(int i=0; i<size; i++) {
            list.add(new Request(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(list, (o1, o2) -> o1.takeTime==o2.takeTime? (o1.start - o2.start):(o1.takeTime - o2.takeTime));
        
        int endPoint = list.get(0).start;
        int[] arr = new int[size];
        int sum = 0;
        for(int i=0; i<size; i++) {
            arr[i] = (endPoint - list.get(i).start)  + list.get(i).takeTime; 
            
            endPoint += list.get(i).takeTime;
            sum += arr[i];
        }
        
        answer = sum / size;
        return answer;
    }
    
    public class Request {
        int start;
        int takeTime;
        
        public Request(int start, int takeTime) {
            this.start = start;
            this.takeTime = takeTime;
        }
    }
}