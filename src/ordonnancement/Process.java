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
public class Process {
    
    public static int NOMBRE=1,temps_exe=0;
    public String nom;
    public int D_encours,pos=0;
    private int Duree;
    private int priorite;
    private int Tarrive;
    private int  tdebut,tfin;
    private float TROT,TATT;

  
    public Process(int Duree, int Tarrive) {
        this.nom = "p"+NOMBRE;
        this.Duree = Duree;
        this.D_encours=Duree;
        this.Tarrive = Tarrive;
        temps_exe+=Duree;
        NOMBRE++;
    }
    
     public Process(int Duree, int Tarrive , int priorite) {
        this.nom = "p"+NOMBRE;
        this.Duree = Duree;
        this.priorite = priorite;
        this.D_encours=Duree;
        this.Tarrive = Tarrive;
        NOMBRE++;
    }

    
    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public int getTarrive() {
        return Tarrive;
    }

    public void setTarrive(int Tarrive) {
        this.Tarrive = Tarrive;
    }
    
   
    public int getTfin() {
        return tfin;
    }

    public void setTfin(int tfin) {
        this.tfin = tfin;
    }

    public int getTdebut() {
        return tdebut;
    }

    public void setTdebut(int tdebut) {
        this.tdebut = tdebut;
    }

    public float getTROT() {
        return TROT;
    }

    public void setTROT(float TROT) {
        this.TROT = TROT;
    }

    public float getTATT() {
        return TATT;
    }

    public void setTATT(float TATT) {
        this.TATT = TATT;
    }
           
    
 }
