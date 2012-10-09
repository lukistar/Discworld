public class Helloworld {
	public static void main(String [] args) {
		System.out.println("Hello world!");
		int z;
		int[] arr = new int[10];
		int br = 0;
		for (int n = 0; n < 100; n++) {
		z = n%2;
		if (z != 0)  {
			arr[br] = n;
			br = br + 1;
			if (br == 10) {
			break;
			}
		}
		}
		for (int q = 0; q < 10; q++) {
		System.out.println(arr[q]);
		}
	}

}
