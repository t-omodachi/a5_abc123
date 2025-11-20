package application.model;

import application.model.WhackAMole;
import application.view.MainView;
import javafx.application.Platform;

public class CountDownTimer implements Runnable {
	
	private WhackAMole game;
	private MainView mainView;
	private int durationSeconds;
	
	public CountDownTimer(WhackAMole game, MainView mainView, int durationSeconds) {
		this.game = game;
		this.mainView = mainView;
		this.durationSeconds = durationSeconds;
	}
	
	@Override
	public void run() {
		int timeRemaining = durationSeconds;
		
		try {
			while(timeRemaining >= 0 && !game.getGameOver()) {
				
				Platform.runLater(() -> {
					mainView.displayTimeRemaining(String.valueOf(timeRemaining));
				});
				
				Thread.sleep(1000);
				
				timeRemaining--;
				
			}
			
			if (!game.getGameOver()) {
                game.endGame();

                Platform.runLater(() -> {
                    mainView.displayTimeRemaining("0");
                });
            }
		} catch(InterruptedException e) {
			System.out.print("ERROR: Timer was interrupted.");
		}
	}
	
}
