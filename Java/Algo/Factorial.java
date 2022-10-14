import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int i =  s.nextInt();
		int total = 1;
		for(int j = i;j>0;j--) {
			total = total * j;
		}
		System.out.println(total);

	}

}
