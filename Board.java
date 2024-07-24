import java.util.HashMap;
import java.util.Random;

public class Board {
    private final int size;
    private final HashMap<Integer,Integer> snakes;
    private final HashMap<Integer,Integer> ladders;

    Board(int givenSize){
        if(givenSize < 100 || givenSize % 10 != 0){
            System.out.println("---------provided Size is not appropriate so size value is set to default - 100-----");
            this.size = 100;
        }
        else {
            this.size = givenSize;
        }

        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();

        this.loadLadders();
        this.loadSnakes();

        
    }

    private void loadSnakes(){
        int n = (int) (Math.random() * (this.size/10));

        for(int i=0; i<n; i++){
            int start = 0;
            while(start == 0 || snakes.containsKey(start)){
               start = (int) (Math.random() * (size-1));
            }

            int end = 0;
            while(end == 0){
                end = (int) (Math.random() * (start-1));
             }

             snakes.put(start, end);
        }
    }

    private void loadLadders(){
        Random random = new Random();
        int n = random.nextInt((size/10)) + 1;

        for(int i=0; i<n; i++){
            int start = 0;
            while(start == 0 || ladders.containsKey(start)){
               start = random.nextInt(size);
            }

            int end = random.nextInt(size - start) + start;

             ladders.put(start, end);
        }
    }

    // publically available methods 
    public boolean isSnake(int n){
        return this.snakes.containsKey(n);
    }

    public boolean isLadder(int n){
        return this.ladders.containsKey(n);
    }

    public int getSnakeEnd(int n){
        return this.snakes.get(n);
    }

    public int getLadderEnd(int n){
        return this.ladders.get(n);
    }

    public int getSize(){
        return this.size;
    }

    public boolean isWin(int n){
        return this.size == n;
    }
}
