package Level2;

import java.util.Arrays;

public class 메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders= {"ABCD", "ABCD", "ABCD"};
		int[] course= {2,3,4};
		System.out.println(Arrays.toString(solution(orders,course)));
	}
	//개수별로 조합을 담을 배열 cnt를 하는 이유는 주문 횟수가 같다면 모두 출력함으로 
	static String[] result_menu;
	static int[] result_cnt;
	//마지막 배열을 만들어 정렬을하여 출력
	static String[] menu_list;
	private static String[] solution(String[] orders, int[] course) {
		String[] answer= {};
		result_menu=new String[11];
		result_cnt=new int[11];
		boolean[] Alpha=new boolean[26];
		String menu="";
		//조합할 메뉴 선정하기
		for(int i=0;i<orders.length;i++) {
			String tmp_menu=orders[i];
			for(int j=0;j<tmp_menu.length();j++) {
				if(!menu.contains(Character.toString(tmp_menu.charAt(j)))) {
					Alpha[tmp_menu.charAt(j)-'A']=true;
				}
			}
		}
		for(int i=0;i<26;i++) {
			if(Alpha[i]) {
				int x=65+i;
				menu+=Character.toString((char)x);
			}
		}
		menu_list=menu.split("");
		for(int x:course) {
			DFS(0,0,"",x,orders);			
		}
		String to_array="";
		for(int x:course) {
			if(result_menu[x]!=null)to_array+=result_menu[x];
		}
		answer=to_array.split(" ");
		Arrays.sort(answer);
		return answer;
	}
	private static void DFS(int idx, int start, String com,int goal,String[] orders) {
		if(idx==goal) {
			int cnt=0;
			for(int i=0;i<orders.length;i++) {
				String tmp=orders[i];
				boolean check=false;
				for(int j=0;j<com.length();j++) {
					if(!tmp.contains(Character.toString(com.charAt(j)))) {
						check=true;
						break;
					}
				}
				if(!check)cnt++;
			}
			if(cnt==result_cnt[goal]&&cnt>1) {
				result_menu[goal]+=com+" ";
			}
			if(cnt>result_cnt[goal]&&cnt>1) {
				result_menu[goal]=com+" ";
				result_cnt[goal]=cnt;
			}
			return;
		}
		for(int i=start;i<menu_list.length;i++) {
			DFS(idx+1,i+1,com+menu_list[i],goal,orders);
		}
		
	}
}
