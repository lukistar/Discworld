package collection;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManyToOneRelation<Integer, Integer> test = new ManyToOneRelation<Integer, Integer>();
		Integer source1 = new Integer(4);
		Integer source2 = new Integer(5);
		Integer target1 = new Integer(1);
		test.connect(source1, target1);
		test.connect(source2, target1);
		System.out.println(test.containsSource(new Integer(5))); //should be false
		System.out.println(test.containsTarget(new Integer(1))); //should be false
		System.out.println(test.getTarget(source1)); //should be 1
		test.disconnectSource(new Integer(5)); //nothing
		System.out.println(test.getSources(target1)); //should be [4 ,5]
		test.disconnectSource(source1);
		System.out.println(test.getSources(target1)); //should be [5]
		test.disconnect(target1);
		System.out.println(test.containsSource(source2)); //should be false
		System.out.println(test.getSources(target1)); // should be []
		test.connect(source1, target1);
		System.out.println(test.getTargets()); // should be [1]
		
	}
}
