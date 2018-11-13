import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Enneagram  {
	public static void main(String[] args) throws Exception {
		int[] answers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		char[] key = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		File fn = new File("EnneagramQ.txt");
		Scanner input = new Scanner(fn);
		Scanner keyboard = new Scanner(System.in);
		char response = 'O';
		int index = 0;
				
		if(fn.exists() && fn.canRead()) {
		
		do {	System.out.println();
			System.out.print(input.nextLine());
			response = keyboard.next().charAt(0);
			index = linearSearch(key, response);
			if(index > 0) {
				answers[index]++;
			}
		}while(input.hasNext());
		
	}
		printArray(answers);
	}
	public static int linearSearch(char[] array, char element) {
		if(array.length == 0) {
			return -1;
		}
		for(int i=0; i < array.length; i++) {
			if(array[i] == (element)) {
				return i;
			}
		}
		return -1;
	}
public static void printArray(int[] array) {
		
		if(array.length == 0) {
			System.out.print("[]");
		}else {
		
		System.out.print("[");
		
		for(int i=0; i < array.length-1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print(array[array.length-1] + "]");
	}
}
}
