package SeongJin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class programmers_기능개발 {
	static int progress[] = {99,96,94};
	static int speeds[] = {1,3,4};
	static int cnt;
	public static void main(String[] args) {
		solution(progress, speeds);
		
	}

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        int arr[] = new int[speeds.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) Math.ceil((100.0 - progress[i] ) / speeds[i]);
        }
        for (int i : arr) {
			System.out.println(i);
		}
        int peek = arr[0];
        int cnt = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] <= peek) { 
                cnt ++;
            } else {
            	q.add(cnt);
            	peek = arr[i];
            	cnt = 1;
            }
        }
        int a = q.size();
        int answer[] = new int[a];
        for(int i=0; i<a; i++) { 
        	answer[i] = q.poll();
        }
        return answer;
        
    }
}
