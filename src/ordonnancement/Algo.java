/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordonnancement;

/**
 *
 * @author Savitar
 */
public class Algo {
    
    public float TMR,TMA,DEBIT;
    public int algo;
    public Process[] tab;
    public Process[] file;
 

    public Algo(Process[] tab,int algo) {
        this.tab = tab;
        this.algo=algo;
        this.TMR=0;
        this.TMA=0;
        this.DEBIT=0;
    }
    
    
    public  void cooperatif(Process[] tab){
            int fin=0;
            Assets.classArr(tab);
          
            if(this.algo==5){
               Assets.regler(tab);
           }
            
            if(this.algo==2 && Assets.zero(tab)){
                  Assets.classDuree(tab);
              }
           
            if(this.algo==2){
                Assets.reglersjf(tab);
             }
              
            
            Process encours=tab[0];
            
           
            for(int i=0;i<tab.length;i++){
                
                encours.setTdebut(fin);
                
                if(this.algo==1 || this.algo==5)
                    encours=tab[i];
               
            do{
                encours.D_encours--;
                fin++;
                System.out.print(encours.nom); 
                
            }while(encours.D_encours>0);
            
            
            
             encours.setTfin(fin);   
             encours.setTROT(encours.getTfin()-encours.getTarrive());
             encours.setTATT(encours.getTROT()-encours.getDuree());
            // TMR+=encours.getTROT();
             //TMA+=encours.getTATT();
            // taille_actu=tab.length-(i+1);
             
              if(this.algo==2){
                 Assets.encours(tab,fin);
                 encours=tab[0];
                  //System.out.println("encours \n"+encours.nom+"encours \n");
             }
                 
            }
            
             Assets.calcul_temps(this,tab);
             Assets.affichage(tab);
             System.out.println(" "); 
             System.out.println("      TEMPS MOYEN DE ROTATION ="+TMR); 
             System.out.println("      TEMPS MOYEN D'ATTENTE="+TMA); 
        }
     
      public  void preemtif(Process[] tab){
            int fin=0;
            Assets.classArr(tab);
            if(this.algo==3 && Assets.zero(tab)){
                  Assets.classDuree(tab);
              }
            Assets.regler(tab);
            
             if(this.algo==3){
                Assets.reglersjf(tab);
             } 
              
            
            Process encours=tab[0];
            
          
            for(int i=1;i<=Assets.tempsexe(tab);i++){
                 
                if(this.algo==3){
                 encours=Assets.encours(tab,encours,fin);               
                 //System.out.println("\n encours"+encours.nom+"encours \n");
             }
                
                encours.setTdebut(fin);
                
                
                boucle:
            do{
                if(encours.D_encours<=0){
                    break boucle; 
                }  
                
                encours.D_encours--;
                fin++;
                System.out.print(encours.nom);
    
            }while(false);
                //System.out.println("out");
            
            
             encours.setTfin(fin);   
             encours.setTROT(encours.getTfin()-encours.getTarrive());
             encours.setTATT(encours.getTROT()-encours.getDuree());
             //TMR+=encours.getTROT();
             //TMA+=encours.getTATT();
            // taille_actu=tab.length-(i+1);
             
             
                 
            }
            
             Assets.calcul_temps(this,tab);
             Assets.affichage(tab);
              System.out.println(" ");
              System.out.println("  TEMPS MOYEN DE ROTATION ="+TMR); 
              System.out.println("  TEMPS MOYEN D'ATTENTE="+TMA); 
        }
      
      public void rr(Process[] tab,int q){
        int fin=0,nbexe=0;
            Assets.classArr(tab);
            Process encours=tab[0];
             //encours.pos=1;
             // Assets.addpos(tab, fin,encours.pos);
            //int t=0;
            int k=0;
             for(int i=0;i<Assets.tempsexe(tab);i+=q){
                 encours=tab[k];
                  encours.setTdebut(fin);
                   
                     
                     //System.out.println(i);
                     for(int j=1;j<=q;j++){
                         if(encours.D_encours>0){
                        System.out.print(encours.nom);
                         encours.D_encours--;
                         fin++;
                         }
                     }  
                     
                     
                     nbexe+=q;
                     
                      encours.setTfin(fin);   
             encours.setTROT(encours.getTfin()-encours.getTarrive());
             encours.setTATT(encours.getTROT()-encours.getDuree());
             
             //t=Assets.file_taille(tab, fin);
             //int a=Assets.findone(tab,encours.pos);
             //encours.pos=t+1;
            //encours=tab[a];
            
                k++;
                if(k>=tab.length)
                    k=0;
             }
      
                Assets.calcul_temps(this,tab);
                Assets.affichage(tab);
             System.out.println(" "); 
             System.out.println("      TEMPS MOYEN DE ROTATION ="+TMR); 
             System.out.println("      TEMPS MOYEN D'ATTENTE="+TMA); 
      
      }
      

     
}
