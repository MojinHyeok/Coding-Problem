package Class2;

import java.util.Scanner;

public class ê´„í˜¸ {
	//ë¬¸ì œë¥? ë´¤ì„ ?•Œ ?˜¬ë°”ë¥¸ ê´„í˜¸?¼ë©? ?™¼ìª½ê³¼ ?˜¤ë¥¸ìª½?˜ ê· í˜•?´ ë§ìœ¼ë©? ?˜ê¸? ?•Œë¬¸ì— (cnt?•˜ê³? )ë¥? cnt?•˜?—¬ ?˜‘ê°™ìœ¼ë©? ?œ?‹¤ê³? ?ƒê°í•˜???Šµ?‹ˆ?‹¤.!
	//?œ„ ì¡°ê±´ë§? ?‚¬?š©?•œ?‹¤ë©? ())(()?´?? ê°™ì? ê²½ìš°?Š” ?•ˆ?˜ê¸? ?•Œë¬¸ì— ì¡°ê¸ˆ ?” ì¡°ê±´?„ ì¶”ê??•´?•¼ ?•œ?‹¤ê³? ë¬¸ì œë¥? ???‹¤ê°? ?Šê¼ˆìŠµ?‹ˆ?‹¤.
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			String str=sc.next();
			int left=0;
			int right=0;
			boolean check=true;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(')left++;
				else right++;
				if(left<right) {
					check=false;
					break;
				}
			}
			if(left==right&&check)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
