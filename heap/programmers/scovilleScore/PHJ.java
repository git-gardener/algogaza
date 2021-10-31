import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0;i<scoville.length;i++){
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K){
            if(queue.size() < 2){
                return -1;
            }
            
            int num  = queue.poll();
            int num2 = queue.poll() * 2;
            
            queue.add(num + num2);
            answer++;
        }
    
        return answer;
    }
    
}
