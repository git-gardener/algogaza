import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(String numbers) {
		String str = numbers;
		int n = str.length();
		char[] charArr = str.toCharArray();
		int[] arr = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = (charArr[i] - 48);
		}
		
		for(int i = 1; i <= n; i++) {
			permutation(arr, 0, n, i, set);
		}
		int max = Collections.max(set);
		
		boolean[] eratostenes = new boolean[max+1];
		
		eratostenes[0] = eratostenes[1] = false;
		for(int i = 2; i <= max; i+=1) {
			eratostenes[i] = true;
		}
		
		for(int i = 2; i*i <= max; i+=1) {
			for(int j = i*i; j <= max; j+=i) {
				eratostenes[j] = false;
			}
		}
		
		Iterator<Integer> iter = set.iterator();
		
		int result = 0;
		while(iter.hasNext()) {
			int num = iter.next();
			if(eratostenes[num]) {
				result++;
			}
		}
        return result;
    }
    
    static void permutation(int[] arr,  int depth, int n, int r, HashSet set) {
		if(depth == r) {
			mkInt(arr,r,set);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r, set);
			swap(arr, depth, i);
		}
	}
	
	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	
	static void mkInt(int[] arr, int r, HashSet set) {
		String str = "";
		
		for(int i = 0; i < r; i++) {
			str += arr[i];
		}
		
		while(str.startsWith("0")) {
			str = str.substring(1);
		}
		if(str.equals("")||str == null) {
			
		}else {
			int strToInt = Integer.parseInt(str); 
			set.add(strToInt);
		}
	}
}
