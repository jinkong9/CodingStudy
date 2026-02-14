/**
 * 문제: 같은 숫자는 싫어 (Level 1)
 * 종류: 스택/큐
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * 풀이일: 2026-02-01
 */
package SeonMin.Programmers;

import java.util.*;

public class P_12906_같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            if(answer.isEmpty() || answer.peek() != current ){
                answer.push(current);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}