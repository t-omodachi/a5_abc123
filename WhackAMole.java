package application.model;

import application.view.MainView;
import java.util.Random;
import javafx.scene.image.Image;

public class WhackAMole {
	
	private static final int NUM_MOLES = 5;
    private static final int GAME_DURATION_SECONDS = 30;
	
	private MainView mainView;
	private CountDownTimer timer;
	private Mole[] moles;
	private Thread[] moleThreads;
	private boolean[] exposed;
	private Random rand;
	private int totalScore;
	private boolean gameIsOver;
	private Image moleImage;
	private Image hiddenImage;
	
	public WhackAMole(MainView mainView, Image moleImage, Image hiddenImage) {
        this.mainView = mainView;
        this.moleImage = moleImage;
        this.hiddenImage = hiddenImage;
        this.rand = new Random();
        
        this.moles = new Mole[NUM_MOLES];
        this.moleThreads = new Thread[NUM_MOLES];
        this.exposed = new boolean[NUM_MOLES];
        this.totalScore = 0;
        this.gameIsOver = true;
    }
	
	public int getTotalScore() {
        return totalScore;
    }

    public boolean getGameIsOver() {
        return gameIsOver;
    }
    
    public void startGame() {
        if (!gameIsOver) {
            System.out.println("Game is already running.");
            return;
        }
        
        this.gameIsOver = false;
        this.totalScore = 0;
        mainView.displayLabel(String.valueOf(totalScore));
        
        this.timer = new CountDownTimer(this, mainView, GAME_DURATION_SECONDS);
        Thread timerThread = new Thread(timer);
        timerThread.start();
        
        for (int i = 0; i < NUM_MOLES; i++) {
            exposed[i] = false;
            
            moles[i] = new Mole(this, mainView, moleImage, hiddenImage, i);
            moleThreads[i] = new Thread(moles[i]);
            moleThreads[i].start();
        }
        
        System.out.println("Game started.");
    }
    
    public void endGame() {
    	
    }
	
}
