
/**
 * This is a graphical game of Tick Tack Toe using Java
 *
 * @author Aditya Goyal
 * @version February 1st 2018
 */
import java.io.*;
import java.util.*;
public class Game
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
                this.grid[i][j] = null;
            }
        }
        turn = 0;
    }
    Game(Player one, Player two)
    {
        this.p1 = one;
        this.p2 = two;
        // instead of a garbage value, add None
        grid = new String[3][3];
        for(int i=0;i<this.grid.length;i++)
        {
            for(int j=0;j<this.grid[0].length;j++)
            {
                this.grid[i][j] = null;
            }
        }
        turn = 0;
    }
    public boolean move()
    {
        int choice = 0;
        Scanner sc= new Scanner(System.in);
        System.out.println(this.p1.name + ", enter the grid you want to add the cross in");
        choice = Integer.parseInt(sc.nextLine());
        choice -= 1;
        if(this.turn%2==0)
        {
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
        this.turn += 1;
        this.printGrid();
        if(didWin())
        {
            System.out.println(p1.name + " has won the game!");
            return true;
        }
        System.out.println(this.p2.name + ", enter the grid you want to add the circle in");
        choice = Integer.parseInt(sc.nextLine());
        choice -= 1;
        if(this.turn%2!=0)
        {
            // check if the choice os right
            int count = 0;
            for(int i=0;i<this.grid.length;i++)
            {
                for(int j=0;j<this.grid[0].length;j++)
                {
                    if(count == choice && (this.grid[i][j] != "O" || this.grid[i][j]!="X"))
                        this.grid[i][j] = "O";
                    count += 1;
                }
            }
        }
        this.printGrid();
        if(didWin())
        {
            System.out.println(p2.name+" has won the game!");
            return true;
        }
        this.turn += 1;
        return false;
    }
    // check if anyone won
    public boolean didWin()
    {
        /** shows if the player won the game.
         */
        // checks the rows
        for(int i=0;i<this.grid.length; i++)
        {
            int count = 0;
            for(int j=0;j<this.grid[0].length-1;j++)
            {
                if (this.grid[i][j] == this.grid[i][j+1] && this.grid[i][j]!=null)
                {
                    count +=1;
                }
                if( count == 2)
                    return true;
            }
        }
        //checks for the columns
        for(int i=0;i<this.grid.length; i++)
        {
            int count = 0;
            for(int j=0;j<this.grid[0].length-1;j++)
            {
                if (this.grid[j][i] == this.grid[j+1][i] && this.grid[i][j]!=null)
                {
                    count +=1;
                }
                if( count == 2)
                    return true;
            }
        }
        // checks the right diagonal
        for(int i=0;i<this.grid.length;i++)
        { 
            int count = 0;
            for(int j=0;j<this.grid[0].length-1;j++)
            {
                if(i+j == this.grid.length && this.grid[i][j]!=null)
                {
                    if(this.grid[i][j] == this.grid[i-1][j+1])
                    {
                       count += 1;
                    }
                }
            }
            if(count == 2)
            return true;
        }
        for(int i=0;i<this.grid.length-1;i++)
        {   
            int count = 0;
            for(int j=0;j<this.grid[0].length;j++)
            {
                if(i==j)
                {
                    if(this.grid[i][j] == this.grid[i+1][j+1] && this.grid[i][j]!=null)
                    {
                        count +=1;
                    }
                }
            }
          if(count ==2)
                return true; 
            }
            return false;
    }
    public void printGrid()
    {// prints the grid of the game
        for(int i=0;i<this.grid.length;i++)
        {
            for(int j=0;j<this.grid[0].length;j++)
            {
                System.out.print(this.grid[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
            
    