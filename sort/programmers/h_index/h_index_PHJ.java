import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n      = citations.length;
        
        List<Integer> citationsForSort = new ArrayList<Integer>();
        
        for(int citation : citations){
            citationsForSort.add(citation);
        }
        System.out.println(citationsForSort.toString());
        Collections.sort(citationsForSort);
        Collections.reverse(citationsForSort);
        
        // System.out.println(citationsForSort.toString());
        if(citationsForSort.get(n-1) >= n){
            return n;    
        }
        
        // System.out.println(citationsForSort);
        
        for(int i=0; i<citationsForSort.size(); i++){
            int h = i+1;
            
            // System.out.println("h : " + h + ", " + citationsForSort.get(i));
            if(citationsForSort.get(i) >= h){
                answer++;
            }else{
                return answer;
            }
        }
        
        return answer;
    }
}
