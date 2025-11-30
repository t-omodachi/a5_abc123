package application.controller;

import application.model.CountDownTimer;
import application.model.Mole;
import application.model.WhackAMole;
import application.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;

public class MainController {

    
	@FXML private ImageView imageView0;
	@FXML private ImageView imageView1;
	@FXML private ImageView imageView2;
	@FXML private ImageView imageView3;
	@FXML private ImageView imageView4;
	@FXML private Pane pane0;
	@FXML private Pane pane1;
	@FXML private Pane pane2;
	@FXML private Pane pane3;
	@FXML private Pane pane4;
	@FXML private Label scoreLabel;
	@FXML private Button startButton;
	@FXML private Label timeRemainingLabel;
	int score;
	MainView mainview;
	Mole mole;
	CountDownTimer countdown;
	WhackAMole game;
	public void initialize(Image moleImage) {
		game = new WhackAMole();
		mainview = new MainView();
		mole = new Mole();
		
		
		countdown = new CountDownTimer(mainview);
		countdown.mainview = mainview;
		//countdown.mole = mole;
		
		mole.moleImage = moleImage;
		
		
		game.setCountDown(countdown);
		game.setMainView(mainview);
		
		mainview.setMoleImage(moleImage);
		mainview.setTimeLabel(timeRemainingLabel);
		
		
		mainview.setImageView0(imageView0);
		mainview.setImageView1(imageView1);
		mainview.setImageView2(imageView2);
		mainview.setImageView3(imageView3);
		mainview.setImageView4(imageView4);
		
		ImageView[] moleImageViews = {
	            imageView0, imageView1, imageView2, imageView3, imageView4
	    };
	        
	    for (int i = 0; i < moleImageViews.length; i++) {      
	    	moleImageViews[i].setUserData(i);         
	    }
		score = 0;
	}

	
	
	
    @FXML
    void imageViewAction(MouseEvent event) {
    	ImageView imageView;
    	
    	//this needs to be found in mole and passed through to it, where we can do all the other calculations 
    	imageView = (ImageView) event.getSource();
    	int moleIndex = ((Integer) imageView.getUserData()).intValue();
    	
    	
       	// do this in updateScore() method 
    	int points = game.whackMole(moleIndex);
    	// because this if logic will be in a different method in a different class we will have to use a different way to check the image, we can use the hidden boolean in the mole class to check if the mole is hiding or not
    	if(imageView.getImage() != null) {
    		if(points < 500) {
    			score += 100;
    		}
    		else if(points < 1000){
    			score += 50;
    		}
    		else {
    			score += 10;
    		}
    		
    		imageView.setImage(null);
    	}
    	
    	mainview.setLabel(scoreLabel, "" + score);
    }

    @FXML
    void startButtonAction(ActionEvent event) {
    	
		if(game.gameOver() == true) {
			game.startGame();
		}
		else{
			//System.out.println("game in progess");
		}
    }

}



//imageView0.setImage(moleImage);
//imageView1.setImage(moleImage);
//imageView2.setImage(moleImage);
//imageView3.setImage(moleImage);
//imageView4.setImage(moleImage);