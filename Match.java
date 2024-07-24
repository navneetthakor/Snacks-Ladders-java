import java.util.Queue;

public class Match {
    private final Queue<Player> playersQ;
    private final Dice dice;
    private final Board board;

    
    Match(Queue<Player> givenPlayers, int n){
        this.playersQ = givenPlayers;
        this.dice = new Dice();
        this.board = new Board(n);
    }

    public Player playMatch(){

        while (true) {
            Player p = playersQ.poll();

            int currentPos = p.getPos();
            
            int points = dice.getNumber();
            int nextPos = points + currentPos;

            if(nextPos > board.getSize()){
                playersQ.add(p);
                continue;
            }

            if(board.isSnake(nextPos)){
                p.setPos(board.getSnakeEnd(nextPos));
            }
            else if(board.isLadder(nextPos)){
                p.setPos(board.getLadderEnd(nextPos));
            }
            else {
                p.setPos(nextPos);
            }

            // if player wins 
            if(board.isWin(p.getPos())) return p;
            
            playersQ.add(p);
        }
        
    }
}
