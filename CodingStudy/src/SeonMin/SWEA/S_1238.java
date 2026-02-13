// SWEA 1238번 : Contact
package SeonMin.SWEA;

import java.util.*;
import java.io.*;

public class S_1238 {

	static int N, startNode, lastNode, maxDepth, finalLastNode, finalMaxDepth;
	static int MAX_PEOPLE = 100;
	static int[] minDepth, depth;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			startNode = Integer.parseInt(st.nextToken());

			graph = new ArrayList[MAX_PEOPLE + 1];
			for (int i = 1; i <= MAX_PEOPLE; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				if (!graph[from].contains(to)) {
					graph[from].add(to);
				}
			}

			/* ----------------- DFS ----------------- */
			minDepth = new int[MAX_PEOPLE + 1];

			DFS(startNode, 1);

			finalLastNode = finalMaxDepth = 0;
			for (int i = 1; i <= MAX_PEOPLE; i++) {
				if (minDepth[i] >= finalMaxDepth) {
					finalMaxDepth = minDepth[i];
					finalLastNode = i;
				}
			}

			/* ----------------- BFS ----------------- */
			depth = new int[MAX_PEOPLE + 1];

			BFS(startNode);

			lastNode = maxDepth = 0;
			for (int i = 1; i < MAX_PEOPLE + 1; i++) {
				if (depth[i] >= maxDepth) {
					maxDepth = depth[i];
					lastNode = i;
				}
			}

			/* ----------------- 출력 ----------------- */
			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(finalLastNode);
			sb.append("#").append(test_case).append(" ").append(lastNode);

			System.out.println(sb);
		}
	}

	// 1. 깊이 우선 탐색 DFS로 풀어보기 : 너무 어려움..
	public static void DFS(int node, int depth) {

		if (minDepth[node] != 0 && minDepth[node] <= depth)
			return;

		minDepth[node] = depth;

		for (int next : graph[node]) {
			if (minDepth[next] == 0 || depth + 1 < minDepth[next]) {
				DFS(next, depth + 1);
			}
		}
	}

	// 2. 너비 우선 탐색 BFS로 풀어보기
	public static void BFS(int node) {
		Queue<Integer> nodeQ = new ArrayDeque<>();
		nodeQ.add(node);

		depth[node] = 1;

		while (!nodeQ.isEmpty()) {
			int current = nodeQ.poll();

			for (int next : graph[current]) {
				if (depth[next] == 0) {
					depth[next] = depth[current] + 1;
					nodeQ.add(next);
				}
			}
		}

	}

}
