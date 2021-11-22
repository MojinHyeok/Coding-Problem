package Level1;

public class 내적 {
	  public int solution(int[] a, int[] b) {
	        int answer = 0;
	        int length=a.length;
	        for(int i=0;i<length;i++) {
	        	answer+=a[i]*b[i];
	        }
	        return answer;
	    }
}
