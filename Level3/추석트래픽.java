package Level3;

import java.util.Arrays;

public class 추석트래픽 {
	public static void main(String[] args) {
		String[] temp= {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(temp));
		
	}
	public static int solution(String[] lines) {
        int answer = 0;
        String[][] temp=new String[lines.length][3];
        for(int i=0;i<lines.length;i++) {
        	temp[i]=lines[i].split(" ");
        }
        String[][] temp1=new String[lines.length][4];
        for(int i=0;i<lines.length;i++) {
        	temp1[i]=temp[i][1].split("\\:|\\.");
        }
        int[][] result=new int[lines.length][2];
        for(int i=0;i<lines.length;i++) {
        	result[i][0]=Integer.parseInt(temp1[i][0])*3600000+Integer.parseInt(temp1[i][1])*60000+Integer.parseInt(temp1[i][2])*1000+Integer.parseInt(temp1[i][3]);
        	result[i][1]=(int)(Float.parseFloat(temp[i][2].substring(0,temp[i][2].length()-1))*1000-1);
        }
        for(int i=0;i<lines.length;i++) {
        	int tempV=0;
        	int temp00=result[i][0]+999;
        	for(int j=i;j<lines.length;j++) {
        		if(temp00>=result[j][0]-result[j][1]) {
        			
        			tempV++;
        		}
        	}
        	answer=Integer.max(tempV, answer);
        }
        return answer;
    }
}
