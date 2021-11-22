package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
    static int[] numbers;
    static int N,totalcnt;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();//주사위를 던진 횟수
        numbers=new int[N];
        isSelected = new boolean[7];//1-6까지 주사위의 눈의 사용여부
        
        int M=sc.nextInt();//던지기 모드
        totalcnt=0;
        switch(M) {
        case 1:
            dice1(0);
            break;
        case 2:
            dice2(0);
            break;
        case 3:
            dice3(0,1);
            break;
        case 4:
            dice4(0,1);
            break;
        }
        System.out.println("경우의 수 :"+totalcnt);
        
    }
    //중복순열: nㅠr ==>n^r
    private static void dice1(int cnt) {
        if(cnt==N) {
            totalcnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=1;i<=6;i++) {
            numbers[cnt]=i;
            dice1(cnt+1);
        }
    }
    //순열:nPr==>n!
    private static void dice2(int cnt) {
        if(cnt==N) {
            totalcnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=1;i<=6;i++) {
            if(isSelected[i])continue;
            numbers[cnt]=i;
            isSelected[i]=true;
            dice2(cnt+1);
            isSelected[i]=false;
            
        }
    }
    //중복조합nHr:6H3=n+r-1Cr:8C3:56
    private static void dice3(int cnt,int start) {
        if(cnt==N) {
            totalcnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start;i<=6;i++) {
            numbers[cnt]=i;
            dice3(cnt+1,i);
            
        }
    }
    //조합 :nCr : 6C3:20
    private static void dice4(int cnt,int start) {
        if(cnt==N) {
            totalcnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start;i<=6;i++) {
            numbers[cnt]=i;
            dice4(cnt+1,i+1);
            
        }
    }
    
}