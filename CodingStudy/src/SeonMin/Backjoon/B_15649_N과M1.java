// 백준 15649번 : N과 M (1)
package SeonMin.Backjoon;

import java.util.*;
import java.io.*;

public class B_15649_N과M1 {
	static int[] result;
	static boolean[] isSelected;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N+1];
		result = new int[M];

		SelectNumber(N, result, 0);

	}

	public static void SelectNumber(int number, int[] select, int k) {
		if (k == select.length) {
			for (int i : select) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= number; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				select[k] = i;
				SelectNumber(number, select, k + 1);
				isSelected[i] = false;
			}
		}
	}
}
