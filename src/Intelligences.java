
public class Intelligences {
	public static void main(String[] args) {
		int musical = 0;
		int math = 0;
		int exist = 0;
		int natrual = 0;
		int intra = 0;
		int inter = 0;
		int kin = 0;
		int lin = 0;
		int visual = 0;
		
		
		
	}
	public static int questionResults(String input, int currentVal) {
		if(input.equalsIgnoreCase("Never")) {
			return currentVal;
		}else if(input.equalsIgnoreCase("rarely")) {
			return currentVal + 1;
		}else if(input.equalsIgnoreCase("sometimes")) {
			return currentVal + 2;
		}else if(input.equalsIgnoreCase("Always")) {
			return currentVal + 3;
		}else {
			return 6;
		}
	}
}
