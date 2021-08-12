import java.util.*;
class Solution {
    public StringBuffer getAnswer(int unit, int queNum,StringBuffer supoza){
        int namuzi = queNum % unit;
        if(queNum >= unit){
            for(int i = 1 ; i < (queNum/unit) ; i++)
                supoza.append(supoza);
            for(int i = 0 ; i < namuzi ; i++){
                String tmp = supoza.substring(namuzi);
                supoza.append(tmp);
            }
        }
        return supoza;
    }
    public int[] solution(int[] answers) {

        StringBuffer supoza1 = new StringBuffer("12345");
        StringBuffer supoza2 = new StringBuffer("21232425");
        StringBuffer supoza3 = new StringBuffer("3311224455");
        int ans1=0,ans2=0,ans3=0;
        supoza1 = getAnswer(5,answers.length,supoza1);
        supoza2 = getAnswer(8,answers.length,supoza2);
        supoza3 = getAnswer(10,answers.length,supoza3);

        for(int i = 0 ; i < answers.length; i++){
            if(answers[i] == supoza1.charAt(i)-'0')
                ans1 += 1;
            if(answers[i] == supoza2.charAt(i)-'0')
                ans2 += 1;
            if(answers[i] == supoza3.charAt(i)-'0')
                ans3 += 1;
        }

        ArrayList<Integer> suList = new ArrayList<>();
        suList.add(ans1);
        suList.add(ans2);
        suList.add(ans3);

        int max = ans1;
        for(int i = 0 ; i < 2;i++){
            int tmp = suList.get(i);
            if(tmp > max){
                max = tmp;
            }
        }
        suList.clear();
        if(ans1 == max) suList.add(1);
        if(ans2 == max) suList.add(2);
        if(ans3 == max) suList.add(3);

        int[] answer = suList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}