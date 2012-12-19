package evaluator;

public interface IEvaluator {
	/**
	* @param d
	* adds d as a parameter for the evaluation
	*/
	void add(double d);
	/**
	* @return the evaluated value
	*/
	Double evaluate();
}
