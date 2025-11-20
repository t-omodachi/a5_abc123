package application.controller;

import application.model.Mole;
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
	public void initialize(Image moleImage) {
		mainview = new MainView();
		mole = new Mole();
		mole.mainview = this.mainview;
		mole.moleImage = moleImage;
		mainview.setMoleImage(moleImage);
		mainview.setImageView0(imageView0);
		mainview.setImageView1(imageView1);
		mainview.setImageView2(imageView2);
		mainview.setImageView3(imageView3);
		mainview.setImageView4(imageView4);
//		imageView0.setImage(moleImage);
//		imageView1.setImage(moleImage);
//		imageView2.setImage(moleImage);
//		imageView3.setImage(moleImage);
//		imageView4.setImage(moleImage);
		score = 0;
	}

    @FXML
    void imageViewAction(MouseEvent event) {
    	ImageView imageView;
    	
    	imageView = (ImageView) event.getTarget();
    	if(imageView.getImage() != null) {
    		score ++;
    		System.out.println("SCORE: " + score);
    		imageView.setImage(null);
    	}
    	mainview.setLabel(scoreLabel, "" + score);
    }

    @FXML
    void startButtonAction(ActionEvent event) {
    	start(mole.run());
    }

}