package Level2;



public class Hindex {
	 public int solution(int[] citations) {
	        int answer=0;
	        int maxv=0;
	        int leng=citations.length;
	        for(int i=0;i<leng;i++) {
	        	maxv=Integer.max(maxv, citations[i]);
	        }
	        int start=0;
	        int mid=0;
	        while(start<=maxv) {
	        	mid=(maxv+start)/2;
	        	int temp=0;
	        	for(int i=0;i<leng;i++) {
	        		if(citations[i]>=mid)temp++;
	        	}
	        	if(temp>=mid&&(leng-temp)<=mid) {
	        		start=mid+1;
                 answer=mid;
	        	}else maxv=mid-1;
	        }
	        
	        return answer;
	    }
}
