
import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Question2 extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GCompound bird = createBird(100);
		add(bird, 0, this.getHeight()-GRASS_HEIGHT-bird.getHeight());
		pause(500);
		for (int i = -1*Dy_MAX; i <= Dy_MAX; i++) {
			bird.move(Dx, i);
			pause(PAUSE_TIME);
		}

		// Your code ends here
	}
	
	
	// Your code starts here
	private GCompound createBird(int n) {
		int k = n/5;
		GCompound bird = new GCompound();
		GOval white = new GOval(k,k);
		GOval black = new GOval(k/2,k/2);
		GPolygon triangle = new GPolygon();
		triangle.addVertex(0, 0);
		triangle.addEdge(0, 3*k);
		triangle.addEdge(4*k,0);
		triangle.setFilled(true);
		triangle.setFillColor(Color.RED);
		white.setFilled(true);
		white.setFillColor(Color.WHITE);
		black.setFilled(true);
		black.setFillColor(Color.BLACK);
		//bird.setLocation(0,getHeight()-60);
		bird.add(triangle,0,0);
		bird.add(white,0,0);
		bird.add(black,0,0);
		return bird;
	}
	
	// Your code ends here
	
	/* Private constants */
	private static final int PAUSE_TIME = 100;
	private static final int Dy_MAX = 20;
	private static final int Dx = 5;
	private static final int GRASS_HEIGHT = 20;
	
	/* 
	 * Provides the environment.
	 * Do not change.
	*/
	public void init() {
		setSize(1000, 1000);
		this.setBackground(Color.BLUE);
		GOval sun = new GOval(50,50);
		sun.setFillColor(Color.ORANGE);
		sun.setFilled(true);
		add(sun, this.getWidth()-sun.getWidth()-10, 10);
		GRect grass = new GRect(getWidth(),GRASS_HEIGHT);
		grass.setFillColor(Color.GREEN);
		grass.setFilled(true);
		add(grass, 0,this.getHeight()-grass.getHeight());
		GLine rope = new GLine(0,
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2,
				getWidth(),
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2);
		add(rope);
	}
}
