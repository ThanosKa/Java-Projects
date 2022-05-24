/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JThreads;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 *
 * @author admin
 */
public class Obj  {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException   {
        // TODO code application logic here
            System.out.print("Enter the file to scan  with path.\nE.g src/inputs/input5.txt\n ");
            Scanner arg0 = new Scanner(System.in);
            File file = new File(arg0.nextLine());
            arg0 = new Scanner(file);
            
            //entering the times you want to run 
            Scanner arg1 = new Scanner(System.in);
            System.out.println("Enter how many  times to run:");
            int times = arg1.nextInt();
           // System.out.println(times);

              //Enter file name output from command line 
            System.out.print("Enter the name of the output file  with path.\nE.g src/OutputFile/output.txt\n ");
            Scanner arg2 = new Scanner(System.in);
            String str = arg2.nextLine();
        
                                //entering the times you want to run 
            Scanner arg3 = new Scanner(System.in);
            System.out.println("Enter Threads");
            int threads = arg3.nextInt();
            //System.out.println(threads);
            
            int N = arg0.nextInt();
            double R = arg0.nextDouble();
            
            Simulate sim = new Simulate(N,R,times,threads,arg0,str);
           // sim.pr();
           
           


        
    }

}
