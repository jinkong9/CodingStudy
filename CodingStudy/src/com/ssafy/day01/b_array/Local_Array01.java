package com.ssafy.day01.b_array;

import java.io.*;
import java.util.*;
/*
 * 배열의 크기와 좌표를 입력받아 해당 좌표에 1을 찍는 프로그램 작성
 * 경계선 체크
 * 기본 사방 탐색
 * 4방에 크기를 입력 받아 크기 만큼 1을 찍어보세요
 */
public class Local_Array01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int[N][N];
		
		int r = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int s = Integer.parseInt(br.readLine());
		
		
		map[r][c] = 1;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int i=0; i<4; i++) { //십자가 모양 찍기
			for(int j=1; j<=s; j++){
				int nr = r+dr[i]*j;
				int nc = c+dc[i]*j;
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc] =1;
				}
			}
		}
		
//		for(int i=0; i<4; i++) { //기본 사방 탐색
//			int nr = r+dr[i];
//			int nc = c+dc[i];
//			if(nr>=0 && nr<N && nc>=0 && nc<N) {
//			map[nr][nc] =1;
//			}
//		}
		
//		map[a-1][b] = 1;
//		map[a+1][b] = 1;
//		map[a][b+1] = 1;
//		map[a][b-1] = 1;
		
		print(map);
	}
	
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}
}
