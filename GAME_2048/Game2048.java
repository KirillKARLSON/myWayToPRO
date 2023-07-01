package GAME2048;

import com.javarush.engine.cell.Game;


public class Game2048 extends Game{
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int score = 0;


    private int[][] gameField = new int [SIDE][SIDE];

    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){

        for (int i = 0; i < SIDE; i++){
            for (int j = 0; j< SIDE; j++){
                gameField[i][j] = 0;
            }
        }

        for (int i = 0; i<2;i++){
            createNewNumber();
        }
    }

    private void drawScene(){
        for (int i = 0; i<SIDE; i++){
            for (int j = 0; j<SIDE; j++){
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private int getMaxTileValue(){
        int maxCount = 0;
        for (int i = 0; i < SIDE; i++){
            for (int j = 0; j< SIDE; j++){
                if (gameField[i][j] > maxCount) maxCount = gameField[i][j];
            }
        }

        return maxCount;
    }

    private void createNewNumber(){
        int x;
        int y;
        int count;

        int maxTile = getMaxTileValue();
        if (maxTile==2048) {
            win();
        }
        while (true){
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
            if (gameField[x][y]==0) break;
        }

        count = getRandomNumber(10);

        if (count == 9) {
            gameField[x][y] = 4;
        }
        else {
            gameField[x][y] = 2;
        }
    }


    private Color getColorByValue(int value){
        if (value == 2) return Color.LIGHTBLUE;
        if (value == 4) return Color.GOLDENROD;
        if (value == 8) return Color.GREY;
        if (value == 16) return Color.YELLOW;
        if (value == 32) return Color.HOTPINK;
        if (value == 64) return Color.PINK;
        if (value == 128) return Color.PLUM;
        if (value == 256) return Color.RED;
        if (value == 512) return Color.BEIGE;
        if (value == 1024) return Color.GREEN;
        if (value == 2048) return Color.PURPLE;

        return Color.LIGHTGREEN;
    }

    private void setCellColoredNumber(int x, int y, int value){
        Color cellColor = getColorByValue (value);
        String val = ""+value;
        if (value == 0) {
            setCellValueEx(x, y, cellColor, "");
        }
        else {
            setCellValueEx(x, y, cellColor, val);
        }
    }

    private boolean compressRow(int[] row){
        boolean flag = false;
        for(int i = 0; i<row.length-1; i++){
            for (int j = i+1; j<row.length; j++){
                if ((row[i] == 0)&&(row[j] != 0)){
                    row[i] = row[j];
                    row[j] = 0;
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean mergeRow(int[] row){
        boolean flag = false;
        for (int i = 0; i < row.length-1; i++){
            if (row[i]!= 0 && row[i] == row [i+1]){
                row[i] = row[i]+row[i+1];
                score+=row[i];
                setScore(score);
                row[i+1] = 0;
                flag = true;
            }
        }
        return flag;
    }

    private boolean canUserMove(){
        int countFlag = 0;

        for (int i = 0; i < SIDE; i++){
            for (int j = 0; j< SIDE; j++){
                if (gameField[i][j] == 0) return true;
                else if (i< SIDE-1 && gameField[i][j] == gameField[i+1][j]) return true;
                else if (j < SIDE-1 && gameField[i][j] == gameField[i][j+1]) return true;
            }
        }
        return false;
    }

    @Override

    public void onKeyPress(Key key){

        if (isGameStopped == true){
            if(key == Key.SPACE){
                isGameStopped = false;
                createGame();
                drawScene();
                score = 0;
                setScore(score);
            }

        }
        if (canUserMove() == false) {
            gameOver();
            return;}
        else {
            if (!isGameStopped == true && key == Key.LEFT) {
                moveLeft();
                drawScene();
            } else if (!isGameStopped == true && key == Key.RIGHT){
                moveRight();
                drawScene();
            } else if (!isGameStopped == true && key == Key.UP){
                moveUp();
                drawScene();
            } else if (!isGameStopped == true && key == Key.DOWN){
                moveDown();
                drawScene();
            }
        }
    }

    private void rotateClockwise(){
        int [][] bufMathrix = new int[SIDE][SIDE];

        for (int i = 0; i < SIDE; i++){
            for (int j = 0; j< SIDE; j++){
                bufMathrix[i][j] = gameField[i][j];
            }
        }

        for (int i = 0; i<SIDE; i++){
            for (int j = 0; j < SIDE; j++){
                gameField[j][SIDE-i-1] = bufMathrix[i][j];
            }
        }

    }

    private void moveLeft(){
        boolean flag1 = false;
        boolean flag2 = false;
        boolean buf = false;

        for (int i = 0; i<SIDE; i++){
            flag1 = compressRow(gameField[i]);
            flag2 = mergeRow (gameField[i]);
            compressRow(gameField[i]);

            if (flag1 == true || flag2 == true) {
                buf = true;
            } else {
                continue;
            }
        }

        if (buf == true) {
            createNewNumber();
        }


    }
    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Поражение", Color.WHITE, 55);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Победа", Color.WHITE, 55);
    }
}