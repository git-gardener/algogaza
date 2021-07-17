import java.util.*;
import java.lang.Integer;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<Integer>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        // 장르 --> 노래 --> 고유번호
        // 1. 많이 재생된 장르
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int    play = plays[i];
            
            if(genreMap.get(genre) == null){
                genreMap.put(genre, play);   
            }else{
                genreMap.put(genre, genreMap.get(genre) + play);   
            }
        }
        
        // 장르별로 2건씩 선택
        while(!genreMap.isEmpty()){
            String mostPlayedGenre = selectMostPlayedGenre(genreMap);
            genreMap.remove(mostPlayedGenre);    
            // System.out.println(mostPlayedGenre);
            
            int num = selectMostPlayed(genres, plays, mostPlayedGenre); 
            answer.add(num);
            plays[num] = -1;
            
            num = selectMostPlayed(genres, plays, mostPlayedGenre); 
            if(num != -1){
                answer.add(num);
                plays[num] = -1;    
            }
        }
        
        int[] result = answer.stream().mapToInt(i->i).toArray();
        
        return result;
    }
    
    public String selectMostPlayedGenre(Map<String, Integer> map){
        String mostPlayedGenre = "";
        int    most = -1;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if( most < entry.getValue()){
                // 모든 장르는 재생된 횟수가 다름
                mostPlayedGenre = entry.getKey();
                most = entry.getValue();
            }
        }
        
        return mostPlayedGenre;
    }
    
    // 2. 많이 재생된 노래
    public int selectMostPlayed(String[] genres, int[] plays, String mostPlayedGenre){
        int num = -1;
        int selectPlay = -1;
            
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int    play  = plays[i];

            if(genre.equals(mostPlayedGenre)){
                if(play > selectPlay){
                    // 3. 고유번호 
                    // 먼저 선택된 대상이 다음 대상과 play 횟수가 같을 경우 현재 값이 선택되기에 연산 X
                    num = i;
                    selectPlay = play;
                }
            }
        }
        
        return num;
    }
}
