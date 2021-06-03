import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * This DataPlotter object reads a space delimited text file of elevations
 * and plots the result as a range of greyscale images, and then calculates 
 * and plots the steepest downward path from each location in the image.
 * 
 * @author 
 * @version 
 */
public class DataPlotter
{
    private static String fileName = "Colorado";
    private static int[][] grid;
    private static DrawingPanel panel;
    private static Scanner fileReader;
    private static int rows, cols;

    public static void main(String[] args) throws IOException
    {
        readValues();
        plotData();
        try {Thread.sleep(3000); } catch (Exception e){};  // pause display for 3 seconds
        plotAllPaths();
        
    }

    private static void readValues() throws IOException
    {
        fileReader = new Scanner(new File(fileName + ".dat"));
        rows = fileReader.nextInt();    // first integer in file
        cols = fileReader.nextInt();    // second integer in file
        grid = new int[rows][cols];
        for (int i = 0; i < (grid.length); i++)
        {   for (int c = 0; c<grid[0].length;c++)
            { grid[i][c] = fileReader.nextInt();
              
            }
        }
        System.out.println(grid[0][0]);        
        System.out.println(grid[0][grid[0].length-1]);
        System.out.println(grid[grid.length-1][0]);
        System.out.println(grid[grid.length-1][grid[0].length-1]);
        // instantiate and initialize the instance variable grid 
        // then read all of the data into the array in row major order
    }

    // plot the altitude data read from file
    private static void plotData()
    {
        panel = new DrawingPanel(cols, rows);
        int high = grid[0][0] ;
        int low = grid[0][0];
        for (int[] i : grid)
        {   for (int c :i)
            { if ( c> high )
                { high = c;
            }
              else if ( c<low )
              {low = c;}
            }
        }
         System.out.println("higest is "+high+"lowest is "+low);
         for (int i = 0; i < (grid.length); i++)
        {   for (int c = 0; c<grid[0].length;c++)
            {   int var = (int)((grid[i][c]-low)*0.0767);
               
                Color color = new Color (var,var,var);
                panel.setPixel(c, i, color);
              
            }
        }
        
    }

    // for a given x, y value, plot the downhill path from there
    private static void plotDownhillPath(int x, int y)
    { panel.setPixe
    }

    private static void plotAllPaths()
    {
        plotDownhillPath(0, 0);
    }

}