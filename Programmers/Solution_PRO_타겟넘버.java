class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    public void dfs(int idx, int sum, int target, int[] numbers) {
        if(sum == target && idx == numbers.length) {
            answer++;
            return;
        }
        
        if(idx<numbers.length) {
            dfs(idx+1, sum + numbers[idx], target, numbers);
            dfs(idx+1, sum - numbers[idx], target, numbers);
        }
    }
}