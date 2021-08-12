class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int max = brown + yellow;

        for(int i = 3; i <= max / 2;i++){
            if(max%i == 0){
                int wid = max / i;
                int hei = i;
                if((wid-2)*(hei-2) == yellow){
                    answer[0] = hei;
                    answer[1] = wid;
                }
            }
        }
        return answer;
    }
}