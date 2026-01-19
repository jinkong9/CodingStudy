package Seokhyeon;

import java.util.*;

public class Array_11 {
    private static int R = 4, C = 5;
    private static char[][] map;
    // TODO: deltas 계열의 변수를 초기화 하시오.
    static int[] side_dx = {1, 0, -1, 0};
    static int[] side_dy = {0, 1, 0, -1};
    
    static int[] cross_dx = {1, -1, 1, -1};
    static int[] cross_dy = {1, -1, -1, 1};

    static int[] horse_dx = {1, 2, -2, -1, -2, -1, 2, 1};
    static int[] horse_dy = {2, 1, 1, 2, -1, -2, -1, -2};
    // END
    
    static Character[] vowel = {'A', 'E', 'I', 'O', 'U'};
    static Set<Character> vowel_set = new HashSet<>(Arrays.asList(vowel));

    private static void setup() {
        map = new char[R][C];
        char alpha = 'A';
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] = alpha++;
            }
        }
    }

    public static void main(String[] args) {
        setup();
        checkCross();
        checkX();
        straight();
        moveHorse();
    }
    


    private static void checkCross() {
        int sum = 0;
        // TODO: 자음의주변을 +로 탐색하고 요소의 합을 출력하시오.A=0, B=1,..
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(! vowel_set.contains(map[i][j])) {
	        		for(int k=0; k<4; k++) {
	        			int y = i + side_dy[k];
	        			int x = j + side_dx[k];
	        			if(x>=0 && x<C && y>=0 && y<R) {
	        				sum += map[y][x] - 'A';
	        			}
	        		}
        		}
        	}
        }
        // END
        System.out.println(sum == 498);
    }

    private static void checkX() {
        int sum = 0;
        // TODO: 모음의 주변을 X로 탐색하고 요소의 합을 출력하시오.(A=0, B=1, ...)
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(vowel_set.contains(map[i][j])) {
	        		for(int k=0; k<4; k++) {
	        			int y = i +cross_dy[k];
	        			int x = j + cross_dx[k];
	        			if(x>=0 && x<C && y>=0 && y<R) {
	        				sum += map[y][x] - 'A';
	        			}
	        		}
        		}
        	}
        }
        // END
        System.out.println(sum == 72);
    }

    private static void straight() {
        int sum = 0;
        // TODO: 'K'의 사방으로 영역 내에서 모음을 만나기 전까지 모든 자음들을 합해서 출력하세요.('A'=0, 'B'=1, ...)
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(map[i][j] == 'K') {
	        		for(int k=0; k<4; k++) {
	        			for(int l=1; l<Math.max(R, C); l++) {
		        			int y = i + l * side_dy[k];
		        			int x = j + l * side_dx[k];
		        			if(x>=0 && x<C && y>=0 && y<R) {
			        			if(vowel_set.contains(map[y][x])) break;
		        				sum += map[y][x] - 'A';
		        			}
		        		}
	        		}
        		}
        	}
        }
        // END
        System.out.println(sum == 56);
    }

    private static void moveHorse() {
        char maxChar = 'A';
        int maxSum = 0;
        // TODO: 모음에서 장기의 말(馬)이동 했을 때 만나는 지점의 합이 가장 큰 알파벳과 그때의 합은? 합이 같다면 큰 알파벳
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		int sum = 0;
        		if(vowel_set.contains(map[i][j])) {
        			for(int k=0; k<8; k++) {
        				int y = i + horse_dy[k];
        				int x = j + horse_dx[k];
        				if(x>=0 && x<C && y>=0 && y<R) {
        					sum += map[y][x] - 'A';
        				}
        			}
        		}
        		if(sum > maxSum) {
        			maxSum = sum;
        			maxChar = map[i][j];
        		}
        	}
        }
        // END
        System.out.println(maxChar == 'I' && maxSum == 48);
    }

}

