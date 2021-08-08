import java.util.Arrays;
class Solution {
    static public boolean[] visited;
    static public int answer = 0;

    public boolean diffCheck(String begin, String target){
        int diffCnt = 0;
        for(int i = 0 ; i < begin.length(); i++)
            if(begin.charAt(i) != target.charAt(i)) diffCnt++;

        return diffCnt == 1? true:false;
    }

    public int dfs(String std, String target, String[] words, int cnt){
        if(std.equals(target)){
            answer = cnt;
            return cnt;
        }

        for(int i = 0 ; i < words.length; i++){
            if(!visited[i] && diffCheck(std,words[i])){
                visited[i] = true;
                dfs(words[i],target,words,cnt+1);
                visited[i] = false;
            }
        }
         return 0;
    }

    public int solution(String begin, String target, String[] words){
        visited = new boolean[words.length];
        if(!Arrays.asList(words).contains(target)) return answer;
        dfs(begin,target,words,0);
        return answer;
    }
}