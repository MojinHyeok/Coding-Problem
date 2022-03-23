package Level3;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계칫솔판매 {
	static class person{
		int amount;
		String parent;
		public person(int amount, String parent) {
			super();
			this.amount = amount;
			this.parent = parent;
		}
		public void add(int x) {
			this.amount+=x;
		}		
	}
	static HashMap<String, person> map=new HashMap<>();
	public static void main(String[] args) {
		String[] enroll= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"sam", "emily", "jaimie", "edward"};
		int[] amount= {2,3,5,4};
		System.out.println(Arrays.toString(solution(enroll,referral,seller,amount)));
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer= new int[enroll.length];		
		for(int i=0;i<enroll.length;i++) {
			map.put(enroll[i],new person(0,referral[i]));
		}
		for(int i=0;i<seller.length;i++) {
			DFS(seller[i],amount[i]*100);
		}
		for(int i=0;i<enroll.length;i++) {
			answer[i]=map.get(enroll[i]).amount;
		}
		return answer;
	}

	private static void DFS(String person, int price) {
		if(price<=9) {
			map.get(person).add(price);
			return;
		}
		int result=(int)Math.ceil(price*0.9);
		map.get(person).add(result);
		if(map.get(person).parent.equals("-"))return;
		DFS(map.get(person).parent,(int)Math.floor(price*0.1));
		
	}
}
