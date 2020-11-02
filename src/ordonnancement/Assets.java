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
public class Assets {

    public Assets() {
    }
    
    public static void affichage(Process[] tab){
        System.out.println("     \n \n  "); 
        System.out.println("Processus\tTemps_ARV\tTemps_Exct\tTemps_fin_Excs\t Temps_Rot\t Temps_Att");
		        for(int i = 0; i < tab.length; i++) {
		        	System.out.println(tab[i].nom+"\t\t\t"+tab[i].getTarrive()+"\t\t"+tab[i].getDuree()+"\t\t"+tab[i].getTfin()+"\t\t"+tab[i].getTROT()+"\t\t"+tab[i].getTATT());
					
		        }
          
    }
    
         public static void calcul_temps(Algo a,Process[] tab){
    
        for (Process tab1 : tab) {
            a.TMR += tab1.getTROT();
            a.TMA += tab1.getTATT();
        }
        
          a.TMR/=tab.length;
          a.TMA/=tab.length;
          
         }
         
        public static void classDuree (Process[] tab){
       
        int i,j;
        Process encours;
        
                    
                    for( i=0;i<tab.length;i++){
                        
                            encours=tab[i];
                         for( j=i;j>0 && tab[j-1].getDuree()>encours.getDuree();j--){
                        
                            tab[j]=tab[j-1];                        
                        }
                            tab[j]=encours;
                    }
  

            }
        
         public static void classDuree (Process[] tab,int fin){
       
        int i,j;
        Process encours;
        
                    
                    for( i=0;i<tab.length;i++){
                        if(tab[i].getTarrive()<fin && tab[i].D_encours!=0){
                            encours=tab[i];
                         for( j=i;j>0 && tab[j-1].getDuree()>encours.getDuree();j--){
                        
                            tab[j]=tab[j-1];                        
                        }
                            tab[j]=encours;
                    }
                    }
  

            }
    
    public static void classArr (Process[] tab){
       
        int i,j;
        Process encours;
        
                    
                    for( i=0;i<tab.length;i++){
                        
                        
                            encours=tab[i];
                         for( j=i;j>0 && tab[j-1].getTarrive()>encours.getTarrive();j--){
                        
                            tab[j]=tab[j-1];                        
                        }
                            tab[j]=encours;
                        }
                        

            }
    
    public static void classPrio (Process[] tab){
       
        int i,j;
        Process encours;
        
                    
                    for( i=0;i<tab.length;i++){
                        
                            encours=tab[i];
                         for( j=i;j>0 && tab[j-1].getPriorite()>encours.getPriorite();j--){
                        
                            tab[j]=tab[j-1];                        
                        }
                            tab[j]=encours;
                    }

            }
    
     public static void regler(Process[] tab){
         
     int i;
     Process temp;
        
        for( i=0;i<tab.length-1;i++){
        
            if(tab[i].getTarrive()==tab[i+1].getTarrive()){
                
                if(tab[i].getPriorite()<tab[i+1].getPriorite()){      
                   
                    temp=tab[i];
                    tab[i]=tab[i+1];
                    tab[i+1]=temp;
                    
                }
                
                 }
        }
     }
     
       public static void reglersjf(Process[] tab){
         
     int i;
     Process temp;
        
        for( i=0;i<tab.length-1;i++){
        
            if(tab[i].getTarrive()==tab[i+1].getTarrive()){
                
                if(tab[i].getDuree()>tab[i+1].getDuree()){      
                   
                    temp=tab[i+1];
                    tab[i+1]=tab[i];
                    tab[i]=temp;
                    
                }
                
                 }
        }
     }
     public static void encours(Process[] tab,int fin){
       int  min=1000;
       
       for(int i=1;i<tab.length;i++){
                        if(tab[i].getTarrive()<fin && tab[i].D_encours>0){
                           if(tab[i].D_encours<min){
                           min=tab[i].D_encours;
                           tab[0]=tab[i];
                        }
                        }
                    }
     }
     
     public static int file_taille(Process[] tab,int fin){
       int t=0;
       
       for(int i=0;i<tab.length;i++){
                        if(tab[i].getTarrive()<fin && tab[i].D_encours>0){
                          t++;
                        }
                        }
       return t;
     }
     public static int findone(Process[] tab,int pos){
       int i=0; 
       
       for(i=0;i<tab.length;i++){
                        if(tab[i].pos==(pos+1) && tab[i].D_encours>0){
                          return i;
                        }
                        }
       return 0;
     }
     
     
     public static void addpos(Process[] tab,int fin,int pos){
       
        
        int i,j;
        
                    
                    for( i=1;i<tab.length;i++){
                        if(tab[i].getTarrive()<fin && tab[i].D_encours!=0){
                           tab[i].pos=pos+1;
                        }
                    }
  

            }
     
      public static Process encours(Process[] tab,Process p,int fin){
       int  min=(p.D_encours<=0)?100:p.D_encours;
       Process temp=p;
       
       for(int i=0;i<tab.length;i++){
             //System.out.println(fin);
              // System.out.println(tab[i].getTarrive());
               //System.out.println(tab[i].D_encours);
               
                        if(tab[i].getTarrive()<=fin && tab[i].D_encours>0){
                           if(tab[i].D_encours < min){
                               //System.out.println("trouve");
                           min=tab[i].D_encours;
                           temp=tab[i];
                        }
                        }                     
                    }
        return temp;
     }
     
       public static boolean zero(Process[] tab){
      
       
       for(int i=1;i<tab.length;i++){
           
                        if(tab[i].getTarrive()!=0)
                          return false;
                        
                        
                    }
       return true;
     }
       
       public static int tempsexe(Process[] tab){
      
       int sum=0;
       for(int i=0;i<tab.length;i++)
            sum+=tab[i].getDuree();
       
       return sum;
     }
       
       public static boolean isone(Process[] tab,Process p,int fin){
      
       
        for (Process tab1 : tab) {
            if (tab1.D_encours < p.D_encours && tab1.D_encours > 0 && tab1.getTarrive() < fin) {
                return false;
            }
        }
       
       return true;
     }
       
   /*  int i,tfixe=0,evol=0;
     Process t[]=new Process[taille];
     Process temp;
        
        for( i=indice;i<t.length-1;i++){
            
            if(t[i].getTarrive()<=tempsfin && t[i].getDuree()!=0){
            t[evol]=tab[i];
            tfixe++;
            evol++;
            }
        }
        
         for( i=0;i<tfixe;i++){
        
            if(t[i].getDuree()>t[i+1].getDuree()){
                        
                    temp=t[i];
                    t[i]=t[i+1];
                    t[i+1]=temp;
                    
                }
                
                
        }
     
        return t[0];
     }*/
    
}
