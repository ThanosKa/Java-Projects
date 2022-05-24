/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JThreads;

/**
 *
 * @author admin
 */
public class Quad {
    
    double x;
    double y;
    private double length;
    
    
     /**
     * Creates a new quadrant
     * @param x
     * @param y
     * @param length
     */
    public Quad(double x, double y, double length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
    
    
    
    public double length() 
    {
        return length;
    }

    public boolean contains(double x, double y) {
        double midLen = this.length / 2.0;
        if(x <= this.x + midLen && x>= this.x - midLen && y <= this.y + midLen && y>= this.y - midLen)
            return true;
        else return false;
    }
    
    public boolean contains(Planet pl)
    {
        return contains(pl.x,pl.y);
    }
    
   
    
    
      public Quad NW() 
    {
        double x = this.x + this.length / 4.0;
        double y = this.y + this.length / 4.0;
        double len = this.length / 2.0;

        Quad NW = new Quad(x,y,len);
        return NW;
    }

    public Quad NE() 
    {
        double x = this.x + this.length / 4.0;
        double y = this.y + this.length / 4.0;
        double len = this.length / 2.0;

        Quad NE = new Quad(x,y,len);
        return NE;
    }

    public Quad SW() 
    {
        double x = this.x + this.length / 4.0;
        double y = this.y + this.length / 4.0;
        double len = this.length / 2.0;

        Quad SW = new Quad(x,y,len);
        return SW;
    }

    public Quad SE() 
    {
        double x = this.x + this.length / 4.0;
        double y = this.y + this.length / 4.0;
        double len = this.length / 2.0;

        Quad SE = new Quad(x,y,len);
        return SE;
    }

}
