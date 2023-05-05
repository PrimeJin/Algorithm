import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int num = 1;
        while(num <= Math.sqrt(yellow)) {  //가로 길이가 세로 길이보다 길거나 같아야됨
            if(yellow % num != 0) {  //yellow의 약수가 아닌 경우 제외
                num++;
                continue;
            }
            int x = yellow / num;
            int y = num;
            
            int brownX = x+2;
            int brownY = y+2;
            
            int brownCnt = 2*(brownX+brownY) - 4;  //총 갈색 격자의 수 
            if(brownCnt == brown) {
                answer[0] = brownX;
                answer[1] = brownY;
                break;
            }
            num++;
        }
        
        return answer;
    }
}