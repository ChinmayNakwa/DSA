class sum {
	int add(int n) {
		int sum = 0, rem = 1;
		while (n>0) {
			rem = n % 10;
			sum += rem;
			n=n/10;
		}
		return sum;
	}
	public static void main(String args[]) {
		sum obj = new sum();
		System.out.println(obj.add(1111));	
	}
}