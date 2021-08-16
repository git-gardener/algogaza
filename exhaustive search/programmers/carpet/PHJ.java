class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];
        
        for(int i=sum;i>0;i--){
            if(sum % i == 0){
                if((i - 2) * ((sum / i) - 2) == yellow){
                    if(i >= sum/i){
                        answer[0] = i;
                        answer[1] = sum/i;                           
                    }
                }
            }
        }
        
        return answer;
    }
    
    
}
