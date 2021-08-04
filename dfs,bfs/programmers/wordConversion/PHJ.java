class Solution {
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        int answer = 0;
        answer = dfs(begin, target, words, -1);
        
        if(answer == 10000000){
            answer = 0;
        }
        return answer;
    }
    
    public int dfs(String begin, String target, String[] words, int idx){
        if(idx != -1){
            visited[idx] = true;    
        }
        
        if(begin.equals(target)){
            int result = 0;
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    result++;
                }
            }
            return result;
        }
        
        int result2 = 10000000;
        for(int i=0;i<words.length;i++){
            int count = stringEquals(begin, words[i]);
            
            int temp  = 1000000;
            
            if(count == 1 && !visited[i]){
                visited[i] = true;
                temp = dfs(words[i], target, words, i);
                visited[i] = false;
                
                if(result2 > temp){
                    result2 = temp;
                }
            }
        }
        
        return result2;
    }
    
    public int stringEquals(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        
        //System.out.println(a + ", " + b + ", " + count);
        return count;
    }
    
}
