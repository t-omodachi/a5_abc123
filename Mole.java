package application.model;
import javafx.scene.image.Image;
import java.util.Random;

public class Mole implements Runnable {
	
	private WhackAMole game;
	private MainView mainView;
	private Image moleImage;
	private int index;
	private boolean gameIsOver;
	private Random rand;
	
	public mole(WhackAMole game, MainView mainView, Image moleImage, int index, boolean gameIsOver) {
		
		this.game = game;
		this.mainView = mainView;
		this.moleImage = moleImage;
		this.index = index;
		this.gameIsOver = gameIsOver;
		this.rand = new Random();
		
	}
	
	@Override
	public void run() {
		
		
		
	}

}
