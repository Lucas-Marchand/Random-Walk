import java.util.Scanner;

public class RandomWalkDriver{
	public static void main(String[] args) {
		int n=Integer.MIN_VALUE;
		int seed = Integer.MIN_VALUE;
		RandomWalk path;
		Scanner kbd = new Scanner(System.in);
		
		//get and check a positive integer from the user
		while(n<=0) {
			System.out.println("Enter grid size: ");
			n = kbd.nextInt();
			if(n<=0) {
				System.out.println("Not a possitive integer: ");
			}
		}
		
		//get and check a seed value from the user
		while(seed<0) {
			System.out.println("Enter random seed (0 for no seed): ");
			seed = kbd.nextInt();
			if(seed<0) {
				System.out.println("Not a possitive integer: ");
			}
		}
		
		//choose object constructor based on seed
		if (seed==0) {
			path = new RandomWalk(n);
		}else{
			path = new RandomWalk(n,seed);
		}
		
		//close the scanner
		kbd.close();
		
		//create the path
		path.createWalk();
		
		//Give it all pretty like to the user
		System.out.println(path.toString());
	
	}
}
