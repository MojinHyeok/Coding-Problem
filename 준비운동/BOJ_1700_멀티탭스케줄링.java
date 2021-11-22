package 준비운동;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BOJ_1700_멀티탭스케줄링 {
	//그리디 탐색의 문제
	//N=멀티탭 구멍의 개수 K는 전기용품의 총 사용횟수 두번째 줄에는 전기용품의 이름
	// TC 1
	// 2 7
	// 2 3 2 3 1 2 7
	//고려해야할점
	//멀티탭의 개수, 나중에 이 용품이 다시 사용될 것인가? 이 두가지를 중점적으로 생각해보기.
	//시나리오
	//1.멀티 탭이 여유롭다면 그냥 바로 꽂기
	//2.여유가 없는데 만약 이미 꽂아진 전기용품이라면 그냥 skip
	//이제부터 크게 고려해야할점!!
	//만약 여유가 없는데 이미 꽂아진 전기용품도아니라면 나중에 이 용품이 다시 사용될 것인가를 고려해야합니다.
	//뽑아야 할 것중 나중에 사용할 것이 없다면 그것 뽑아서 바로 넣기.
	//둘다 나중에 사용한 다면 ? 그중에 순서가 그나마 늦게 사용되는 것을 뽑기
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> left=new LinkedList<>();
		LinkedList<Integer> right=new LinkedList<>();
		List<Integer> temp=new ArrayList<>();
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[] elect=new int[K];
		int tmp=0;
		for(int i=0;i<K;i++) {
			int n=sc.nextInt();
			elect[i]=n;
			//1번과정
			if(tmp<N) {
				if(!left.contains(n)) {
					left.add(n);
					tmp++;
				}else {
					continue;
				}
			}
			else right.add(n);
		}
		int ans=0;
		int size=right.size();
		for(int i=0;i<size;i++) {
			int n=right.poll();
			if(left.contains(n)) {
				continue;
			}
			temp=new ArrayList<>();
			boolean check=false;
		
			for(int j=0;j<N;j++) {
				if(!right.contains(left.get(j))) {
					
					left.remove(left.indexOf(left.get(j)));
					left.add(n);
					ans++;
					check =true;
					break;
				}
			}
			if(check)continue;
			for(int j=0;j<right.size();j++) {
				if(left.contains(right.get(j))&&!temp.contains(right.get(j))) {
					temp.add(right.get(j));
				}
			}
			
			int tempV=temp.get(temp.size()-1);
			ans++;
			left.remove(left.indexOf(tempV));
			left.add(n);
		}
		System.out.println(ans);
		
		
 	}
}
