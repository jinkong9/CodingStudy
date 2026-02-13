// 백준 9663번 N-Queen_test수가 많을 걸 대비한 방법
package SeonMin.Backjoon;

import java.io.*;
import java.util.*;

public class B_9663_2 {

	static int N, count;
	static boolean[] column, rightUp, rightDown;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		column = new boolean[N];
		rightUp = new boolean[2 * N - 1];
		rightDown = new boolean[2 * N - 1];

		// 0행부터 시작
		checkingChess(0);

		System.out.println(count);
	}

	public static void checkingChess(int row) {
		if (row == N) {
			count++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (!column[col] && !rightUp[row + col] && !rightDown[row - col + (N - 1)]) {
				// 해당 좌표에 놓았다는 것을 표시
				column[col] = true;
				rightUp[row + col] = true;
				rightDown[row - col + (N - 1)] = true;

				// 다음 행으로 넘어감
				checkingChess(row + 1);

				// 아직 끝나지 않았는데 놔둘 수 없을 때 돌아와서 실행
				column[col] = false;
				rightUp[row + col] = false;
				rightDown[row - col + (N - 1)] = false;
			}

		}
	}

}
