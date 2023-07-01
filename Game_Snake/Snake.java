package Game_Snake;
import com.javarush.engine.cell.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private List<GameObject>snakeParts = new ArrayList<>();

    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;

    public void setDirection (Direction direction){

        if (this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) return;
        if (this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x) return;
        if (this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y) return;
        if (this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y) return;

        if (this.direction == Direction.RIGHT && direction == Direction.LEFT ) return;
        else if (this.direction == Direction.LEFT && direction == Direction.RIGHT) return;
        else if (this.direction == Direction.UP && direction == Direction.DOWN) return;
        else if (this.direction == Direction.DOWN && direction == Direction.UP) return;

        else this.direction = direction;
    }

    public boolean checkCollision (GameObject obj){
        for (int i = 0; i<snakeParts.size(); i++){
            if (obj.x == snakeParts.get(i).x && obj.y == snakeParts.get(i).y){
                return true;
            }
        }
        return false;
    }

    public Snake (int x, int y){
        snakeParts.add (new GameObject(x,y));
        snakeParts.add (new GameObject (x+1,y));
        snakeParts.add (new GameObject (x+2, y));

    }

    public void draw (Game game){
        for (int i =0; i< snakeParts.size (); i++ ){

            GameObject part = snakeParts.get (i);
            if (i == 0 && isAlive == true) game.setCellValueEx (part.x, part.y, Color.NONE, HEAD_SIGN, Color.BLUE, 75);
            if (i == 0 && isAlive == false) game.setCellValueEx (part.x, part.y, Color.NONE, HEAD_SIGN, Color.RED, 75);
            if (i!=0 && isAlive == true) game.setCellValueEx (part.x, part.y, Color.NONE, BODY_SIGN, Color.BLUE, 75);
            if (i !=0 && isAlive == false) game.setCellValueEx (part.x, part.y, Color.NONE, BODY_SIGN, Color.RED, 75);

        }
    }

    public void move(Apple apple){
        GameObject headNew = createNewHead();

        if (checkCollision (headNew) == true ) {
            isAlive = false;
            return;}

        if (headNew.x<0 || headNew.x > SnakeGame.WIDTH-1 || headNew.y <0 || headNew.y > SnakeGame.HEIGHT-1){
            isAlive = false;
            return;
        }

        else {
            snakeParts.add (0,headNew);

            if (apple.x == headNew.x && apple.y == headNew.y) {
                apple.isAlive = false;
                return;
            }

            else this.removeTail();}
    }

    public GameObject createNewHead(){

        GameObject headNew = snakeParts.get (0);
        if (direction == Direction.LEFT) {

            headNew = new GameObject (headNew.x -1, headNew.y);

        }
        if (direction == Direction.RIGHT){
            headNew = new GameObject (headNew.x + 1, headNew.y);
        }

        if (direction == Direction.UP){
            headNew = new GameObject (headNew.x, headNew.y-1);
        }

        if (direction == Direction. DOWN) {
            headNew = new GameObject (headNew.x, headNew.y+1);
        }
        return headNew;

    }

    public void removeTail(){
        int index = snakeParts.size()-1;
        snakeParts.remove (index);
    }

    public int getLength(){
        return snakeParts.size();
    }
}
