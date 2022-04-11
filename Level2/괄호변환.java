package Level2;

public class 괄호변환 {
	public static void main(String[] args) {
		String p="()))((()";
		System.out.println(solution(p));
	}

	private static String solution(String p) {
		if(Check(p))return p;
		
		String answer=split(p);
		return answer;
	}
	
	private static String split(String p) {
		StringBuilder u=new StringBuilder();
		StringBuilder v= new StringBuilder();
		int cnt=0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(')cnt++;
			else cnt--;
			
			if(cnt==0) {
				u.append(p.substring(0,i+1));
				v.append(p.subSequence(i+1, p.length()));
				
				if(Check(u.toString())) {
					u.append(split(v.toString()));
					return u.toString();
				}
				else{
					StringBuilder tmp=new StringBuilder();
					tmp.append('(');
					tmp.append(split(v.toString()));
					tmp.append(')');
					tmp.append(reverse(u.toString()));
					return tmp.toString();
				}
			}
		}
		return "";
	}
	private static String reverse(String p) {
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<p.length()-1;i++) {
			if(p.charAt(i)=='(')sb.append(')');
			else sb.append('(');
		}
		return sb.toString();
	}
	
	private static boolean Check(String p) {
		if(p.charAt(0)==')')return false;
		int cnt=0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(')cnt++;
			else {
				cnt--;
				if(cnt<0)return false;
			}
		}
		return true;
	}
}
