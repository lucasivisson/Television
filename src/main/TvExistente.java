package main;

public class TvExistente extends Exception{
    private String id;
    
    public TvExistente(String id){
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "A Televisão " + this.id + " já existe.";
    }
}
