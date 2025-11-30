package application.model;

import application.view.MainView;
import javafx.application.Platform; 
public class CountDownTimer implements Runnable{
	WhackAMole game;
	public MainView mainview;
	//public Mole mole;
	int durationSeconds = -1;
	public CountDownTimer(MainView mainview) {
		this.mainview = mainview;
	}
	public synchronized void run() {
		System.out.println("CountDown Started");
		for(int i = 30; i >= 0; i--) {
			try{
				Thread.sleep(1000);
//				
				durationSeconds = i;
//		    	
		    	Platform.runLater(() -> {
		    	    mainview.displayTimeRemaining(durationSeconds+"");
		    	});
		    	
			}
	
			catch(InterruptedException e) {
				System.err.println(e);
				
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

}


//Platform.runLater(() -> {
//	mainView.displayTimeRemaining(String.valueOf(timeRemaining));
//});
//
//Thread.sleep(1000);
//
//timeRemaining--;
//
//}
//
//if (!game.getGameOver()) {
//game.endGame();
//
//Platform.runLater(() -> {
//    mainView.displayTimeRemaining("0");
//});
//}
