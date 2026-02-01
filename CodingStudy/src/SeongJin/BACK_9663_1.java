package SeongJin;

import java.io.*;
import java.util.*;


public class BACK_9663_1 {
	static int T;
	static int[] arr;
	static int cnt =0;
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[T];
		dfs(0);
		System.out.println(cnt);
	}
	
	static boolean visted(int row) {
		for (int i = 0; i < row; i++) {
			if(arr[i] == arr[row]) return false;
			
			if(Math.abs(row -i) == Math.abs(arr[row] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	static void dfs(int row) {
		if(row == T) {
			cnt++;
			return;
		}
		
		for(int i=0; i<T; i++) {
			arr[row] = i;
			if(visted(row)) {
				dfs(row+1);
			}
		}
	}

}
