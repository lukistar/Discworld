package evaluator;

import java.util.ArrayList;

public class Evaluator implements IEvaluator {
	ArrayList<Double> list = new ArrayList<Double>();
	int type; // 0 for absolute, 1 for direct
	public Evaluator(int type) {
		this.type = type;
	}
	public void add(double d) {
		if (type == 0) {
			list.add(Math.abs(d));
		} else {
			list.add(d);
		}
	}
	public Double evaluate() {
		return null;
	}
}
