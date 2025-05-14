class Two_Wheelers{
	public int speed;
	public int gear;
	
	Two_Wheelers(int speed, int gear) {
		this.speed = speed;
		this.gear = gear;
	}

	void print() {
		System.out.println("The top speed is "+speed+" as the number of gear is "+gear);
	}
		
}

class cycle extends Two_Wheelers{
	String Model;
	
	cycle(String Model, int speed, int gear) {
		super(speed, gear);
		this.Model = Model;
	}

	void display() {
		System.out.println("The mode name is:"+Model);
		
	}
	
	public static void main(String args[]) {
		cycle obj = new cycle("BTX", 6, 40);
		obj.display();
		obj.print();
	}
}
