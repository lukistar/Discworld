package evaluator;
/**
* @return a new evaluator that brings the given doubles to the power of 2
* and adds the result to the current evaluated value.
* <p>
* Example:
* </p>
* <code>
* IEvaluator eval = createPowerOnEvaluator();
* eval.add(3);
* eval.add(4);
* eval.add(5);
* eval.evaluate() must result in 3^2 + 4^2 + 5^2 = 50
* </code>
* */
public class PowerOnEvaluator extends Evaluator {
	double pow;
	public PowerOnEvaluator(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	public PowerOnEvaluator(int type, double pow) {
		super(type);
		this.pow = pow;
		// TODO Auto-generated constructor stub
	}
	public Double evaluate() {
		double sum = 0;
		for(Double search : list) {
			sum+=Math.pow(search, pow);
		}
		return sum;
	}
}
