class Rectangle {
	double length;
	double width;
	void set(double l, double w) {
		length=l;
		width=w;
	}
	void get(){
		System.out.println("Length = "+length);
		System.out.println("Width = "+width);
		System.out.println("Area = "+(length*width));
		System.out.println("Perimeter = "+(2*(length+width)));
	}
	void changeRectangle(Rectangle r) {
		r.set(30, 5);
	}
	Rectangle changeR(Rectangle r) {
		r=new Rectangle();
		r.set(10,5);
		return r;
	}
	public static void main(String args[]) {
		Rectangle rect = new Rectangle();
		rect.set(10, 20);
		rect.get();
		System.out.println();
		rect.changeRectangle(rect);
		rect.get();
		Rectangle rect1 = new Rectangle();
		Rectangle rect2;
		rect2 = rect1.changeR(rect1);
		rect2.get();
	}
}