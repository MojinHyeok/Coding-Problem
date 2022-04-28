package Jungol;

public class 에라토스테네스의체 {

	public static void main(String[] args) {
		
		// 구하고자 하는 숫자의 범위
		int N = 120;
		boolean[] num = new boolean[N+1];
		
		//0과 1은 소수가 아니므로 패스
		num[0] = true;
		num[1] = true;
		for( int i=2; i <= N; i++ ) {
			
			if(!num[i]) {
				//  2의 배수들을 처리했는데
				//  굳이 3x1 부터할 필요없이 3*3부터 시작하면 됩니다.
				for(int j= i*i; j<=N; j+=i ) {
					
					num[j]=true;
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			if(!num[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
