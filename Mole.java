package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;

public class Mole implements Runnable {
	int index;
	Random rand = new Random();
	public MainView mainview;
	WhackAMole game;
	CountDownTimer countdown;
	boolean peeking;
	int peekTime;
	double startPeekTime;
	double stopPeekTime;
	int moleStart = (int) System.currentTimeMillis();
	public Image moleImage;
	
	public synchronized void run() {
			try{	
				
				System.out.println("Mole Started");	

				
				while(game.gameisOver == false) {
					
					peeking = true;
					int timeToAppear = rand.nextInt(2000,5000);
					Thread.sleep(timeToAppear);	
					startPeekTime = System.currentTimeMillis();
					mainview.displayMole(index);
					
					int timeToHide = rand.nextInt(1000,2000);
					Thread.sleep(timeToHide);
					
					if(peeking){ //if the mole is clicked he'll hide so we don't need to execute the code below
						peeking = false;
						mainview.hideMole(index);
						endClock(); // unsure if this is required, used for testing and checking if score calculation is correct
						game.gameOver(); // we call this to update the gameIsOver Boolean
					}

				}
				
				System.out.print("GameOver no more moles");
				game.endGame();
			}
	
			catch(InterruptedException e) {
				System.err.println(e);
				
				Thread.currentThread().interrupt();
				return;
			}
		}
	public boolean isPeeking() {
		return peeking;
	}
	public int endClock() {
		stopPeekTime = System.currentTimeMillis();
		peekTime = (int)(stopPeekTime - startPeekTime);
		//System.out.println(peekTime);
		return peekTime;
	}
	public void setGame(WhackAMole game) {
		this.game = game;
	}
	public void setIndex(int n) {
		index = n;
	}
	public void setMainView(MainView mainview) {
		this.mainview = mainview;
	}
	public void setCountDown(CountDownTimer count) {
		countdown = count;
	}
	}
