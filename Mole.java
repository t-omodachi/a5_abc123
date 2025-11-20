package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;

public class Mole implements Runnable {
	int index;
	Random rand = new Random();
	public MainView mainview;
	WhackAMole game;
	public Image moleImage;
	
	public void run() {
		for(int i = 5; i > 0; i--) {
			try{
				Thread.sleep(1000);
				
				int moleIndex = rand.nextInt(0,4);
				System.out.println("MOLE! at index, " + moleIndex);
				mainview.displayMole(moleIndex);
				
			}
	
			catch(InterruptedException e) {
				System.err.println(e);
				
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
	}
