import java.util.*;
import java.lang.Integer;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<clothes.length;i++){
            Integer count = map.get(clothes[i][1]);
            
            if(count == null){
                map.put(clothes[i][1], 1);    
            }else{
                map.put(clothes[i][1], count + 1);    
            }
        }
        
        // System.out.println(map.toString());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // System.out.println(entry.getValue());
	        answer *= (entry.getValue() + 1);
        }
        
        answer -= 1;
        
        // System.out.println(map.toString());
        return answer;
    }
}
