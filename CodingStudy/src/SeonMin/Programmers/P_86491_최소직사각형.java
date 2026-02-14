/**
 * 문제: 최소 직사각형 (Level 1)
 * 종류: 완전탐색
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 풀이일: 2026-01-24
 */
package SeonMin.Programmers;

class P_86491_최소직사각형 {
    public int solution(int[][] sizes) {
        // 가장 긴 값을 찾기 위한 변수 설정
        int max_w = 0;
        int max_h = 0;
        
        for(int i = 0; i < sizes.length; i++){
            // 배열 값중 긴 것을 가로로, 짧은 것은 세로로 설정
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            max_w = Math.max(max_w, w);
            max_h = Math.max(max_h, h);
        }
        
        // return할 지갑 변수
        int wallet = 0;
        wallet = max_w * max_h;
        
        return wallet;
    }
}