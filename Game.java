
/**
 * This is a graphical game of Tick Tack Toe using Java
 *
 * @author Aditya Goyal
 * @version February 1st 2018
 */
import java.io.*;
import java.util.*;
class Game
{
    /**
     * === Attributes ===
     * grid: the array based grid of the game 
     * p1: the first player of the game
     * p2: the second player of the game
     */
    String grid[][];
    Player p1,p2;
    int turn;
    Game()
    {
        grid = new String[3][3]; //makes the grid for the game
        // instead of a garbage value, add None
        for(int i=0;i<this.grid.length;i++)
        {
            for(int j=0;j<this.grid[0].length;j++)
            {
                this.grid[i][j] = "0";
            }
        }
        turn = 0;
    }
    Game(Player one, Player two)
    {
        this.p1 = one;
        this.p2 = two;
        // instead of a garbage value, add None
        for(int i=0;i<this.grid.length;i++)
        {
            for(int j=0;j<this.grid[0].length;j++)
            {
                this.grid[i][j] = "0";
            }
        }
        turn = 0;
    }
    public void move()
    {
        int choice = 0;
        if(turn%2==0)
        {
            Scanner sc= new Scanner(System.in);
            System.out.println(this.p1.name + ", enter the grid you want to add the cross in");
            choice = Integer.parseInt(sc.nextLine());
            // check if the choice os right
            int count = 0;
            for(int i=0;i<this.grid.length;i++)
            {
                for(int j=0;j<this.grid[0].length;j++)
                {
                    if(count == choice && (this.grid[i][j] != "O" || this.grid[i][j]!="X"))
                        this.grid[i][j] = "X";
                    count += 1;
                }
            }
        }
        this.printGrid();
        if(turn%2!=0)
        {
            System.out.println(this.p2.name + ", enter the grid you want to add the circle in");
            Scanner sc = new Scanner(System.in);
            choice = Integer.parseInt(sc.nextLine());
            // check if the choice os right
            int count = 0;
            for(int i=0;i<this.grid.length;i++)
            {
                for(int j=0;j<this.grid[0].length;j++)
                {
                    if(count == choice && (this.grid[i][j] != "O" || this.grid[i][j]!="X"))
                        this.grid[i][j] = "X";
                    count += 1;
                }
            }
        }
        this.printGrid();
    }
    // check if anyone won
    public void printGrid()
    {// prints the grid of the game
        for(int i=0;i<this.grid.length;i++)
        {
            for(int j=0;j<this.grid[0].length;j++)
            {
                System.out.print(this.grid[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
class Player
{
    /**
     * === Attributes ===
     * name: the name of the player
     */
    String name = "";
    Player()
    {
        this.name = "";
    }
    Player(String n)
    {
        this.name = n;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1, Enter your name.");
        Player one = new Player("name");
        System.out.println("Player 2, Enter your name.");
        Player two = new Player("name");
        Game g = new Game(one, two);
        g.printGrid();

    }
}

    //while (True)
    //{
     //System.out.println("Player 1, Enter your name."}
            
    