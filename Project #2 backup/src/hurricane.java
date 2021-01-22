import java.util.Random;

public class hurricane {
	public int x1;
	public int y1;
	private int maxscreenx;
	private int maxscreeny;
	private int speed; 
	EZImage picture;
	
	//constructor
	public hurricane(String filename, int maxX, int maxY) {
		picture = EZ.addImage(filename, 0, 0);
		maxscreenx = maxY;
		maxscreeny = maxY;
		moveh();
	}
	
	//creating start pos. and random speed
	public void moveh() {
		Random randomGenerator = new Random();
		
		int multiples = maxscreeny / picture.getHeight();
		
		int randomy = randomGenerator.nextInt(multiples) * picture.getHeight();
		setPosition(maxscreenx * 2, randomy);
		int spd = randomGenerator.nextInt(3) + 1;
		speed = spd;
	}
	
	//accessor function for x
	public int getX() {
		return x1;
	}
	//accessor function for x
	public int getY() {
		return y1;
	}
	
	//function that sets the position
	public void setPosition(int posx, int posy) {
		x1 = posx;
		y1 = posy;
		setImagePosition(x1, y1);
	}
	
	//function that sets position for associated image
	private void setImagePosition(int posx, int posy) {
		picture.translateTo(posx, posy);
	}
	
	//move function
	public void move() {
		x1 = x1 - speed;
		setPosition(x1, y1);
		if (x1 < 0) {
			moveh();
		}
	}
	
	//small function to terminate movement
	void stop() {
		x1 = 0;
	}
	
	//function to teleport hurricane
	void teleport() {
		Random randomGenerator;
		randomGenerator = new Random();
		x1 = randomGenerator.nextInt(1024);
		y1 = randomGenerator.nextInt(768);
		picture.translateTo(x1, y1);
	}

}
	
	
