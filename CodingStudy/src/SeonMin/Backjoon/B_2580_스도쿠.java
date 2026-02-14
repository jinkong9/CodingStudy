// 백준 2580번 : 스도쿠
package SeonMin.Backjoon;

import java.io.*;
import java.util.*;

public class B_2580_스도쿠 {

	static int LEN = 9;
	static List<int[]> zero;
	static int[][] sudoku;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Input.txt")));

		sudoku = new int[LEN][LEN];
		for (int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < LEN; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		zero = new ArrayList<>();
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				if (sudoku[i][j] == 0) {
					zero.add(new int[] { i, j });
				}
			}
		}

		checkNumber(0);

	}

	public static void checkNumber(int index) {
		if (index == zero.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < LEN; i++) {
				for (int j = 0; j < LEN; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}

			System.out.println(sb);

			// 값을 전부 집어 넣었다고 했을 때, 단순 return이면 그 전칸으로 돌아가 다시 실행될 수도 있다
			System.exit(0);
		}

		int[] current = zero.get(index);
		int curR = current[0];
		int curC = current[1];

		for (int n = 1; n <= LEN; n++) {
			if (isValid(curR, curC, n)) {
				sudoku[curR][curC] = n;
				checkNumber(index + 1);
				// 다음으로 갔는데 넣을 수 있는 값이 없을 때, 전으로 돌아가 다시 탐색해야 한다
				sudoku[curR][curC] = 0;
			}
		}
	}

	public static boolean isValid(int r, int c, int number) {
		for (int n = 0; n < LEN; n++) {
			// 행 확인
			if (sudoku[r][n] == number)
				return false;
			// 열 확인
			if (sudoku[n][c] == number)
				return false;
		}

		// 3x3 박스 확인
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (sudoku[i][j] == number) {
					return false;
				}
			}
		}

		return true;
	}

}
