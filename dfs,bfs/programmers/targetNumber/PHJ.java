import java.util.Arrays;
import java.util.Stack;

class Solution {
    
    public int solution(int[] numbers, int target) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(numbers).forEach(n -> stack.push(n));

        int answer = dfs(stack, target);
        
        return answer;
    }
    
    public int dfs(Stack<Integer> stack, int target){
        // System.out.println(target);
        // System.out.println(stack);
        
        if(stack.empty() == true) {
            if(target == 0){
                // System.out.println("들어옴");
                return 1;
            }else{
                return 0;   
            }
        }
        
        Stack<Integer> leftStack  = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();
        
        int popNumber  = stack.pop();
        int plus       = target + popNumber;
        int minus      = target - popNumber;
        
        while(!stack.empty()){
            popNumber = stack.pop();
            leftStack.push(popNumber);
            rightStack.push(popNumber);
        }
    
        int left  = dfs(leftStack, plus);
        int right = dfs(rightStack, minus);

        return left + right;
    }
    
}
