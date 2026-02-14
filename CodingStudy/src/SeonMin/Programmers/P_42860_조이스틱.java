/**
 * 문제: 조이스틱 (Level 2)
 * 종류: 그리디
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * 풀이일: 2026-01-25
 */
package SeonMin.Programmers;

class P_42860_조이스틱 {
    public int solution(String name)  {
        int total_move = 0; // 최단거리 result
        int len = name.length(); //name의 길이
        int min_move = len-1; // 직진을 기본값으로 설정
        
        for(int i = 0; i < len; i++){
            // 상하이동
            char targetChar = name.charAt(i);
            int minMove = Math.min(targetChar-'A', 'Z'-targetChar+1);
            total_move += minMove;
            
            // 좌우이동
            // 다음 글자의 인덱스
            int next = i+1;
            // A뭉치가 끝나고 나오는 첫번째 글자의 위치 찾기
            while (next < len && name.charAt(next) == 'A'){
                next++;
            }
            
            // 직진vs우턴vs좌턴
            // 우턴 : 0 -> i -> 0 -> 뒤에서부터
            min_move = Math.min(min_move, (i*2)+(len-next));
            // 좌턴 : 0 -> 뒤에서부터 -> 0 -> i
            min_move = Math.min(min_move, ((len-next)*2)+i);
        }
        total_move += min_move;
                                
        return total_move;
    }
}