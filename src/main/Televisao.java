
package main;

import java.util.ArrayList;

public abstract class Televisao {
    private String id;
    private int volume;
    private Canal canalAtual;
    private ArrayList<Canal> canaisCadastrados;
    private ArrayList<Canal> canaisDisponiveis;
    
    public static final int VOLUME_MAX = 10;
    public static final int VOLUME_MIN = 0;

    public Televisao(ArrayList<Canal> canaisDisponiveis) {
        this.canaisDisponiveis = canaisDisponiveis;
        this.volume = 5;
    }
    public int getVolume(){
        return this.volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public Canal getCanalAtual(){
        return this.canalAtual;
    }
    public void setCanalAtual(Canal canalAtual){
        this.canalAtual = canalAtual;
    }
    
    public int alterarVolume(String escolha){
        if(escolha.equals("aumenta")){
            if(this.volume < VOLUME_MAX){
                this.volume++;   
            }
        } else if(escolha.equals("diminui")){
            if(this.volume > VOLUME_MIN){
                this.volume--;
            }
        }
        return this.volume;
    }
    
    public abstract void cadastrarCanais();
    
    public boolean verificarCanalExistente(Canal canal){
        boolean canalExiste = false;
        for(int i=0; i<canaisDisponiveis.size(); i++){
            if(canaisDisponiveis.get(i).getNome().equals(canal.getNome())){
                canalExiste = true;
                return canalExiste; 
            }
        }
        return canalExiste;
    }
    
    public void sintonizar(int numeroDoCanal){
        try{
            boolean numeroDoCanalExiste = false;
            for(int i=0; i<canaisDisponiveis.size(); i++){
                if(canaisDisponiveis.get(i).getNumeroDoCanal() == numeroDoCanal){
                    numeroDoCanalExiste = true;
                }
            }
            if(numeroDoCanalExiste){
                this.canalAtual.setNumeroDoCanal(numeroDoCanal);
            }else if(!numeroDoCanalExiste){
                throw new canalInexistente(numeroDoCanal);
            }
        } catch(Exception e){
            System.out.println("Aconteceu um erro");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void alterarCanal(String escolha){
        
    }
    
    public void informarDados(){
        System.out.println("Nome do canal: " + this.canalAtual.getNome());
        System.out.println("Número do canal: " + this.canalAtual.getNumeroDoCanal());
        System.out.println("Canal HD: " + this.canalAtual.getHd());
    }
}
