package Class2;

import java.util.Arrays;
import java.util.Scanner;

public class 직각삼각형 {
	//직각삼각형 문제를 보고 접근방법은 피타고라스정리를 이용한다면 될 것이라는 생각이 들었습니다.
	//그리하여 가장큰변을 먼저 구한다음 제곱한 값이 두개의 제곱 값을 더한 값이 같다면 올바른 답이 나올 것이라 생각하였습니다.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {//여기서 0이 나올때까지 계속 출력하여야하니 while문을 이용합니다.
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			if(a==0&&b==0&&c==0) {
				break;
			}
			int[] result=new int[3];//여기서 배열을 사용한 이유는 가장 큰변의 제곱값을 구할때 정렬을 사용한다면 보다 수월하다가고 생각하였습니다.
			result[0]=a;
			result[1]=b;
			result[2]=c;
			Arrays.sort(result);
			if(Math.pow(result[0],2)+Math.pow(result[1], 2)==Math.pow(result[2], 2))System.out.println("right");
			else System.out.println("wrong");
			
		}
	}

}
