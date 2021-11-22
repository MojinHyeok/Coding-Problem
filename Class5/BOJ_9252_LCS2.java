package Class5;

import java.util.Scanner;

public class BOJ_9252_LCS2 {
	public static void main(String[] args) {
		//LCSǮ�̹� 
		//���̳������α׷��� 
		//����1�� �������� ���� 2�� �񱳸� �����մϴ�.
		//���࿡ �ٸ����ڶ�� dy[i-1][j]�� dy[i][j-1]�� ū���� �����մϴ�.
		//���� ��ȭ���� �����̴��� �κм����� ���ӵ� ���� �ƴϱ� ������ ������ ���ڸ� ���ϴ� ���� ������ �ִ� ���� �κм����� ��� �ؼ� �����Ǳ⶧���� ���繮�ڸ� ���ϱ��� ������ �ٷ��� ����ȭ���̱⶧���Դϴ�.
		//����2���� �ϳ��ϳ� ���� ���� ���� �Ȱ��� ���ڶ�� dy[i-1][j-1]+1�� �������ݴϴ�.
		//�� dy[i-1][j-1]�� �����ϳĸ� ���ݱ����� �ִ� ����κм����� 1�� ��������ϹǷ��Դϴ� 
		// ���ڿ� ã��� ���ο�迭(ans) �������ŭ�� ũ�⸦ �����
		//dy[i-1][j] �� dy[i][j-1]�� ���簪�� �������� ã��  ���� ���� ���� �ִٸ� �� ������ �̵��� �����ϰ� 
		//���� ���� ���� ���ٸ�  ans�� ���ڸ� �ְ� dy[i-1][j-1]�� �̵��� �����մϴ�.
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
