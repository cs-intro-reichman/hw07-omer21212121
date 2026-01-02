/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double dx = (x2 - x1) / 3.0;
		double dy = (y2 - y1) / 3.0;
		double px1 = x1;
		double py1 = y1;
		double px2 = x1 + dx;
		double py2 = y1 + dy;
		double px3 = (Math.sqrt(3) / 2.0) * (y1 - y2) / 3.0 + (x1 + x2) / 2.0;
		double py3 = (Math.sqrt(3) / 2.0) * (x2 - x1) / 3.0 + (y1 + y2) / 2.0;
		double px4 = x1 + 2 * dx;
		double py4 = y1 + 2 * dy;
		double px5 = x2;
		double py5 = y2;
		curve(n - 1, px1, py1, px2, py2);
		curve(n - 1, px2, py2, px3, py3);
		curve(n - 1, px3, py3, px4, py4);
		curve(n - 1, px4, py4, px5, py5);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		double x1 = 0.2, y1 = 0.2;
		double x2 = 0.8, y2 = 0.2;
		double x3 = 0.5, y3 = 0.2 + Math.sqrt(3) * 0.3;
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
