/**
 * 문제: 기능개발 (Level 2)
 * 종류: 스택/큐
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 풀이일: 2026-02-01
 */
package SeonMin.Programmers;

import java.util.*;

class P_42586_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> remainTime = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int time = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] != 0){
                time++;
            }
            remainTime.add(time);
        }
        
        while(!remainTime.isEmpty()){
            int target = remainTime.poll();
            int count = 1;
            while(!remainTime.isEmpty() && target >= remainTime.peek()){
                remainTime.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}