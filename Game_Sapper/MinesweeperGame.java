package Game_Sapper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countClosedTiles = SIDE*SIDE;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int countFlags;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.PINK);
                setCellValue (x,y,"");
            }

        }
        countFlags = countMinesOnField;
        countMineNeighbors ();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }


    private void countMineNeighbors (){
        for (int y = 0; y < SIDE; y ++){
            for (int x = 0; x < SIDE; x++) {
                GameObject gameObject = gameField [y][x];
                if (!gameObject.isMine) {
                    for (GameObject neighbours : getNeighbors (gameObject)){
                        if (neighbours.isMine){
                            gameObject. countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick (int x,int y){
        if (isGameStopped == true) {
            restart();
        }
        else openTile (x,y);
    }

    private void openTile (int x, int y) {
        if (isGameStopped == true)
        {
            return;
        }

        GameObject gameObject = gameField [y][x];
        if (gameObject.isOpen == true || gameObject.isFlag == true) {
            return;
        }

        gameObject.isOpen = true;
        setCellColor (gameObject.x,gameObject.y, Color.LIGHTGREEN);
        countClosedTiles--;
        if (gameObject.isMine == false)
        {
            score = score+5;
            setScore (score);
        }

        if (countClosedTiles == countMinesOnField && gameObject.isMine == false) {
            win();
        }
        if (gameObject.isMine){
            setCellValue (gameObject.x, gameObject.y, MINE);
            setCellValueEx (gameObject.x, gameObject.y, Color.RED, MINE);
            gameOver ();
        }
        else if (gameObject.countMineNeighbors == 0) {
            setCellValue (gameObject.x, gameObject.y, "");

            List <GameObject> neighbours = getNeighbors (gameObject);
            for (GameObject neighbour : neighbours){
                if (!neighbour.isOpen){
                    openTile (neighbour.x, neighbour.y);
                }

            }
        }
        else {
            setCellNumber (gameObject.x, gameObject.y, gameObject.countMineNeighbors);
        }
    }
    private void markTile (int x, int y){

        if (isGameStopped == true) return;
        else{
            GameObject gameObject = gameField [y][x];

            if (gameObject.isOpen) return;
            if (countFlags == 0 && !gameObject.isFlag) return;

            if (!gameObject.isFlag) {
                setCellValue (gameObject.x, gameObject.y, FLAG);
                setCellColor (gameObject.x, gameObject.y, Color.YELLOW);
                gameObject.isFlag = true;
                countFlags--;}

            else {
                setCellValue (gameObject.x, gameObject.y, "");
                setCellColor (gameObject.x, gameObject.y, Color.ORANGE);
                gameObject.isFlag = false;
                countFlags++;
            }
        }
    }

    @Override
    public void onMouseRightClick (int x,int y){
        markTile (x,y);
    }

    private void gameOver (){
        showMessageDialog (Color.LIGHTBLUE, "GAME OVER", Color.BLUE, 55);
        isGameStopped = true;
    }

    private void win(){
        showMessageDialog (Color.BLACK, "YOU ARE WINNER", Color. WHITE, 55);
        isGameStopped = true;
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore (score);
        createGame ();
    }
}
