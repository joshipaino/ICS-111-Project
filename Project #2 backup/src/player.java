
public class player {

	int x;
	int y;
	EZImage picture;
	
	//constructor
	player() {
		x = 512;
		y = 300;
		picture = EZ.addImage("ssurfer.png", x, y);
	}
	
	//move function
	void move() {
		if (EZInteraction.isKeyDown("w")) {
			y = y-10;
		}
		if (EZInteraction.isKeyDown("s")) {
			y = y+10;
		}
		if (EZInteraction.isKeyDown("a")) {
			x = x-10;
		}
		if (EZInteraction.isKeyDown("d")) {
			x = x+10;
		}
		if (x >= 1024) {
			x = x-10;
		}
		if (y >= 768) {
			y = y-10;
		}
		if (x <= 0) {
			x = x+10;
		}
		if (y <= 0) {
			y = y+10;
		}
		picture.translateTo(x,y);
	}
	
	//function to terminate movement
	void end() {
		picture.translateTo(512, 300);
	}

	
}
