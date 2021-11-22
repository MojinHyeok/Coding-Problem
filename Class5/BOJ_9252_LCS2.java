package Class5;

import java.util.Scanner;

public class BOJ_9252_LCS2 {
	public static void main(String[] args) {
		//LCS풀이법 
		//다이나믹프로그래밍 
		//문자1를 기준으로 문자 2를 비교를 진행합니다.
		//만약에 다른숫자라면 dy[i-1][j]와 dy[i][j-1]중 큰값을 대입합니다.
		//저런 점화식을 세운이뉴는 부분수열이 연속된 값이 아니기 때문에 현재의 문자를 비교하는 과정 이전의 최대 공통 부분수열은 계속 해서 유지되기때문에 현재문자를 비교하기전 과정이 바로저 두점화식이기때문입니다.
		//문자2에서 하나하나 비교할 때에 만약 똑같은 숫자라면 dy[i-1][j-1]+1를 진행해줍니다.
		//왜 dy[i-1][j-1]를 진행하냐면 지금까지의 최대 공통부분수열에 1을 더해줘야하므로입니다 
		// 문자열 찾기는 새로운배열(ans) 결과값만큼의 크기를 만들고
		//dy[i-1][j] 와 dy[i][j-1]중 현재값과 같은값을 찾고  만약 같은 값이 있다면 그 값으로 이동을 진행하고 
		//만약 같은 값이 없다면  ans에 문자를 넣고 dy[i-1][j-1]로 이동을 진행합니다.
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String str2=sc.next();
		int ans=0;
		int[][] dy=new int[str2.length()+1][str.length()+1];
		for(int i=1;i<=str2.length();i++) {
			for(int j=1;j<=str.length();j++) {
					if(str2.charAt(i-1)==str.charAt(j-1)) {
						dy[i][j]=dy[i-1][j-1]+1;
					}else {
						dy[i][j]=Integer.max(dy[i-1][j], dy[i][j-1]);
						
					}
					
			}
		}
		ans=dy[str2.length()][str.length()];
		int Xstart=str2.length();
		int Ystart=str.length();
		int cur=dy[Xstart][Ystart];
		int idx=0;
		char[] result=new char[ans];
		while(Xstart>=1&&Ystart>=1) {
			if(dy[Xstart-1][Ystart]==cur)Xstart-=1;
			else if (dy[Xstart][Ystart-1]==cur)Ystart-=1;
			else {
				cur--;
				result[idx++]=str2.charAt(Ystart-1);
				Ystart--;
				Xstart--;
			}
			if(idx==ans)break;
		}
		System.out.println(ans);
		for(int i=ans;i>0;i--)
			System.out.print(result[i-1]);
		
		
	}

}
