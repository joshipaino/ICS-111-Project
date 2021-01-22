import java.util.Random;

public class water {
	int x;
	int y;
	EZImage picture;
	
	//constructor
	water() {
		Random randomGenerator;
		randomGenerator = new Random();
		
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture = EZ.addImage("water.png", x, y);
	}
	//function to activate teleportation
	void teleport() {
		Random randomGenerator;
		randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture.translateTo(x, y);
	}
	
}
