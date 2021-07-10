package Class5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2467_용액 {
	//문제접근
	//용액의수N이 입력되고 N개의 정수가 빈칸을 사이에두고 오름차순으로 입력되어지니
	//생각이난 것은 시작점을 지정하고 그수와 비교되는 수를끝에서부터 차근차근 내려오는식으로 접근하면 어떨가? 에서 시작 되었습니다.
	//여기서의 예제의 입력값 5 
	//-99 -2 -1 4 98 이라면
	// -99 98 진행후  ans 1 에저장 end 98저장
	// -99 4 하면 -95는 큰값이니 다음 수로진행
	// -2 98 96을 temp 임시저장후
	// -2 4 비교후 2가나왔으니 end 4 로 바꾼후 temp또한 2로 바꾼후 진행
	// -2 -1 비교후 temp는 2 인데 여기서 절대값은 3이라서 다음수로 진행
	//이러한 과정을 진행하면서 temp가 ans보다 작다면 갱신하는 식으로 진행합니다 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[] arr=new long[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextLong();
		}
		long ans=Integer.MAX_VALUE;
		int start=0;
		int end=N-1;
		long[] ans1=new long[2];
		while(start<end) {
			long sum=arr[start]+arr[end];
			if(ans>Math.abs(sum)) {
				ans=Math.abs(sum);
				ans1[0]=arr[start];
				ans1[1]=arr[end];
			}
			if(sum<0)start++;
			else end--;
		}
		System.out.println(ans1[0]+" "+ans1[1]);
		
	}

}
