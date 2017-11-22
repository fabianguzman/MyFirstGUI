import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	Car theCar = new Car(0,0);

	//private static Random rand = new Random();

	public void paintComponent(Graphics g) {

		int nextX = theCar.getXPos();
		int nextY = theCar.getYPos();
		if (theCar.getDirection() > 0) {
			if (theCar.getXPos() + theCar.getWidth() + 5 <= this.getWidth()) {
				// Car can still move forward
				nextX += 5 * theCar.getDirection();
			}
			else if (theCar.getXPos() + theCar.getWidth() == this.getWidth()) {
				// Car exactly at right edge
				nextY += 30;
				if (nextY + theCar.getHeight() > this.getHeight()) {
					nextY = 0;
				}
				theCar.setDirection(-1);
			}
			else {
				// the car would go beyond the right edge
				nextX += this.getWidth() - (theCar.getXPos() + theCar.getWidth());
			}
		}
		else {
			if (theCar.getXPos() - 5 >= 0) {
				// Car can still move backwards
				nextX += 5 * theCar.getDirection();
			}
			else if (theCar.getXPos() == 0) {
				// Car exactly at left edge
				nextY += 30;
				if (nextY + theCar.getHeight() > this.getHeight()) {
					nextY = 0;
				}
				theCar.setDirection(1);
			}
			else {
				// the car would go beyond the left edge
				nextX = 0;
			}
		}
		theCar.setPos(nextX, nextY);
		theCar.draw(g);
	}
}
