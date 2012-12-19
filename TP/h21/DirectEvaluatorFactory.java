package evaluator;

public class DirectEvaluatorFactory implements IEvaluatorFactory {

	public Evaluator createSumEvaluator() {
		return new SumEvaluator(1);
	}
	public Evaluator createPowerOnEvaluator() {
		return new PowerOnEvaluator(1);
	}
	public Evaluator createPowerOnEvaluator(double pow) {
		return new PowerOnEvaluator(1, pow);
	}
	public Evaluator createFibonaciEvaluator() {
		return new FibonaciEvaluator(1);
	}
}
