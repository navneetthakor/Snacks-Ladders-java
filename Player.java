public class Player {
    private String name;
    private int pos;

    Player(String name){
        this.name = name;
        this.pos = 1;
    }

    public String getName(){
        return this.name;
    }

    public int getPos(){
        return this.pos;
    }

    public void setPos(int newPos){
        this.pos = newPos;
    }
}
