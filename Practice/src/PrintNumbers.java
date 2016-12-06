import java.util.*;
public class PrintNumbers{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an integer!");
		int x=Integer.parseInt(sc.nextLine());
		for(int i=0;i<x;i++)
			System.out.println(i);
	}
}
