package SeongJin;
import java.io.*;
import java.util.*;
public class MonthTest_3 {
	static int dr[] = {-1,1,0,0,-1,-1,1,1};
	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			
			StringTokenizer st1 =new StringTokenizer(br.readLine());
			int dol = Integer.parseInt(st1.nextToken());
			int powerLen = dol;
			int power [] = new int[powerLen];
			for (int i = 0; i < powerLen; i++) {
				power[i] = Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int arrLen = st2.countTokens()/2;
			for(int i=0; i<arrLen; i++) {
				int r = Integer.parseInt(st2.nextToken())-1;
				int c = Integer.parseInt(st2.nextToken())-1;
				int spread = power[i];
				arr[r][c] += 1;
				for(int j=0; j<8; j++) {
					for(int k=1; k<=spread; k++) {
						int nr = r + dr[j]*k;
						int nc = c + dc[j]*k;
						if(nr>=0 && nr<N && nc >=0 && nc <N ) {
							arr[nr][nc] += 1;
						}
					}
				}
			}
			int max =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int tmp = arr[i][j];
					max = Math.max(max, tmp);
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		System.out.println(sb);
	}

}
