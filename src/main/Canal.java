package main;

public class Canal {
    private int numeroDoCanal;
    private String nomeDoCanal;
    private boolean hd;
    
    public int getNumeroDoCanal(){
        return this.numeroDoCanal;
    }
    public void setNumeroDoCanal(int numeroDoCanal){
        this.numeroDoCanal = numeroDoCanal;
    }
    public String getNome(){
        return this.nomeDoCanal;
    }
    public void setNome(String nomeDoCanal){
        this.nomeDoCanal = nomeDoCanal;
    }
    public boolean getHd(){
        return this.hd;
    }
    public void setHd(boolean hd) {
        this.hd = hd;
    }
    public Canal(int numeroDoCanal, String nomeDoCanal, boolean hd){
        this.numeroDoCanal = numeroDoCanal;
        this.nomeDoCanal = nomeDoCanal;
        this.hd = hd;
    }
}
