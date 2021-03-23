import javafx.scene.shape.Circle;

public class ButtonCntrl
{

	public void btnRightControl(Circle bird) {
		double x = bird.getCenterX(); // gives x coordinate of circle
		double y = bird.getCenterY();
		System.out.println(x + " "+ y);
		
		if (x>= 358 && y >=255)
		{
			bird.setCenterX(x);
			bird.setCenterY(y);
		}
		bird.setCenterX(x + 15);
		
	}

	public void btnLeftControl(Circle bird) {
		double x = bird.getCenterX(); 
		bird.setCenterX(x - 15);
		
	}

	public void btnUpControl(Circle bird) {
		double y = bird.getCenterY(); 
		bird.setCenterY(y - 15);
		
	}
	public void btnDownControl(Circle bird) {
		double y = bird.getCenterY(); 
		bird.setCenterY(y + 15);
	}

	public void btnResetControl(Circle bird) {
		bird.setCenterX(55);
		bird.setCenterY(255);
		
	}

}
