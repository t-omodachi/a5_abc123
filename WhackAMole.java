package application.model;

import application.controller.MainController;
import application.view.MainView;

import java.util.Random;


public class WhackAMole {
	MainView mainview;
	MainController maincontroller;
	int totalScore;
	boolean gameisOver = false;
	Random rand = new Random();
	Mole[] moles = new Mole[5];
	CountDownTimer countdown;
	
	public void startGame(){
		gameisOver = false;
		System.out.println("GameStarted");
		
		Thread countDownThread = new Thread(countdown);
    	countDownThread.start();
    	
		for(int i = 0; i <= 4; i++) {
			moles[i] = new Mole();
			moles[i].setMainView(mainview);
			moles[i].setCountDown(countdown);
			moles[i].setGame(this);
			moles[i].setIndex(i);
		}
		
		Thread mole0Thread = new Thread(moles[0]);
		Thread mole1Thread = new Thread(moles[1]);
		Thread mole2Thread = new Thread(moles[2]);
		Thread mole3Thread = new Thread(moles[3]);
		Thread mole4Thread = new Thread(moles[4]);
    	
    	mole0Thread.start();
    	mole1Thread.start();
    	mole2Thread.start();
    	mole3Thread.start();
    	mole4Thread.start();
    	gameOver();
    	//System.out.println("..." + moles[1].index);
	}
	
	public void endGame() {
		gameisOver = false;
	}
	public int whackMole(int n) {
		if(moles[n].isPeeking()) {
			int points = moles[n].endClock();
			System.out.println("ms it took to click: " + points);
			return points;	
		}
		return 0;
	}
	public boolean gameOver() {
		int i = countdown.durationSeconds;
		if(i == 0) {
			System.out.print("Game OVER!");
			gameisOver = true;
			return true;
		}
		else if(i == -1) {
			return true;
		}
		//System.out.print("Game Not Over!");
		return false;
			
	}
	public void setMainView(MainView mainview) {
		this.mainview = mainview;
	}
	public void setMoles(Mole mole) {
		
	}
	public void setCountDown(CountDownTimer countDownTimer) {
		countdown = countDownTimer;
	}
	
}
