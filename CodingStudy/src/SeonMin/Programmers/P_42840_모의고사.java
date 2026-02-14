/**
 * 문제: 모의고사 (Level 1)
 * 종류: 완전탐색
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 풀이일: 2026-01-24
 */
package SeonMin.Programmers;

class P_42840_모의고사 {
    public int[] solution(int[] answers) {
        // 수포자들의 찍는 패턴 배열 선언
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 수포자들의 정답 갯수 배열
        int[] ans = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++){
            // 문제 정답과 수포자들의 정답 비교하기
            // 수포자들의 패턴 배열을 길이로 나눈 나머지로 정답 파악
            if(answers[i] == p1[i%p1.length]){
                // 수포자들의 정답 갯수 카운트 추가
                ans[0]++;
            } else if(answers[i] == p2[i%p2.length]){
                ans[1]++;
            } else if(answers[i] == p3[i%p3.length]){
                ans[2]++;
            }
        }
        
        // 정답 갯수 배열에서 가장 큰 값 찾기
        int max = 0;
        for(int i = 0; i < ans.length; i++){
            max = Math.max(ans[i], max);
        }
        
        // 최대 정답자 확인하는 배열 선언
        boolean[] ansp = {false, false, false};
        for(int i = 0; i < ans.length; i++){
            if(ans[i] == max){
                ansp[i] = true;
            }
        }
        
        // 결과물 출력 배열
        int[] result = new int[3];
        for(int i = 0; i < ansp.length; i++){
            if(ansp[i] == true){
                result[i] = i+1;
            } else {
                result[i] = 0;
            }
        }
        
        return result;
    }
}