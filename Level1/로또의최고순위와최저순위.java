package Level1;

public class 로또의최고순위와최저순위 {
	 public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = {0};
	        int equal=0;
	        int zerocnt=0;
	        for(int i=0;i<6;i++) {
	        	int temp=lottos[i];
	        	if(temp==0) {
	        		zerocnt++;
	        		continue;
	        	}
	        	for(int j=0;j<6;j++) {
	        		if(temp==win_nums[j])equal++;
	        	}
	        }
	        
	        return answer;
	    }

}
