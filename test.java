import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		System.out.println(123);
		List<Integer>[] tmp=new ArrayList[3];
		for(int i=0;i<3;i++) {
			tmp[0]=new ArrayList<Integer>();
		}
		tmp[0].add(3);
		System.out.println(tmp[0].get(0));
		
		
	}
}
