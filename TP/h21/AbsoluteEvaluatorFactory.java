package evaluator;

public class AbsoluteEvaluatorFactory implements IEvaluatorFactory {
	
	public Evaluator createSumEvaluator() {
		return new SumEvaluator(0);
	}
	public Evaluator createPowerOnEvaluator() {
		return new PowerOnEvaluator(0);
	}
	public Evaluator createPowerOnEvaluator(double pow) {
		return new PowerOnEvaluator(0, pow);
	}
	public Evaluator createFibonaciEvaluator() {
		return new FibonaciEvaluator(0);
	}
}
