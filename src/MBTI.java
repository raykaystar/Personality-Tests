import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MBTI {
	public static void main(String[] args) throws FileNotFoundException {

		boolean[] keyJorP = { true, false, false, true, false, false, true, false, true, false, true, true, true, false,
				false, true, true, true, false, false };
		boolean[] keyForT = { true, false, true, false, false, false, true, true, true, true, false, false, true, false,
				true, true, false, true, false, false };
		boolean[] keySorN = { false, false, true, true, false, true, true, false, true, true, true, false, true, false,
				true, false, false, false, false, true };
		boolean[] keyEorI = { true, false, false, true, false, true, true, false, true, false, true, false, true, false,
				false, false, false, true, true, true };

		boolean[] EorI = quizRunner("EorI.txt");
		boolean EorIResult = compareAnswers(EorI, keyEorI);
		boolean[] SorN = quizRunner("SorN.txt");
		boolean SorNResult = compareAnswers(SorN, keySorN);
		boolean[] ForT = quizRunner("ForT.txt");
		boolean ForTResult = compareAnswers(ForT, keyForT);
		boolean[] JorP = quizRunner("JorP.txt");
		boolean JorPResult = compareAnswers(JorP, keyJorP);

		double percent1 = findPercent(EorI, keyEorI);
		double percent2 = findPercent(SorN, keySorN);
		double percent3 = findPercent(ForT, keyForT);
		double percent4 = findPercent(JorP, keyJorP);

		String type = typeSetter(EorIResult, SorNResult, ForTResult, JorPResult);
		printDetails(type, percent1, percent2, percent3, percent4);
	}

	public static boolean compareAnswers(boolean[] answers, boolean[] key) {
		int matches = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == key[i]) {
				matches++;
			}
		}
		if (matches >= 10) {
			return true;
		} else {
			return false;
		}
	}

	public static double findPercent(boolean[] answers, boolean[] key) {
		boolean result = compareAnswers(answers, key);
		int matches = 0;
		if (result) {
			for (int i = 0; i < answers.length; i++) {
				if (answers[i] == key[i]) {
					matches++;
				}
			}
		} else {
			for (int i = 0; i < answers.length; i++) {
				if (answers[i] != key[i]) {
					matches++;

				}
			}
		}
		double percent = 100 * matches / answers.length;
		return percent;
	}

	public static boolean[] quizRunner(String fileName) throws FileNotFoundException {
		File fn = new File(fileName);
		String response = "";
		boolean[] myKey = new boolean[20];
		Scanner input = new Scanner(fn);
		Scanner keyboard = new Scanner(System.in);
		if (fn.exists() && fn.canRead()) {
			for (int i = 0; i < myKey.length; i++) {

				System.out.print(input.nextLine());
				System.out.println();

				response = keyboard.nextLine();

				myKey[i] = isValid(response, keyboard);
			}
		}
		return myKey;
	}

	public static String typeSetter(boolean trait1, boolean trait2, boolean trait3, boolean trait4) {
		String type = "";
		if (trait1) {
			type += "I";
		} else {
			type += "E";
		}

		if (trait2) {
			type += "N";
		} else {
			type += "S";
		}

		if (trait3) {
			type += "F";
		} else {
			type += "T";
		}

		if (trait4) {
			type += "J";
		} else {
			type += "P";
		}
		return type;
	}

	public static void printDetails(String type, double p1, double p2, double p3, double p4) {
		System.out.println("Your answers indicate you are most likely an " + type);

		if (type.charAt(0) == 'I') {
			System.out.println(p1 + "% of your answers idicate you are an Introvert.");
		} else {
			System.out.println(p1 + "% of your answers idicate you are an Extrovert.");
		}

		if (type.charAt(1) == 'N') {
			System.out.println(p2 + "% of your answers idicate you are an Intuitive type.");
		} else {
			System.out.println(p2 + "% of your answers idicate you are a Sensing type.");
		}

		if (type.charAt(2) == 'F') {
			System.out.println(p3 + "% of your answers idicate you are a Feeling type.");
		} else {
			System.out.println(p3 + "% of your answers idicate you are a Thinking type.");
		}

		if (type.charAt(3) == 'J') {
			System.out.println(p4 + "% of your answers idicate you are a Judging type.");
		} else {
			System.out.println(p4 + "% of your answers idicate you are a Percieving type.");
		}
	}

	public static boolean isValid(String response, Scanner scan) {
		boolean item = false;
		if (response.equalsIgnoreCase("T")) {
			return true;
		} else if (response.equalsIgnoreCase("F")) {
			return false;
		} else {
			while (!response.equalsIgnoreCase("T") || !response.equalsIgnoreCase("F") || response.length() > 1) {
				System.out.println("That response is invalid. Please enter T for true or F for false");
				response = scan.nextLine();
				if (response.equalsIgnoreCase("T")) {
					item = true;
					return item;
				} else if (response.equalsIgnoreCase("F")) {
					item = false;
					return item;
				}
			}
		}
		return item;
	}

}
