/**
 * 문제: 큰 수 만들기 (Level 2)
 * 종류: 그리디
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * 풀이일: 2026-01-25
 */
package SeonMin.Programmers;

class P_42883_큰수만들기 {
    static int max_num = 0;
    public String solution(String number, int k) {
        int target = number.length() - k;
        
        System.out.println("-----일단 모든 조합 출력하기-----");
        
        Combine("", 0, number, target);
        
        System.out.println("최대값 : " + max_num);
        
        return Integer.toString(max_num);
    }
    
    public static void Combine(String result, int idx, String num, int cnt){
        if(cnt == 0){
            max_num = Math.max(max_num, Integer.parseInt(result));
            return;
        }
        
        if(idx == num.length()){
            return;
        }
        
        // 선택했을 때
        Combine(result+num.charAt(idx), idx+1, num, cnt-1);
        
        // 선택하지 않았을 때
        Combine(result, idx+1, num, cnt);
        
    }
}