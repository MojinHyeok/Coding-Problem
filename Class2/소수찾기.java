package Class2;

import java.util.Scanner;

public class 소수찾기 {
	public static void main(String[] args) {
		boolean[] result=new boolean[1001];//N은 1000이하이므로 1001 까지 생성
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		result[0]=true;
		result[1]=true;
		for(int i=2;i*i<1001;i++) {
			if(!result[i]) {//소수일때만 진행시킨다.
				for(int j=2;i*j<1001;j++) {
					System.out.println(i * j);
					result[i*j]=true;
				}				
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(!result[sc.nextInt()])cnt++;
		}
		System.out.println(cnt);
	}
}
