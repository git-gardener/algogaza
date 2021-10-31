import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 1;
        //ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : scoville){
            //list.add(a);
            pq.add(a);
        }

        int firstNum = 0;
        int secondNum = 0;
        int result = 0;
        while(true){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            //firstNum = Collections.min(list);
            //list.remove(Collections.min(list));
            //secondNum = Collections.min(list);
            //list.remove(Collections.min(list));
            firstNum = pq.poll();
            secondNum = pq.poll();
            result = firstNum + (secondNum * 2);
            pq.add(result);

            if(pq.peek() >= K)
                break;
            else
                answer++;
        }
        return answer;
    }
}