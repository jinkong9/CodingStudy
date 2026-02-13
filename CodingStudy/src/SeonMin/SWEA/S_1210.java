// SWEA 1210번 Ladder1 (사다리게임)
package SeonMin.SWEA;

import java.util.*;
import java.io.*;

public class S_1210 {

	static int[][] ladder;
	static int test_case, startR, startC;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		StringTokenizer st;

		for (int tc = 0; tc < 10; tc++) {

			test_case = Integer.parseInt(br.readLine());

			ladder = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			int row = startR;
			int col = startC;

			while (row > 0) {
				if ((col - 1) >= 0 && ladder[row][col - 1] == 1) {
					while ((col - 1) >= 0 && ladder[row][col - 1] == 1) {
						col--;
					}
					row--;
				} else if ((col + 1) < 100 && ladder[row][col + 1] == 1) {
					while ((col + 1) < 100 && ladder[row][col + 1] == 1) {
						col++;
					}
					row--;
				} else {
					row--;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(col);

			System.out.println(sb);
		}
	}
}
