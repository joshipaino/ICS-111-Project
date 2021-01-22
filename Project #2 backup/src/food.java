import java.util.Random;

public class food {
	int x;
	int y;
	EZImage picture;
	
	//constructor
	food() {
		Random randomGenerator;
		randomGenerator = new Random();
		
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture = EZ.addImage("food.png", x, y);
	}
	
	//function to activate teleport
	void teleport() {
		Random randomGenerator;
		randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture.translateTo(x, y);
	}
}
