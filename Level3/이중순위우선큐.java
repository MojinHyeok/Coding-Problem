package Level3;

import java.util.*;
public class 이중순위우선큐 {
	public static void main(String[] args) {
		String[] operations= {"I 7","I 5","I -5","D -1"};
		System.out.println(solution(operations));
	}
	 public static int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        PriorityQueue<Integer> minQue = new PriorityQueue<>();
	        PriorityQueue<Integer> maxQue =new PriorityQueue<>(Collections.reverseOrder());
	        int size = operations.length;
	        for(int i=0; i<size; i++){
	            String text = operations[i];
	            String command = text.substring(0,1);
	            int Value = Integer.parseInt(text.substring(2));
	            if(command.equals("I")){
	                minQue.offer(Value);
	                maxQue.offer(Value);
	            }else if (command.equals("D")){
	                if(!minQue.isEmpty()){
	                     if(Value == 1){
	                        int max = maxQue.peek();
	                        minQue.remove(max);
	                        maxQue.remove(max);
	                     }
	                    if(Value == -1){
	                        int min = minQue.peek();
	                        minQue.remove(min);
	                        maxQue.remove(min);
	                    }
	                    
	                
	                }
	               
	            }
	            
	        }
	        if(minQue.size()!=0){
	            int min = minQue.peek();
	            int max = maxQue.peek();
	            answer[0] = max;
	            answer[1] = min;
	        }
	        
	        
	        return answer;
	    }

	
}
