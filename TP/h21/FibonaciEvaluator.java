package evaluator;
/**
* @return a new evaluator that gives the fibonacci number that is most
* closely to the sum of the added values.
* <p>
* Example:
* </p>
* <code>
* IEvaluator eval = createFibanociEvaluator();
* eval.add(10);
* eval.evaluate() must result in 8
* </code>
*
* <code>
* IEvaluator eval = createFibanociEvaluator();
* eval.add(100);
* eval.add(30);
* eval.add(1);
* eval.evaluate() must result in 144 since the added sum is 131
* </code>
*/
public class FibonaciEvaluator extends Evaluator {
	public FibonaciEvaluator(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Double evaluate() {
		double sum = 0;
		for(Double search : list) {
			sum+=search;
		}
		int num1 = 1;
		int num2 = 1;
		while(num2 < sum) {
			num2+=num1;
			num1 = num2-num1;
		}
		if ((sum - num1) < (num2 - sum)) {
			return (double) num1;
		} else {
			return (double) num2;
		}
	}
}
