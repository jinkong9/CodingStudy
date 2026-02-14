// SWEA 14510번 나무 높이
package SeonMin.SWEA;

import java.util.*;
import java.io.*;

public class S_14510_나무높이 {

	static int N, maxH, oddCnt, evenCnt, quotient, remainder, lastDay, newDay;
	static int[] trees, diffs;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Input.txt")));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			/* -------------------- 입력 -------------------- */
			N = Integer.parseInt(br.readLine());
			trees = new int[N];
			diffs = new int[N];
			maxH = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, trees[i]);
			}

			evenCnt = oddCnt = 0;
			for (int i = 0; i < N; i++) {
				diffs[i] = maxH - trees[i];

				quotient = diffs[i] / 2;
				remainder = diffs[i] % 2;

				evenCnt += quotient;
				oddCnt += remainder;
			}

			/*-------------------- 최적화 --------------------
			 * 1. 마지막 날을 계산한다
			 * 2. 짝수가 클 때 한 번 조정한다 -> new마지막날 계산
			 * 3. new마지막날이 old마지막날보다 클때까지 반복한다
			 * 4. 비슷해지는 그 시점이 원하는 날
			 * 	  lastDay -> while
			 * ------------------------------------------BUT
			 * - 짝수가 많을 때는 홀수로 치환해줘야 한다
			 * - 홀수가 많을 때는 방법이 없다
			 * - 짝수가 하나만 많을 때는 치환보다 그대로 있는게 좋다
			 * -> 날짜를 비슷하게 조절하는게 가장 중요하다
			 * 	  while -> lastDay
			 */

			while (evenCnt > oddCnt + 1) {
				evenCnt -= 1;
				oddCnt += 2;
			}

			lastDay = (evenCnt >= oddCnt) ? 2 * evenCnt : 2 * oddCnt - 1;

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(lastDay);

			System.out.println(sb);
		}
	}

}
