package SeonMin;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Ripples_20260129 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] pond = new int[N][N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int rocksNum = Integer.parseInt(st.nextToken());
			int[] rocks = new int[rocksNum];

			for (int i = 0; i < rocksNum; i++) {
				rocks[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int[][] points = new int[rocksNum][2];
			for (int i = 0; i < rocksNum; i++) {
				points[i][0] = Integer.parseInt(st.nextToken()) - 1;
				points[i][1] = Integer.parseInt(st.nextToken()) - 1;
			}

			int[][] dp = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
			int[][] dx = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

			for (int k = 0; k < rocksNum; k++) {
				int a = points[k][0];
				int b = points[k][1];
				pond[a][b] += 1;

				int power = rocks[k];
				for (int l = 0; l < 4; l++) {
					for (int m = 1; m <= power; m++) {
						int x = a + dp[l][0] * m;
						int y = b + dp[l][1] * m;
						if (x >= 0 && x < N && y >= 0 && y < N) {
							pond[x][y]++;
						}

						int mx = a + dx[l][0] * m;
						int my = b + dx[l][1] * m;
						if (mx >= 0 && mx < N && my >= 0 && my < N) {
							pond[mx][my]++;
						}

					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(pond[i]));
//			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, pond[i][j]);
				}
			}

			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}