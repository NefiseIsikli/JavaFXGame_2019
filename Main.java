//Student Name: Nefise Isikli
//Date: 04/23/2019
//Project: Final Project (Flying from a cat)
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application
{
	Label GameOver;
	Pane p;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) 
	{
		
		Image imgBkGnd = new Image("background.jpg");
		Image catImg = new Image("cat.png");
		Image birdImg = new Image("bird.png");
		
		Label GameOver = new Label ("GAME OVER");
		GameOver.setLayoutX(15);
		GameOver.setLayoutY(110);
		GameOver.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 70));
		
			
		Circle bird = new Circle(250, 150, 20);
		bird.setStroke(null);
		bird.setFill(new ImagePattern(birdImg));
		
		Circle cat = new Circle(200, 250, 30);
		cat.setStroke(null);
		cat.setFill(new ImagePattern(catImg));
		
		Timer1 t = new Timer1(cat);
		
		Button btnStart = new Button("Start");
		btnStart.setFocusTraversable(false);
		btnStart.setOnAction((ActionEvent e) -> {
			t.start(); 
		});
		
		Button btnReset = new Button("Reset");
		btnReset.setFocusTraversable(false);
		btnReset.setOnAction((ActionEvent e) -> {
			t.start();
			GameOver.setVisible(false);
			
		});
		
		Button btnRight = new Button("Right");
		btnRight.setOnAction((ActionEvent e) -> { 
			ButtonCntrl bc = new ButtonCntrl();
			bc.btnRightControl(bird);
		});

		Button btnLeft = new Button("Left");
		btnLeft.setFocusTraversable(false);
		btnLeft.setOnAction((ActionEvent e) -> { 
			ButtonCntrl bc = new ButtonCntrl();
			bc.btnLeftControl(bird);
		});

		Button btnUp = new Button("Up");
		btnUp.setFocusTraversable(false);
		btnUp.setOnAction((ActionEvent e) -> { 
			ButtonCntrl bc = new ButtonCntrl();
			bc.btnUpControl(bird);
		});

		Button btnDown = new Button("Down");
		btnDown.setFocusTraversable(false);
		btnDown.setOnAction((ActionEvent e) -> { 
			ButtonCntrl bc = new ButtonCntrl();
			bc.btnResetControl(bird);	
			
		});
		
		
		p = new Pane();
		p.setMinSize(400, 325);
		p.getChildren().addAll(cat,bird,GameOver);
		p.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, 0), null, null)));
		GameOver.setVisible(false);
		BackgroundSize backgroundSize = new BackgroundSize(700, 700, true, true, true, false);
		BackgroundImage backgroundImage = new BackgroundImage(imgBkGnd, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		p.setBackground(new Background(backgroundImage));
		
		HBox hb = new HBox();
		hb.setMinSize(100, 50);
		hb.setPadding(new Insets(5, 5, 5, 5));
		hb.setSpacing(7);
		hb.setBackground(new Background(new BackgroundFill(Color.rgb(0,100,0), null, null)));
		hb.getChildren().addAll(btnStart,btnReset);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(5, 5, 5, 5));
		vb.setSpacing(5);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(0,100,0), null, null)));
		vb.getChildren().addAll(p, hb);

		
		Scene scene = new Scene(vb);
		stage.setScene(scene);
		stage.setTitle("Fly Away From the Cat");
		stage.setWidth(500.0);
		stage.setHeight(450.0);
		stage.show();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
								switch (event.getCode()) 
				{
				case UP:
					bird.setCenterY(bird.getCenterY() - 18);
					break;
				case DOWN:
					bird.setCenterY(bird.getCenterY() + 18);
					break;
				case RIGHT:
					bird.setCenterX(bird.getCenterX() + 18);
					break;
				case LEFT:
					double x = bird.getCenterX();
					if (x<35)
					{
						bird.setCenterX(x);	 
					}
					bird.setCenterX(x -15); 
					break;
				default: 
					break;
				} 
			// get X and Y 					
			int birdx = (int) bird.getCenterX(); 
			int birdy = (int) bird.getCenterY();
			int catx = (int) cat.getCenterX();
			int caty = (int) cat.getCenterY();
			// calculate when catch has happening
			int xdif = Math.abs(catx - birdx);
			int ydif = Math.abs(caty - birdy);
			
			if (xdif < 45 && ydif <45) { // if cat catches the bird, timer stops
				
				
	            t.stop();
	            GameOver.setVisible(true);
	            
				
			}
			
			
			

			} 
		}); 

		
	}
}
