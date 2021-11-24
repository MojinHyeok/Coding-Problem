package Level3;

public class 합승택시요금_플로이드 {
	public static void main(String[] args) {
		int[][] temp= {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6,4,6,2,temp));
	}
	

	    public static int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = Integer.MAX_VALUE;
	        int[][] map=new int[n+1][n+1];
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=n;j++){
	                map[i][j]=20000001;
	            }
	            map[i][i]=0;
	        }
	        for(int i=0;i<fares.length;i++){
	            map[fares[i][0]][fares[i][1]]=fares[i][2];
	            map[fares[i][1]][fares[i][0]]=fares[i][2];
	        }
	        //플로이드 와샬의 가장 중요한 경 출 도
	        for(int k=1;k<=n;k++){//경유지
	            for(int i=1;i<=n;i++){//출발지
	                for(int j=1;j<=n;j++){//도착지
	                    if(map[i][j]>map[i][k]+map[k][j]){
	                        map[i][j]=map[i][k]+map[k][j];
	                    }
	                }
	            }
	        }
	        for(int i=1;i<=n;i++){
	            answer=Math.min(answer,map[s][i]+map[i][a]+map[i][b]);
	        }
	        
	        return answer;
	}

}
