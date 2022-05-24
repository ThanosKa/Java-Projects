/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JThreads;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author admin
 */


public class Parallel extends Thread {
    
private int ID;
private int threads;
private Quad q;
private BHTree tree;
//private Planet planets[];
private List<Planet> planets;
private CyclicBarrier barrier;
private CyclicBarrier done;

    Parallel(int ID, int threads, Quad q, BHTree tree, List<Planet> planets, CyclicBarrier barrier, CyclicBarrier done) {
        this.ID=ID;
        this.threads=threads;
        this.q=q;
        this.tree=tree;
        this.planets=planets;
        this.barrier=barrier;
        this.done=done;

    }
    
    @Override
    public void run()
    {
        try{
           
            done.await();
            calculateForces();
            barrier.await();
            movePlanets();
            done.await();
            
        } catch (BrokenBarrierException | InterruptedException e) {
		e.printStackTrace();
        }
    }

    private void calculateForces() {
        for(int i =ID; i<planets.size();i+=threads)
        {
            //Planet pl = planets[i];
            Planet pl = planets.get(i);
            pl.resetForce();
            if(q.contains(pl))
                   tree.updateForce(pl);
        }
    }

    private void movePlanets() {
         for(int i =ID; i<planets.size();i+=threads)
        {
            //Planet pl = planets[i];
            Planet pl = planets.get(i);
            pl.resetForce();
            if(q.contains(pl))
                   pl.update(1.0);
        }
    }
    
    
    
}
