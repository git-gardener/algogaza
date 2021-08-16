import java.util.*;
class Solution {
    public char getAnswer(int unit, int answer){
        int namuzi = answer%unit;
        if(unit == 5){
            switch(namuzi){
                case 1: return '1';
                case 2: return '2';
                case 3: return '3';
                case 4: return '4';
                case 0: return '5';
                default: return '0';
            }
        }else if(unit == 8){
            switch(namuzi){
                case 1: return '2';
                case 2: return '1';
                case 3: return '2';
                case 4: return '3';
                case 5: return '2';
                case 6: return '4';
                case 7: return '2';
                case 0: return '5';
                default: return '0';
            }
        }else if(unit == 10){
            switch(namuzi){
                case 1: return '3';
                case 2: return '3';
                case 3: return '1';
                case 4: return '1';
                case 5: return '2';
                case 6: return '2';
                case 7: return '4';
                case 8: return '4';
                case 9: return '5';
                case 0: return '5';
                default: return '0';
            }
        }
        return '0';
    }
    public int[] solution(int[] answers) {
        char supoza1 = ' ';
        char supoza2 = ' ';
        char supoza3 = ' ';
        int ans1=0,ans2=0,ans3=0;
        for(int i = 0 ; i < answers.length; i++){
            supoza1 = getAnswer(5,i+1);
            supoza2 = getAnswer(8,i+1);
            supoza3 = getAnswer(10,i+1);
            if(answers[i] == supoza1-'0')
                ans1 += 1;
            if(answers[i] == supoza2-'0')
                ans2 += 1;
            if(answers[i] == supoza3-'0')
                ans3 += 1;
        }
        ArrayList<Integer> suList = new ArrayList<>();
        suList.add(ans1);
        suList.add(ans2);
        suList.add(ans3);

        int max = ans1;
        for(int i = 0 ; i < 3;i++){
            int tmp = suList.get(i);
            if(tmp > max){
                max = tmp;
            }
        }
        suList.clear();
        if(ans1 == max) suList.add(1);
        if(ans2 == max) suList.add(2);
        if(ans3 == max) suList.add(3);
        if(max == 0) suList.clear();
        int[] answer = suList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}