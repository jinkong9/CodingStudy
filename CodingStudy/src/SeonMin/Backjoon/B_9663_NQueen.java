// 백준 9663번 N-Queen_내가 이해한 버전
package SeonMin.Backjoon;

import java.io.*;
import java.util.*;

public class B_9663_NQueen {

	static int N, count;
	static int[] chess;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		chess = new int[N];
		Arrays.fill(chess, Integer.MAX_VALUE);
		QueenRoop(0, 0);

		System.out.println(count);
	}

	public static void QueenRoop(int row, int col) {
		if (row == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isValid(row, i)) {
				chess[row] = i;
				QueenRoop(row + 1, i);
				chess[row] = Integer.MAX_VALUE;
			}
		}
	}

	public static boolean isValid(int row, int col) {
		// 첫번째줄
		if (row == 0) {
			return true;
		}

		// 세로검증 : 1차 배열 체크의 값이 현재 놓으려는 값이 아니면 된다
		for (int i = 0; i < row; i++) {
			if (chess[i] == col) {
				return false;
			}
		}

		// 대각선 검증
		for (int i = 0; i < row; i++) {
			if (Math.abs(row - i) == Math.abs(col - chess[i])) {
				return false;
			}
		}

		// 위 검증을 다 통과한다면
		return true;
	}

}
