package evaluator;

public class Test {
	public void Absolute() {
		AbsoluteEvaluatorFactory evaluator = new AbsoluteEvaluatorFactory();
		Evaluator eval1 = evaluator.createSumEvaluator();
		eval1.add(-3);
		eval1.add(4);
		eval1.add(5);
		System.out.println(eval1.evaluate());
		Evaluator eval2 = evaluator.createPowerOnEvaluator();
		eval2.add(-3);
		eval2.add(4);
		eval2.add(5);
		System.out.println(eval2.evaluate());
		Evaluator eval3 = evaluator.createPowerOnEvaluator(3);
		eval3.add(-3);
		eval3.add(4);
		eval3.add(5);
		System.out.println(eval3.evaluate());
		Evaluator eval4 = evaluator.createFibonaciEvaluator();
		eval4.add(-100);
		eval4.add(30);
		eval4.add(1);
		System.out.println(eval4.evaluate());
	}
	public void Direct() {
		DirectEvaluatorFactory evaluator = new DirectEvaluatorFactory();
		Evaluator eval1 = evaluator.createSumEvaluator();
		eval1.add(3);
		eval1.add(4);
		eval1.add(5);
		System.out.println(eval1.evaluate());
		Evaluator eval2 = evaluator.createPowerOnEvaluator();
		eval2.add(3);
		eval2.add(4);
		eval2.add(5);
		System.out.println(eval2.evaluate());
		Evaluator eval3 = evaluator.createPowerOnEvaluator(3);
		eval3.add(3);
		eval3.add(4);
		eval3.add(5);
		System.out.println(eval3.evaluate());
		Evaluator eval4 = evaluator.createFibonaciEvaluator();
		eval4.add(100);
		eval4.add(30);
		eval4.add(1);
		System.out.println(eval4.evaluate());
	}

}
