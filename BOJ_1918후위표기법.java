package Class4;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1918후위표기법 {
	//문제접근
	//중위 표기식을 후위 표기식으로 바꾸는 문제이다. 대표적인 스택을 사용하는 문제인데 후위 표기식의 방법에 대해 잘 몰라서 검색을 사용하면서 문제를 풀어봤습니다.
	//검색을 통해 알아낸 규칙은 다음과 같습니다.
	//1.연산자가 아닌 경우에는 그냥 바로 출력하여줍니다.
	//2. 그다음 연산자의 경우를 판단하여주는데 연산자의 경우는 우선순위를 고려하여 선택하여 줍니다.
	//( 는 0 
	//+ ,- 는 1
	///,* 2
	//우선순위로생각하여줍니다.
	//연산자의 경우 스택에 넣는 과정을 진행합니다.
	//만약 스택에 넣을 것이 스택의 pop 할 것보다 우선순위가 더 높거나 같을 경우는 스택에 있는 것은 pop 하고 출력하고 스택에 넣을 것은 넣는 과정을 진행하여줍니다.
	//요약하면 (는 무조건 무조건 스택에 넣는 과정을 진행하고 + - 는  * / + - 를 다출력후 스택에 넣고 * / 는 스택에 바로 넣습니다. 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		Stack<Character> result = new Stack<>();
		String ans="";
		for(int i=0;i<str.length();i++) {
			char a=str.charAt(i);
			if('A'<=a&&a<='Z')ans+=a;
			else if(a=='(')result.add(a);
			else if(a==')') {
				while(!result.isEmpty()) {
					char b=result.pop();
					if(b=='(')break;
					ans+=b;
				}
			}else {
				while(!result.isEmpty()&&prior(result.peek())>=prior(a)) {
					ans+=result.pop();
				}
				result.push(a);
			}
		}
		while(!result.isEmpty())ans+=result.pop();
		System.out.println(ans);
	}
	static int prior(char c) {
		if(c=='(')return 0;
		if(c=='+'||c=='-')return 1;
		if(c=='*'||c=='/')return 2;
		return 99;
	}

}
