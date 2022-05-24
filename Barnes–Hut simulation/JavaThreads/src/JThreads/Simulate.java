/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JThreads;
  
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author admin
 */
public class Simulate {
    
    private final List<Planet> planets;
    //private final List<Planet> planets;
    private static  double GRAVITY =  6.67e-11;
    private static double DT = 1.0;
    
    double R;
    int times;
    int N;
    int threads;
    int counter;
    long  elapsed=0;
    //private Quad q = new Quad(0,0,2*R);
    Simulate(int N, double R, int times, int threads,Scanner arg0,String str) throws IOException {
        //planets = new ArrayList<Planet>();
        planets = new ArrayList<Planet>();
        this.R=R;
        this.N=N;
        this.times=times;
        this.threads=threads;
        counter = times;
        
        initPlanets(N,arg0,str);
        
    } 
    private Quad q = new Quad(0,0,2*R);

    private void initPlanets(int N,Scanner arg0,String str) throws IOException {
        //Planet planet = new Planet(0, 0, 0, 0, 0, null);
        //planets.plus(planet);
        //Planet[] planets = new Planet[N];
        BHTree tree = new BHTree(q);
        Planet pl = new Planet(0, 0, 0, 0, 0, null);
        planets.add(pl);
        for (int i = 0; i < N; i++) {
            double x = arg0.nextDouble();
            double y = arg0.nextDouble();
            double vx = arg0.nextDouble();
            double vy = arg0.nextDouble();
            double mass = arg0.nextDouble();
            String name = arg0.nextLine();
            planets.add(new Planet(x, y, vx, vy, mass, name));
        }
        
        long startTree  = System.nanoTime();
        for(Planet planet : planets)
        {
            if(q.contains(planet)) //ignores planets outside the uni
                tree.insert(planet);
        }
        long endTree = System.nanoTime()-startTree;
        
        CyclicBarrier barrier = new CyclicBarrier(threads);
	CyclicBarrier done = new CyclicBarrier(threads + 1);
        
        for(int i=0; i<threads;i++){
                //System.out.print("Mp");
                new  Parallel(i,threads,q,tree,planets,barrier,done).start();
         }
            
            try{
                done.await();
                long a = System.nanoTime();
                done.await();
                long b = System.nanoTime();
                elapsed += b;
                elapsed += endTree;
            }catch(BrokenBarrierException | InterruptedException e) {
			e.printStackTrace();
            }
           
               
                System.out.println("\nTime Elapsed " + elapsed*1e-6 +  " mil seconds");
  
            
            
            File dest = new File(str);
            FileWriter writer = new FileWriter(dest);
            for(int i = 0; i <planets.size(); i++)
        {
            writer.write(planets.toString());
           
        }
        
    }
    
    
    
    
}
