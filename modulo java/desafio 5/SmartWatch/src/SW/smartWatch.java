package SW;

import java.util.ArrayList;

public class smartWatch {
	public static void main (String...arg) {
		ArrayList<String> steps = new ArrayList<String>();
		for(String pasos:arg) {
			steps.add(pasos);
		}
		clearSteps cs = new clearSteps();
		clearSteps.pasos(steps);
	}
}
