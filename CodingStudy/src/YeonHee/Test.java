package YeonHee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); 
			int[][] map = new int[N][N]; 
			
			st = new StringTokenizer(br.readLine());
			int stone = Integer.parseInt(st.nextToken()); 
			
			int[] power = new int[stone]; 
			for(int i = 0; i < stone; i++ ) {
				power[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < stone; i++) {
				int r = Integer.parseInt(st.nextToken()) - 1; 
				int c = Integer.parseInt(st.nextToken()) - 1; 
				int p = power[i]; 
				map[r][c]++;
				round(map,N,r,c,p);
				line(map,N,r,c,p);
			}
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>max) max= map[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + max);
			
		}
	}

	private static void round(int[][] map,int N,int r,int c,int p) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int d = 0; d < 4; d++) {
			for(int k = 1; k <= p; k++) {
				int nr = r + dr[d]*k;
				int nc = c + dc[d]*k; 
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					map[nr][nc]++;
				}
			}
		}
	}
	
	private static void line(int[][] map,int N,int r,int c,int p) {
		int[] dr = {-1,-1,1,1};
		int[] dc = {-1,1,1,-1};
		
		for(int d = 0; d < 4; d++) {
			for(int k = 1; k <= p; k++) {
				int nr = r + dr[d] * k;
				int nc = c + dc[d] * k;

				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					map[nr][nc]++;
				}
			}
		}
	}
}