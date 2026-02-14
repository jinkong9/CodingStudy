// 백준 17070번 : 파이프 옮기기 1
package SeonMin.Backjoon;

import java.util.*;
import java.io.*;

public class B_17070_파이프옮기기 {

	static int N, nr, nc, count;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		bfs(0, 1, 1);
		System.out.println(count);
	}

	// 가로 = 1, 세로 = 2, 대각선 = 3
	public static void bfs(int row, int col, int state) {
		
		if (row == N - 1 && col == N - 1) {
			count++;
			return;
		}

		if (state == 1 || state == 3) {
			nc = col + 1;
			if (nc >= 0 && nc < N && map[row][nc] != 1) {
				bfs(row, nc, 1);
			}
		}
		if (state == 2 || state == 3) {
			nr = row + 1;
			if (nr >= 0 && nr < N && map[nr][col] != 1) {
				bfs(nr, col, 2);
			}
		}

		nr = row + 1;
		nc = col + 1;
		if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[row][nc] != 1 
				&& map[nr][col] != 1 && map[nr][nc] != 1) {
			bfs(nr, nc, 3);

		}
	}

}
