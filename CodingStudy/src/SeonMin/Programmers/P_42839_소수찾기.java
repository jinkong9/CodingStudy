/**
 * 문제: 소수 찾기 (Level 2)
 * 종류: 완전탐색
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 풀이일: 2026-01-25
 */
package SeonMin.Programmers;

import java.util.*;

class P_42839_소수찾기 {
    public List<Integer> list = new ArrayList<>();
    static boolean[] isChecked;
    
    public int solution(String numbers) {
        // 전역변수 초기화 해주기
        list = new ArrayList<>();
        isChecked = new boolean[10000000];
        
        
        int len = numbers.length();
        int[] array = new int[len];
        
        for(int i = 0; i < len; i++){
            array[i] = numbers.charAt(i) - '0';
        }
        
        Permutation(array, new boolean[array.length], new int[array.length], 0);
        // Recursive(array, 0, new int[array.length], 0);
        
        int answer = 0;
        
        for(int num : list){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    /*
     * 소수 판별 함수 
    */
    public boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
    /*
    idx 대신 visited라는 boolean을 이용해 다양한 조합을 찾기
    */
    public void Permutation(int[] arr, boolean[] visited, int[] sel, int k){
        // 1.숫자가 만들어지면 정수로 합쳐서 확인
        if (k > 0){
            int num = 0;
            for(int i = 0; i < k; i++){
                num = (num*10) + sel[i];
            }
            
            if(!isChecked[num]){
                isChecked[num] = true;
                list.add(num);
            }
        }
        
        // 2.탈출 조건 : 자리가 다 찼을 때
        if (k == arr.length) return;
        
        // 3.쓰지 않은 카드 찾기
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                // 1.카드의 사용 체크
                visited[i] = true;
                // 2.선택 배열에 값 넣기
                sel[k] = arr[i];
                
                // 3.다음 자리 선택하기
                Permutation(arr, visited, sel, k+1);
                
                // 4.자릿수에 따라 조합이 달라지니, 원상복구가 필요
                visited[i] = false;
            }
        }
    }
    
    
    /*
    기존에 카드를 뽑기만 하면 되던 코드
    @param arr : 숫자로 구성된 배열
    @param idx : numbers의 인덱스
    @param sel : 선택해서 뽑은 배열
    @param k : sel의 인덱스
    public void Recursive(int[] arr, int idx, int[] sel, int k){
        // 재귀를 끝낼 조건
        if(idx == arr.length) {
        int num = 0;
            if(k > 0){
                for(int i = 0; i < k; i++){
                    num = (num*10) + sel[i];
                }
            }

            // for(int i = 0; i < k; i++){
            //     System.out.print(sel[i] + " ");
            // }
            // System.out.println();

            return;
        }
        
        // 선택했을 때
        sel[k] = arr[idx];
        Recursive(arr, idx+1, sel, k+1);
        
        // 선택하지 않았을 때
        Recursive(arr, idx+1, sel, k);
    }
*/
}