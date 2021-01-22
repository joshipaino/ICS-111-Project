import java.awt.Color;

public class Surf {

	//MAIN PROGRAM
	
	public static void main(String[] args) {
		//Resolution & Screen Size
		EZ.initialize(1024, 768);
		
		//background
		EZ.setBackgroundColor(new Color (0, 0, 0));
		EZImage background = EZ.addImage("bsurf.png", 512, 350);
		
		//load souns
		EZSound waves = EZ.addSound("waves.wav");
		waves.loop();
		EZSound eat = EZ.addSound("eat.wav");
		EZSound drink = EZ.addSound("drink.wav");
		EZSound swoosh = EZ.addSound("swoosh.wav");
		EZSound hit = EZ.addSound("hurricanehit.wav");
		
		//load player via class
		player newplayer = new player();
		
		//water and food supply HUD initializing & game over text
		double watercount = 50;
		double foodcount = 50;
		Color c = new Color(0, 0, 0);
		int fontsize = 22;
		int efontsize = 120;
		
		EZText watermsg = EZ.addText(512, 20, " ", c, fontsize);
		watermsg.setFont("yorkwhiteletter.ttf");
		EZText foodmsg = EZ.addText(512, 40, " ", c, fontsize);
		foodmsg.setFont("yorkwhiteletter.ttf");
		
		//water array setup
		int numberofwater = 5;
		water[] waterholder = new water[numberofwater];
		
		//array count for amount of water
		for (int i = 0; i < numberofwater; i++) {
			waterholder[i] = new water();	
		}
		
		//food array setup
		int numberoffood = 5;
		food[] foodholder = new food[numberoffood];
		
		//array count for amount of food
		for (int i = 0; i < numberoffood; i++) {
			foodholder[i] = new food();
		}
		
		//hurricane array setup
		int numberofhurricane = 3;
		hurricane[] hurricaneholder = new hurricane[numberofhurricane];
		
		//array count for hurricane
		for (int i = 0; i < numberofhurricane; i++) {
			hurricaneholder[i] = new hurricane("hurricanee.png", 1024, 768);
		}
		
		while (true) {
			//round foodcounter and watercounter (doubles) to display integers on hud
			int foodcounthud = (int) Math.round(foodcount);
			int watercounthud = (int) Math.round(watercount);
			
			//water teleport
			for (int i = 0; i < numberofwater; i++) {
				if (waterholder[i].picture.isPointInElement(newplayer.x, newplayer.y)) {
					waterholder[i].teleport();
					watercount = watercount+10;
					drink.play();
				}
			//water teleport (contact w/ hurricane)	
				if (waterholder[i].picture.isPointInElement(hurricaneholder[0].x1, hurricaneholder[0].y1)) {
					waterholder[i].teleport();
					swoosh.play();
				}
				if (waterholder[i].picture.isPointInElement(hurricaneholder[1].x1, hurricaneholder[1].y1)) {
					waterholder[i].teleport();
					swoosh.play();
				}
				if (waterholder[i].picture.isPointInElement(hurricaneholder[2].x1, hurricaneholder[2].y1)) {
					waterholder[i].teleport();
					swoosh.play();
				}
			}

			//food teleport
			for (int i = 0; i < numberoffood; i++) {
				if (foodholder[i].picture.isPointInElement(newplayer.x, newplayer.y)) {
					foodholder[i].teleport();
					foodcount = foodcount+10;
					eat.play();
				}
			//food teleport (contact w/ hurricane)
				if (foodholder[i].picture.isPointInElement(hurricaneholder[0].x1, hurricaneholder[0].y1)) {
					foodholder[i].teleport();
					swoosh.play();
				}
				if (foodholder[i].picture.isPointInElement(hurricaneholder[1].x1, hurricaneholder[1].y1)) {
					foodholder[i].teleport();
					swoosh.play();
				}
				if (foodholder[i].picture.isPointInElement(hurricaneholder[2].x1, hurricaneholder[2].y1)) {
					foodholder[i].teleport();
					swoosh.play();
				}
			}
			
			//hurricane movement and teleport
			for (int i = 0; i < numberofhurricane; i++) {
				
				hurricaneholder[i].move();
				
				if (hurricaneholder[i].picture.isPointInElement(newplayer.x, newplayer.y)) {
					hit.play();
					hurricaneholder[i].teleport();
					watercount = watercount-10;
					foodcount = foodcount-10;
				}
			}
			
			//player move from player class as food/water supply decreases
			newplayer.move();
			foodcount =  foodcount-0.1;
			watercount = watercount-0.1;
			
			//hud text
			watermsg.setMsg("(Water'"+watercounthud+")");
			foodmsg.setMsg("(Food'"+foodcounthud+")");
			
			//gameover sequence
			if (foodcounthud < 0 || watercounthud < 0) {
				watermsg.hide();
				foodmsg.hide();
				waves.stop();
				newplayer.end();
				hurricaneholder[0].stop();
				hurricaneholder[1].stop();
				hurricaneholder[2].stop();
				EZText gameovertext = EZ.addText(512, 300, "£gameover=", c, efontsize);
				gameovertext.setFont("yorkwhiteletter.ttf");
			} 
			
			EZ.refreshScreen();
			}

	}
}
			
		


	
	
	

