package 준비운동;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
 
        List<Integer> list = new ArrayList<>();
      
        for (int i = 1; i < 50; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }
        // a~b 사이의 합 구하기
        int result = 0;
        for (int i = a; i <= b; i++) {
            result += list.get(i-1);
        }
        System.out.println(result);
    }

}
