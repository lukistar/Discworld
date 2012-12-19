package evaluator;
/**
* @return a new evaluator that sums the given doubles.
* <p>
* Example:
* </p>
* <code>
* IEvaluator eval = createSumEvaluator();
* eval.add(3);
* eval.add(4);
* eval.add(5);
* eval.evaluate() must result in 3 + 4 + 5
* </code>
*/
public class SumEvaluator extends Evaluator {
	public SumEvaluator(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Double evaluate() {
		double sum = 0;
		for(Double search : list) {
			sum+=search;
		}
		return sum;
	}
}
