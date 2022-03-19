package Level2;

public class 단체사진찍기 {

	public static void main(String[] args) {
		int n=2;
		String[] data= {"N~F=0", "R~T>2"};
		System.out.println(solution(n,data));
	}

	static char[] Friends= {'A','C','F','J','M','N','R','T'};
	static int A_index,C_index,F_index,J_index,M_index,N_index,R_index,T_index;
	static boolean[] Check;
	static int answer;
	private static int solution(int n, String[] data) {
		answer=0;
		Check=new boolean[8];
		MakePer(0,n,data);
		
		return answer;
	}

	private static void MakePer(int idx, int n,String[] data) {
		if(idx==8) {
			for(int i=0;i<n;i++) {
				String condition= data[i];
				int firstFriend=Value(condition.charAt(0));
				int secondFriend=Value(condition.charAt(2));
				if(!validation(firstFriend,secondFriend,condition.charAt(3),condition.charAt(4)-'0'))return;
			}
			answer++;
			return ;		
		}
		for(int i=0;i<8;i++) {
			if(Check[i])continue;
			Convert(idx,i);
			Check[i]=true;
			MakePer(idx+1,n,data);
			Check[i]=false;
			
		}
		
	}
	//올바르게 위치해 있는지 검증하는 과정
	private static boolean validation(int x,int y,char K,int stand) {
		int result=Math.abs(x-y)-1;
		switch (K) {
		case '<':
			if(result<stand)return true;
			return false;
		case '>':
			if(result>stand)return true;
			return false;
		case '=':
			if(result==stand)return true;
			return false;
		default:
			break;
		}
		return false;
	}
	
	//순열을 만드는 과정 배열은 별도로 만들지 않은 이유는 그 위치를 알아야하기 때문에 위치를 저장하면 좋겠다고 생각
	//하지만 Stirng클래스에서 indexof를 사용하면 더 편했다고 생각한다..
	private static void Convert(int idx, int i) {
		switch (idx) {
		case 0:
			A_index=i;
			break;
		case 1:
			C_index=i;
			break;
		case 2:
			F_index=i;
			break;
		case 3:
			J_index=i;
			break;
		case 4:
			M_index=i;
			break;
		case 5:
			N_index=i;
			break;
		case 6:
			R_index=i;
			break;
		case 7:
			T_index=i;
			break;		
		default:
			break;
		}
	}
	//각 카카오프렌즈 친구들의 위치를 알려주는 메소드
	private static int Value(char x) {
		switch (x) {
		case 'A':
			return A_index;
		case 'C':
			return C_index;
		case 'F':
			return F_index;
		case 'J':
			return J_index;
		case 'M':
			return M_index;
		case 'N':
			return N_index;
		case 'R':
			return R_index;
		case 'T':
			return T_index;
		default:
			break;
		}
		return 0;
	}
}
