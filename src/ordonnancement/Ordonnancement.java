/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordonnancement;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Savitar
 */
public class Ordonnancement {

    /**
     * @param args the command line arguments
     */
      static int n;
    
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int d,ta,prio;
        System.out.println("nombre de processus");
        n=in.nextInt();
        Process tab[]=new Process[n];
        
        
        for(int i=0;i<n;i++){
            System.out.println("duree de processus p"+(i+1)+" :");
            d=in.nextInt();
            System.out.println("a quel moment le processus est il arrivé?");
            ta=in.nextInt();
            System.out.println("quel est sa priorite?");
            prio=in.nextInt();
           
            
            Process p=new Process(d,ta,prio);
            tab[i]=p;      
                
            if(i==n-1){
                  System.out.println("ok commencons");
            }
            
        }
             menu();
             System.out.println("                                      choisir l'ago");
             int algo=in.nextInt(),rr;
               Algo ordo=new Algo(tab,algo);
               
          switch (algo) {  
            
              case 1:   
                  System.out.println("Affichage GANTT: \n");
                  ordo.cooperatif(tab); 
                 break;
              case 2:   
                   System.out.println("Affichage GANTT: \n");
                  ordo.cooperatif(tab); 
                break;
                 case 3:   
                      System.out.println("Affichage GANTT: \n");
                  ordo.preemtif(tab); 
                break;
                  case 4:   
                      System.out.println("choisir le quantum");
                       rr=in.nextInt();
                        System.out.println("Affichage GANTT:  \n");
                     ordo.rr(tab,rr); 
                 break;
                 case 5:   
                      System.out.println("Affichage GANTT:  \n");
                  ordo.cooperatif(tab); 
                break;
              default:
                    System.out.println("Algorithme en cours de codage");
                    
        }
  
    }
    
     
        
public static void menu(){
            
  
            try{
            Runtime.getRuntime().exec("CLS");
            }catch(IOException e){}
            
            System.out.println("                                  *************************SELECT**************************");
            System.out.println("                                  *******************-----------------*********************");
            System.out.println("                                  **                                                     **");
            System.out.println("                                  **                                                     **");
            System.out.println("                                  **                 1-FCFS/PAPS                         **");
            System.out.println("                                  **                 2-SJF                               **");
            System.out.println("                                  **                 3-SRT                               **");
            System.out.println("                                  **                 4-RR/Touniquet                      **");
            System.out.println("                                  **                 5-Priorité                          **");
            System.out.println("                                  **                 6-Priorité dynamique                **");
            System.out.println("                                  **                 7-exit                              **");
            System.out.println("                                  **                                                     **");
            System.out.println("                                  **                                                     **");
            System.out.println("                                  *********************************************************");
            
        }
}
