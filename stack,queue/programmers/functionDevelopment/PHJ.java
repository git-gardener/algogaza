import java.util.*;

class Solution {
    
    class Progress{
        int progress;
        int speed;
        
        Progress(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }

        public boolean solution(int day){
            return this.progress + this.speed * day >= 100;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        if(progresses.length == 0){
            return null;
        }
        
        int[] answer = {};
        // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,         
        // 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
        
        Queue<Progress> queue    = new LinkedList<>();
        Queue<Integer>  ansQueue = new LinkedList<>();
        
        int day   = 0;
        
        for(int i=0;i<progresses.length;i++){
            queue.add(new Progress(progresses[i], speeds[i]));
        }
        
        while(queue.size() > 0){
            day++;
            int count = 0;
            
            while(   queue.size() > 0 
                  && queue.peek().solution(day)){
                queue.poll();
                count++;
            }

            if(count != 0){
                ansQueue.add(count);    
            }
        }
        
        answer = new int[ansQueue.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ansQueue.poll();
        }
        return answer;
    }
}
