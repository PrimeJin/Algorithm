import java.util.*;
import java.io.*;

public class Main_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Str[] strArr = new Str[N];
        for(int i=0; i<N; i++) {
            String tmp = br.readLine();
            strArr[i] = new Str(i, tmp, tmp.length());
        }
        
        //문자열.compareTo(문자열) - 사전순 정렬
        Arrays.sort(strArr, (o1,o2) -> o1.len==o2.len? o1.word.compareTo(o2.word) : o1.len - o2.len); 
        
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0].word).append("\n");
        //중복제거 출력
        for(int i=1; i<N; i++) {
        	if(!strArr[i].word.equals(strArr[i-1].word)) {
        		sb.append(strArr[i].word).append("\n");
        	}
        }
        
        System.out.print(sb);
    }
    
    static class Str {
        int idx;
        String word;
        int len;
        
        public Str(int idx, String word, int len) {
            this.idx = idx;
            this.word = word;
            this.len = len;
        }
    }
}