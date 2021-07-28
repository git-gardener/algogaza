import java.util.Arrays;
import java.util.HashSet;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(int i=0;i<computers.length;i++){
            int[] computer = computers[i];
            
            for(int j=0;j<computer.length;j++){
                if(computer[j] == 1){
                    union(i, j);
                    //System.out.println(i + ", " + j);
                }
            }
        }
        
        HashSet set = new HashSet();
        for(int i=0;i<parent.length;i++){
            // computers[ i ][ j ] != computers[ j ][ i ] 
            // 한쪽만 연결된 비대칭 선분이 있어.. getParent 재수행
            parent[i] = find(parent[i]);
            set.add(parent[i]);
        }
        
        //System.out.println(Arrays.toString(parent));
        int answer = set.size();
        return answer;
    }
    
    public int find(int a){
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
}
