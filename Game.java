import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcom to the Sankes & Ladders -------//");
        System.out.println("Enter number of players : ");
        int n = sc.nextInt();

        System.out.println("Enter size of board : ");
        int size = sc.nextInt();

        // to hold n players 
        Queue<Player> playerQ = new LinkedList<>();
        System.out.println("Enter playes name...");

        for(int i=0; i<n; i++){
            String name = sc.next();
            Player p = new Player(name);
            playerQ.add(p);
        }

        Match match = new Match(playerQ, size);
        Player winner = match.playMatch();

        System.out.println("Winnner is : " + winner.getName() + " -> points : " + winner.getPos());
        System.out.println();
        System.out.println("--- points of other players ---");

        while (!playerQ.isEmpty()) {
            Player p = playerQ.poll();

            if(p == winner) continue;

            System.out.println("name : " + p.getName() + " -> points : "+ p.getPos());
        }
    }
}
