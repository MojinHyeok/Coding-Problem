package Level3;

public class 징검다리건너기 {
	//처음엔 그저 하나씩 카운팅 하는 방법을 고려하였지만 그방법은 효율성이 떨어지므로 pass
	//다음 방법인 이분탐색을 사용
	public static void main(String[] args) {
		int[] tmp= {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(tmp,3));
	}

	private static int solution(int[] stones, int k) {
		int answer=0;
		int tmp=0;
		int min=0;
		int max=200000000;
		while(min<=max) {
			int mid=(min+max)/2;
			if(isCross(stones,k,mid)) {
				min=mid+1;
				answer=Math.max(answer, mid);
			}else {
				max=mid-1;
			}
			
		}
		return answer;
	}

	private static boolean isCross(int[] stones, int k, int mid) {
		
		int tmp=0;
		for(int i=0;i<stones.length;i++) {
			if(stones[i]-mid<0) {
				tmp++;
			}else {
				tmp=0;
			}
			if(tmp==k)return false;
		}		
		
		return true;
	}
}
