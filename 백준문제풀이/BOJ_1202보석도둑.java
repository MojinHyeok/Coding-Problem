package 백준문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1202보석도둑 {
	//첫번째 접근 방식.
	//N개와보석개수와 K개의 가방을 가지고 있다.
	//이러한 가정일 때 K개의 가방에는 가방마다 1개씩 보석만 가질 수 있다.
	//이러한 가정일 때는 그리디한 생각으로서 오름차순으로 정렬하여 차근차근 올라가면서 자기가 가져갈수 있는 최대한을 가져가면 어떨가?라는 생각..
	//위의방법은 시간초과..
	static class Jewelry implements Comparable<Jewelry>{
		int M,V;
		public Jewelry(int m, int v) {
			super();
			M = m;
			V = v;
		}
		@Override
		public int compareTo(Jewelry o) {
			// TODO Auto-generated method stub
			if(this.M <= o.M) {
				return -1;
			}
			else {
				return 1;
			}
		}	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		PriorityQueue<Integer> bagpq=new PriorityQueue<>();
		PriorityQueue<Integer> price=new PriorityQueue<>();
		Jewelry[] jewelry=new Jewelry[N];
		for(int i=0;i<N;i++) {
			int m=sc.nextInt();
			int v=sc.nextInt();
			jewelry[i]=new Jewelry(m,v);
		}
		Arrays.sort(jewelry);
		for(int i=0;i<K;i++) {
			bagpq.add(sc.nextInt());
		}
		int result=0;
		int idx=0;
		while(!bagpq.isEmpty()) {
			int curr=bagpq.poll();
			System.out.println(curr);
			for(int j=idx;j<N;j++) {
				System.out.println(curr+ " "+j+" "+idx);
				if(jewelry[j].M<=curr) {
					
					price.offer(-(jewelry[j].V));
					idx++;
				}
				else {
					break;
				}
			}
			if(!price.isEmpty())result+=Math.abs(price.poll());
		}
		System.out.println(result);
	}

}
