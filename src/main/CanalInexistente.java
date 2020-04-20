package main;

public class CanalInexistente extends Exception{
    private int numeroDoCanal;

    public CanalInexistente(int numeroDoCanal) {
        this.numeroDoCanal = numeroDoCanal;
    }  
     
    @Override
    public String toString(){
        return "Canal " + numeroDoCanal + " Inexistente.";
    }
}
