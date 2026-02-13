// 백준 17136 색종이 붙이기
package SeonMin;

import java.util.*;
import java.io.*;

public class B_17136 {

	static int LEN = 10;
	static int minResult = Integer.MAX_VALUE;
	static int cnt;
	static int[] count;
	static int[][] square;

	public static void main(String[] args) throws IOException {

		square = new int[LEN][LEN];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < LEN; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = new int[] { 0, 5, 5, 5, 5, 5 };
		cnt = 0;
		/*
		 * 오류
		 *  1. 현 좌표에서 붙일 수 있는 가장 큰 종이를 일단 붙이기 때문에,
		 * 	   적합한 크기가 아닌 그리디가 되어버렸음
		 *	2. 이중 for문
		 *	   한 번 종이를 붙이고 난후에 다른 경우의 수(결정을 되돌리기 어려움)를 할 수가 없음
		 * 해결 : 현지 왈 "현재 좌표에서 할 수 있는 1~max까지 돌렸다"
		 * 		 현 좌표에서 크기 5~1까지의 모든 크기를 다 시도해보고,
		 * 		 다음 좌표로 갔다가 다시 돌아오기
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				if (square[i][j] == 1) {
					attachPaper(i, j, 5);
				}
			}
		}
		*/
		
		attachPaper(0, 0, 0);

		if (minResult == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minResult);
		}

	}

	public static void attachPaper(int row, int col, int usedPaper) {
		// 지금 돌리고 있는 재귀값이, 최소값보다 클 때
		if (usedPaper >= minResult)
			return;

		// 행을 전부 다 돌았을 때
		if (row == LEN) {
			minResult = Math.min(minResult, usedPaper);
			return;
		}

		int nr = (col == 9) ? row + 1 : row;
		int nc = (col == 9) ? 0 : col + 1;

		if (square[row][col] == 0) {
			attachPaper(nr, nc, usedPaper);
		} else {
			for (int size = 5; size >= 1; size--) {
				if (isAttach(row, col, size) && count[size] > 0) {
					// 종이 붙이기 1->0 변환
					changeNum(row, col, size, 0);
					count[size]--;

					// 붙였으니 다음으로 넘어가기
					attachPaper(nr, nc, usedPaper + 1);

					// 되돌아 왔을 때 원래대로 돌리기 0->1변환
					count[size]++;
					changeNum(row, col, size, 1);
				}
			}
		}
	}

	public static boolean isAttach(int row, int col, int num) {
		if (row < 0 || row + num > LEN || col < 0 || col + num > LEN || count[num] == 0)
			return false;

		for (int r = row; r < row + num; r++) {
			for (int c = col; c < col + num; c++) {
				if (square[r][c] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static void changeNum(int row, int col, int num, int type) {
		if (row < 0 || row + num > LEN || col < 0 || col + num > LEN)
			return;

		for (int r = row; r < row + num; r++) {
			for (int c = col; c < col + num; c++) {
				// type 0 : 1->0 변환
				if (type == 0) {
					square[r][c] = 0;
				}
				// type 1 : 0->1 변환
				else if (type == 1) {
					square[r][c] = 1;
				}
			}
		}
	}
	
/* 오류!
	public static void attachPaper(int row, int col, int num) {
		if (num == 0 || count[num] == 0)
			return;

		if (isAttach(row, col, num)) {
			// 바꾸기 1 -> 0
			changeNum(row, col, num, 0);
			count[num]--;ㅂ
			cnt++;
			return;
		}
		
		attachPaper(row, col, num - 1);

		// 되돌리기 changeNum 0 -> 1
		changeNum(row, col, num, 1);
	}
*/

}
