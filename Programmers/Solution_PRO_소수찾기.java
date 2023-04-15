import java.util.*;
class Solution {
    static int[] number;
    static boolean[] check;
    static Set<Integer> set = new HashSet<>();  //Set으로 만들어지는 값들 중 중복제거
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        number = new int[len];
        check = new boolean[len];
        
        //종이 조각 숫자 배열로 만들기
        for(int i=0; i<len; i++) {
            number[i] = numbers.charAt(i) - '0';
        }
        
        dfs("", numbers);
        
        //소수인지 판단하기
        Iterator<Integer> iter = set.iterator();  //Iterator안에 set담기
        while(iter.hasNext()) {
            int tmpNum = iter.next();
            if(tmpNum == 1 || tmpNum == 0) continue;
            System.out.println(tmpNum);
            boolean flag = false;
            for(int i=2; i<tmpNum; i++) {
                if(tmpNum%i == 0) {
                    flag = true;
                    break;
                } 
            }
            
            if(!flag) {  //소수이면 answer +1처리
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String num, String numbers) {
        if(!num.equals("")) {  //가능한 모든 숫자 경우의 수 추가
            int intNum = Integer.parseInt(num);  //숫자로 변환하여 앞에 0나오는 경우처리
            set.add(intNum);
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(num + number[i], numbers);
                check[i] = false;
            }
        }
    }
}