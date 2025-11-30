package application.view;

//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class MainView {
	Image moleImage;
	ImageView imageView0;
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	ImageView imageView4;
	Label timeLabel;
	public void setImageView0(ImageView imageView) {
		imageView0 = imageView;
	}
	public void setImageView1(ImageView imageView) {
		imageView1 = imageView;
	}
	public void setImageView2(ImageView imageView) {
		imageView2 = imageView;
	}
	public void setImageView3(ImageView imageView) {
		imageView3 = imageView;
	}
	public void setImageView4(ImageView imageView) {
		imageView4 = imageView;
	}
	public void setMoleImage(Image image) {
		moleImage = image;
	}
	public void setLabel(Label label, String str) {
		label.setText(str);
		
	}

	public void displayMole(int moleIndex) {
		ImageView imageView;
		imageView = getImageView(moleIndex);
		imageView.setImage(moleImage);
	}
	public void hideMole(int moleIndex) {
		ImageView imageView;
		imageView = getImageView(moleIndex);
		imageView.setImage(null);
	}
	private ImageView getImageView(int n) {
		switch(n) {
		case 0:
			return imageView0;
		case 1:
			return imageView1;
		case 2:
			return imageView2;
		case 3:
			return imageView3;
		case 4:
			return imageView4;
		default:
			return null;
		}
		
	}
	public void displayTimeRemaining(String time) {
		timeLabel.setText(time);
	}
	public void setTimeLabel(Label timeRemainingLabel) {
		// TODO Auto-generated method stub
		timeLabel = timeRemainingLabel;
	}
	
}