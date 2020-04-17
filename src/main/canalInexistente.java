package main;

public class canalInexistente extends Exception{
    private int numeroDoCanal;

    public canalInexistente(int numeroDoCanal) {
        this.numeroDoCanal = numeroDoCanal;
    }  
     
    @Override
    public String toString(){
        return "Canal " + numeroDoCanal + " Inexistente";
    }
}
