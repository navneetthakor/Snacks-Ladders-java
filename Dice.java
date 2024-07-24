public class Dice{

    // default constructor 
    Dice(){}

    // generate number between 1 and 6
    public int getNumber(){
        int n = (int)( Math.random() * 6);
        return n;
    }
}