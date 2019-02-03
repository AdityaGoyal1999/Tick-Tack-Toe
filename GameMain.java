//import Game.;
import java.util.*;
class GameMain
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String n = "";
        System.out.println("Player 1, Enter your name.");
        n=sc.nextLine();
        Player one = new Player(n);
        System.out.println("Player 2, Enter your name.");
        n=sc.nextLine();
        Player two = new Player(n);
        Game g = new Game(one, two);
        while(true)
        {
            boolean var = g.move();
            if(var == true)
            {
                break;
            }
        }
        System.out.println("Game over.");
    }
}