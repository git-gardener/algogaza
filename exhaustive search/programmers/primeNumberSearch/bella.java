import java.util.*;

class Solution {
    boolean[] visited;
    int[] output;
    int answer;
    ArrayList<Integer> answerlist;

    public boolean checkPrime(int number){
        if(number < 2) return false;
        for(int i = 2 ; i*i <= number; i ++)
            if(number%i == 0) return false;
        return true;
    }
    public int addNums(int selNum){
        int result = 0;
        for(int i = 1; i <= selNum;i++)
            result += (Math.pow(10,selNum-i))*output[i-1];
        return result;
    }
    public void selectNumber(int[] number,int idx,int selNum){
        int n = addNums(selNum);
        if(idx == selNum){
            if(checkPrime(n)){
                if(!answerlist.contains(n)){
                    answerlist.add(n);
                    answer++;
                }
            }
            return;
        }

        for(int i = 0 ; i < number.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                output[idx] = number[i];
                selectNumber(number,idx+1,selNum);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        int numsLen = numbers.length();
        visited = new boolean[numsLen];
        output = new int[numsLen];
        answer = 0;
        int[] number = new int[numsLen];
        answerlist = new ArrayList<Integer>();

        for(int i = 0 ; i < number.length ; i ++)
            number[i] = numbers.charAt(i)-'0';

        for(int i = 1 ; i <= number.length ; i++)
            selectNumber(number,0,i);

        return answer;
    }
}