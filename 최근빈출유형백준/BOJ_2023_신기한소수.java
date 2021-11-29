package 최근빈출유형백준;

import java.util.Scanner;

public class BOJ_2023_신기한소수 {
//	문제접근
//	처음에는 배열을 만들어 에라토스테네스 체를 만들어 검사를 하는 방식을 고려하였는데 메모리 제한이 4MB라서 포기하였습니다.
//	그다음으로 생각 한것은 DFS를 통해 푸는 것입니다.
//	여기서 소수를 검사할 때 수의 제곱근까지만 검사를 합니다.
//	 이유는 모든 수를 두 수의 곱으로 표현했을 때 각각의 두 수 중에 하나는 반드시 제곱근 보다 작거나 같습니다.
//	 예시로, 10일 때 2 * 5로 표현 할 수 있으며 10의 제곱근은 3.16이 됩니다. 이때 10이 2로 나누어지는지 확인 했다면 5로 나누어지는지는 굳이 확인을 안해도 상관없습니다.
//	 시간을 줄이기 위해 이러한 방식을 사용합니다.
	static StringBuilder sb=new StringBuilder();
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		DFS(0,"");
		System.out.println(sb.toString());
	}
	private static void DFS(int idx, String string) {
		if(idx==N) {
			sb.append(string+"\n");
			return;
		}
		for(int i=1;i<10;i++) {
			if(isPrime(Integer.parseInt(string+i))) {
				DFS(idx+1,string+i);
			}
		}
		
	}
	private static boolean isPrime(int num) {
		if(num==1)return false;
		int tmp=(int) Math.sqrt(num);
		for(int i=2;i<=tmp;i++) {
			if(num%i==0)return false;
		}
		return true;
	}

}
