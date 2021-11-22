package Class3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1620_나는야포켓몬마스터 {
	//문제접근
	//문제를 처음 봤을 때는 M이 입력값으로 구해졌을 때에 숫자와 문자열을 구분하려고 노력했지만
	//생각을 하다 보니 Hashmap을 이용하여 숫자에 대한 키값과 문자열에 대한 키값 두 번 다 넣어주면 해결이라고 생각하여 문제풀이를 진행하였습니다.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=1;i<=N;i++) {
			String mon=sc.next();
			String num=Integer.toString(i);
			map.put(mon,num);
			map.put(num,mon);
		}
		for(int i=0;i<M;i++) {
			String str=sc.next();
				System.out.println(map.get(str));
			
		}
	}

}
