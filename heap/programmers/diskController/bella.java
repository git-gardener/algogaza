import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[jobs.length];

        visited[0] = true;
        pq.add(jobs[0][1]);
        int tm = 0;
        int st = jobs[0][0];

        for(int i = 1 ; i < jobs.length; i++){
            if(visited[i] == false && jobs[i][0] == jobs[0][0]){
                pq.add(jobs[i][1]);
                visited[i] = true;
                st += jobs[i][0];
            }
        }

        while(!pq.isEmpty()){
            //System.out.println(pq);
            tm += pq.poll();
            answer += tm;
            for(int i = 1 ; i < jobs.length; i++){
                if(visited[i] == false && jobs[i][0] <= tm){
                    pq.add(jobs[i][1]);
                    visited[i] = true;
                    st += jobs[i][0];
                }
            }
            if(pq.isEmpty()){
                for(int i = 1 ; i < jobs.length;i++){
                    if(visited[i] == false){
                        pq.add(jobs[i][1]);
                        visited[i] = true;
                        st += jobs[i][1];
                        break;
                    }
                }
            }
        }
        answer = (answer-st)/jobs.length;
        return answer;
    }
}