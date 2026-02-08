package SeonMin;

import java.util.*;
import java.io.*;

public class S1953_Escaper {

	static int N, M, R, C, L, count;
	static int[][] tunnel;
	static boolean[][] isVisited;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			tunnel = new int[N][M];
			isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tunnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			checkField(R, C, 1);

			sb.setLength(0);
			sb.append("#").append(test_case).append(" ").append(count);

			System.out.println(sb);
		}
	}

	public static void checkField(int row, int col, int time) {
		Queue<int[]> pipe = new ArrayDeque<>();
		pipe.add(new int[] { row, col, time });
		isVisited[row][col] = true;
		count = 1;

		while (!pipe.isEmpty()) {
			int[] current = pipe.poll();
			int r = current[0];
			int c = current[1];
			int t = current[2];

			if (t < L) {
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && tunnel[nr][nc] != 0
							&& (pipeType(tunnel[r][c], i) && pipeType(tunnel[nr][nc], 3 - i))) {
						isVisited[nr][nc] = true;
						count++;
						pipe.add(new int[] { nr, nc, t + 1 });
					}
				}
			}
		}

	}

	// 방향 순서 : 상, 좌, 우, 하
	public static boolean pipeType(int type, int direction) {
		switch (type) {
		case 1:
			return true;
		case 2: // 상, 하
			return (direction == 0 || direction == 3);
		case 3: // 좌, 우
			return (direction == 1 || direction == 2);
		case 4: // 상, 우
			return (direction == 0 || direction == 2);
		case 5: // 우, 하
			return (direction == 2 || direction == 3);
		case 6: // 좌, 하
			return (direction == 1 || direction == 3);
		case 7: // 상, 좌
			return (direction == 0 || direction == 1);
		default:
			return false;
		}
	}

}
