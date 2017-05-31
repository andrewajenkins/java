package main.pattern;

/**
 * This Factory Method pattern allows the object owner to decide which of two implementations
 * of string concat to pass to the client. One version of concat uses the '+' operator and the
 * other version uses StringBuilder to concatenate the strings.
 */
public class FactoryMethod {
	public static void main(String args) {

		String a = "test ";
		String b = "passed";

		Concat ccA = Concat.getConcatenator();
		Concat ccB = Concat.getConcatenator();

		System.out.println(ccA.concatStrings(a, b).equals("test passed"));
		System.out.println(ccB.concatStrings(a, b).equals("test passed"));
	}

	static abstract class Concat {

		static boolean toggle = false;

		static Concat getConcatenator() {

			FactoryMethod fm = new FactoryMethod();
			Concat result;

			if(toggle) {
				result = fm.new SBConcat();
				toggle = true;
			} else {
				result = fm.new OperatorConcat();
				toggle = false;
			}
			return result;
		}
		abstract String concatStrings(String a, String b);
	}

	class SBConcat extends Concat {
		@Override
		String concatStrings(String a, String b) {
			StringBuilder sb = new StringBuilder();
			sb.append(a);
			sb.append(b);
			System.out.println("string builder");
			return sb.toString();
		}
	}

	class OperatorConcat extends Concat {
		@Override
		String concatStrings(String a, String b) {
			String result = a+b;
			System.out.println("operator");
			return result;
		}
	}
}