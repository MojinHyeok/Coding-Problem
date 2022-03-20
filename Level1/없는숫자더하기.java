package Level1;

public class 없는숫자더하기 {
	public static void main(String[] args) {
		int[] numbers= {0,1,2,3,4,6,7,8};
		System.out.println(solution(numbers));
	}

	private static int solution(int[] numbers) {
		int answer = 45;
		for(int x : numbers) {
			answer-=x;
		}
        return answer;
	}
}
