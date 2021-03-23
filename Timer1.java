import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

public class Timer1 extends AnimationTimer

{
	private Circle cat;
	private long lastMove;
	
public Timer1(Circle cat)
{
	this.cat=cat;	
	;
	}
@Override
public void handle(long now)
{
	
	//Making sure that bird doesn't go off the screen
	
	// slower the cat
	long timeSince = now -lastMove;
	double seconds = timeSince / 100000000;
	
	if(seconds > 2) {
	int newX = (int) (Math.random()*440+20);
	int newY = (int) (Math.random()*270+20);
	cat.setCenterX(newX);
	cat.setCenterY(newY);
	
	lastMove = System.nanoTime();
	
	
	
	
	
	}
}




}// end of timer
