// 프로그래머스 42862번 : 체육복 (그리디)
/**
 * 문제: 체육복 (Level 1)
 * 종류: 그리디
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 풀이일: 2026-01-25
 */
package SeonMin.Programmers;

class P_42862_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        if (n < 2 || n > 30) { return 0; }
        // n명의 학생 배열을 선언 후 체육복을 전부 가지고 있다고 가정한다
        int[] student = new int[n+1];
        for (int i = 1; i <= n; i++){
            student[i] = 1;
        }
        // 잃어버린 학생 번호(인덱스)에서 갯수를 뺀다
        for (int l : lost){
            student[l]--;
        }
        // 여벌이 있는 학생 번호(인덱스)에서 갯수를 더한다
        for (int r : reserve) {
            student[r]++;
        }
        
        // 학생 배열을 돌면서
        for (int i = 1; i <= n; i++){
            // 여벌이 있는 학생을 찾는다
            if (student[i] == 2){
                if(i-1 >= 1 && student[i-1] == 0){
                    student[i-1]++;
                    student[i]--;
                } else if(i+1 <= n && student[i+1] == 0){
                    student[i+1]++;
                    student[i]--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++){
            if(student[i] >= 1){
                answer++;
            }
        }
        return answer;
    }
}