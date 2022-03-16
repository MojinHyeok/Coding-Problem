package Level1;

public class 신규아이디추천 {
	public static void main(String[] args) {
		String new_id="abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}

	private static String solution(String new_id) {
		String answer="";
		String tmp="";
		answer=new_id;
		//1단계
		answer=answer.toLowerCase();
		//2단계
		for(int i=0;i<answer.length();i++) {
			if((answer.charAt(i)>=97&&answer.charAt(i)<=122)||
				(answer.charAt(i)>=48&&answer.charAt(i)<=57)||
				answer.charAt(i)==45||answer.charAt(i)==95||answer.charAt(i)==46) {
				tmp+=answer.charAt(i);
			};			
		}
		
		//3단계
		while(tmp.contains("..")) {
			tmp=tmp.replace("..", ".");
		}
		//4단계
		answer="";
		for(int i=0;i<tmp.length();i++) {
			if((i==0||i==tmp.length()-1)&&tmp.charAt(i)==46)continue;
			answer+=tmp.charAt(i);
		}
		//5단계
		if(answer=="")return "aaa";
		//6단계
		if(answer.length()>=16) {
			answer=answer.substring(0,15);
			if(answer.charAt(15)==46)answer=answer.substring(0,14);
		}
		
		//7단계
		if(answer.length()==2)answer+=answer.charAt(1);
		if(answer.length()==1) {
			answer+=answer.charAt(0);
			answer+=answer.charAt(0);
		}

		return answer;
	}
}
