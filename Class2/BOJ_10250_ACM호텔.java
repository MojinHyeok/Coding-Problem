package Class2;

import java.util.Scanner;

public class BOJ_10250_ACM호텔 {
	//문제접근
	//문제를 읽었을 때에 우선순위는 XX1처럼 층수에는 관계없이 몇호 인지가 중요한 요소입니다.
	//그래서 각층마다 1호를 처리하고 그이후에 2호를 처리하는 순으로 count하면 될 것이라 판단하였습니다.
	//하지만 문제를 보면서 생각해본 결과 점화식으로도 풀 수 있을 거라 생각하였습니다.
	//n을 높이만큼 나눈 나머지를 구해주고 그만큼 곱하기 100을 해주고 호를 구할때는 나눈 몫의 값에 플러스 1을 해주면 된다고 생각했습니다.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int H=sc.nextInt();
			int W=sc.nextInt();
			int n=sc.nextInt();
			//하지만 mod를 구할때 0일수도 있으니 0이면 꼭대기층이라 판단하는 조건도 넣어줘야 한다고 판단했습니다.
			int a= (n%H==0) ? H:n%H;
			int b= (n%H==0) ? n/H:n/H+1;
			System.out.println(a*100+b);
		}
	}

}
