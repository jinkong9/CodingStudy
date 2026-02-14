// 백준 1182번 : 부분수열의 합
package SeonMin.Backjoon;

import java.util.*;
import java.io.*;

public class B_1182_부분수열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		int[] resultArr = new int[N];
		int S = Integer.parseInt(st.nextToken());

		line = br.readLine();
		st = new StringTokenizer(line);
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Recur_list(numbers, 0, resultArr, 0, S);
		System.out.println(answer);
	}

	public static int Recur_list(int[] array, int index, int[] result, int k, int total) {
		// 재귀 끝내기
		int sum = 0;
		int count = 0;
		
		if (index == array.length) {
			if(k == 0) return 0;
			
			for (int i = 0; i < k; i++) {
				sum += result[i];
			}
			if (sum == total) {
				return 1;
			} else {
				return 0;
			}
		}

		// 선택하기
		result[k] = array[index];
		count += Recur_list(array, index + 1, result, k + 1, total);

		// 선택안하기
		count += Recur_list(array, index + 1, result, k, total);

		return count;
	}

}
