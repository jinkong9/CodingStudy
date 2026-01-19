package SeongJin;
import java.io.*;
import java.util.*;

public class Solution {
	public static int change(int arr[], int idx) {
		return arr[idx] = 1 - arr[idx];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st1.nextToken());
			int num = Integer.parseInt(st1.nextToken());
			
			if(sex == 1) {
				for(int j=num; j<=T; j+=num) {
					change(arr, j-1);
				}
			} else {
				int center = num-1;
				change(arr, center);
				int d = 1;
				while(center-d >=0 && center+d <T && arr[center-d] == arr[center+d]) {
					change(arr, center-d);
					change(arr, center+d);
					d++;
				}
			}
		}
		for(int i=0; i<T; i++) {
			System.out.print(arr[i] + " ");
			if(i == 20) {
				System.out.print("\n");
				System.out.println(1);
				
			}
		}
	}
}
