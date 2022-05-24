/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JThreads;

/**
 *
 * @author admin
 */
public class Planet {
    
    private static   double GRAVITY =  6.67e-11;
    //private static double  DT = 1e11;
    double x;
    double y;
    private double Vx,Vy;
    private double Fx, Fy;
    private double mass;
    private String name;;

    
     /**
     * Constructor: creates and initializes a new Planet.
     * @param x
     * @param y
     * @param Vx
     * @param Vy
     * @param mass
     * @param name
     */
    public Planet(double x, double y, double Vx, double Vy, double mass, String name) {
        this.x    = x;
        this.y    = y;
        this.Vx    = x;
        this.Vy    = y;
        this.mass  = mass;
        this.name = name;
    }
    
    
     /**
     * update speed and pos of planet 
     * time step is dt 
     * @param dt
     */
    public void update(double dt) {
        Vx+= dt*Fx/mass;
        Vy += dt*Fy/mass;

        x += dt * Vy;
        y += dt *Vy;
        

    }
    
     public double distance(Planet pl)
    {
        double dx = x - pl.x;
        double dy = y -pl.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    
     
     public void resetForce()
    {
        Fx=0.0;
        Fy=0.0;

    }
    public void addForce(Planet pl)
    {
        Planet a = this;
        double dx = pl.x - a.x;
        double dy = pl.y - a.y;
        double distance  = Math.sqrt(dx*dx + dy*dy);
        double F = (GRAVITY*a.mass *pl.mass) / (distance * distance);

        a.Fx += F*dx/distance;
        a.Fy += F*dy/distance;


    }
    
       public boolean inQuad(Quad q){
        return q.contains(this.x, this.y);
    }
       
       
       public Planet plus(Planet pl) {
        Planet a = this;

        double m = a.mass + pl.mass;
        double x = (a.x * a.mass +pl.x*pl.mass)/m;
        double y = (a.y * a.mass +pl.y*pl.mass)/m;
        
        return new  Planet(x, y, a.Vx, a.Vy, m, a.name);
    }
       
       //public void  calcForce(int )
    @Override
    public String toString() {
        return String.format("%12.5E %12.5E %12.5E %12.5E %12.5E %12s\n", x, y, Vx, Vy, mass,name);
    }

}
