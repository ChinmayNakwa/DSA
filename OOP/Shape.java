import java.util.*;

class Shape {
	
	static class Area {
		int x, y, area;

		Area(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		void area() {
			area = x*y;
		}

		int get_area() {
			area();
			return area;
		}
	}

	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Area inner = new Area(x, y);
		System.out.println("Area: "+inner.get_area());
	}
}