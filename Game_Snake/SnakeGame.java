package Game_Snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    private static final int GOAL = 28;

    private int score;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    public static final int WIDTH = 15;
    public static final int HEIGHT =15;

    @Override
    public void initialize (){
        setScreenSize (WIDTH,HEIGHT);
        createGame ();
    }

    @Override
    public void onKeyPress (Key key){
        if (key == Key.LEFT)  snake.setDirection (Direction.LEFT);
        if (key == Key.RIGHT) snake.setDirection (Direction.RIGHT);
        if (key == Key.UP) snake.setDirection (Direction.UP);
        if (key == Key.DOWN) snake.setDirection(Direction.DOWN);
        if (isGameStopped == true && key == key.SPACE) createGame();
    }

    private void createNewApple(){
        do apple = new Apple (getRandomNumber(WIDTH),getRandomNumber(HEIGHT));
        while (snake.checkCollision (apple) == true);
    }

    private void drawScene (){
        for (int i=0; i<WIDTH; i++){
            for (int j= 0; j<HEIGHT; j++){
                setCellValueEx (i,j, Color.LIGHTBLUE,"");
            }
        }
        snake. draw(this);
        apple. draw (this);
    }


    private void createGame () {
        snake = new Snake (WIDTH/2, HEIGHT/2);
        createNewApple();
        isGameStopped = false;
        score = 0;
        drawScene();
        turnDelay = 300;
        setScore(score);
        setTurnTimer(turnDelay);
    }

    @Override
    public void onTurn (int i){
        snake.move(apple);
        if (apple.isAlive == false) {
            createNewApple();
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
        }
        if (snake.isAlive == false) {
            gameOver();
        }
        if (snake.getLength()>GOAL) {
            win();
        }
        drawScene ();
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog (Color.BLACK, "GAME OVER", Color.WHITE, 45);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog (Color.BLACK, "YOU WIN", Color.WHITE, 45);
    }
}



