package main;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Televisao {
    protected String id;
    protected int volume;
    protected Canal canalAtual;
    protected ArrayList<Canal> canaisCadastrados = new ArrayList<Canal>();
    protected ArrayList<Canal> canaisDisponiveis = new ArrayList<Canal>();
    
    public static final int VOLUME_MAX = 10;
    public static final int VOLUME_MIN = 0;

    public Televisao(ArrayList<Canal> canaisDisponiveis, String id) {
        this.canaisDisponiveis = canaisDisponiveis;
        this.id = id;
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
    public String getId(){
        return this.id;
    }
    public void setCanalAtual(String id){
        this.id = id;
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
                throw new CanalInexistente(numeroDoCanal);
            }
        } catch(Exception e){
            System.out.println("Aconteceu um erro");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public Canal alterarCanal(String escolha){
        if(escolha.equals("anterior")){
            for(int i = 0; i < canaisDisponiveis.size(); i++) {
                if (canalAtual == canaisDisponiveis.get(0)) {
                    canalAtual = canaisDisponiveis.get(canaisDisponiveis.size() - 1);
                    break;
                } else if(canalAtual == canaisDisponiveis.get(i)) {
                    canalAtual = canaisDisponiveis.get(i - 1);
                    break;
                }
            }
        }
        if(escolha.equals("próximo")){
            for(int i = 0; i < canaisDisponiveis.size(); i++) {
                if (canalAtual == canaisDisponiveis.get(canaisDisponiveis.size())) {
                    canalAtual = canaisDisponiveis.get(0);
                    break;
                } else if(canalAtual == canaisDisponiveis.get(i)) {
                    canalAtual = canaisDisponiveis.get(i + 1);
                    break;
                }
            }
        }
        return canalAtual;
    }
    
    public void informarDados(){

        System.out.println("Nome do canal: " + this.canalAtual.getNome());
        System.out.println("Número do canal: " + this.canalAtual.getNumeroDoCanal());
        System.out.println("Canal HD: " + this.canalAtual.getHd());
    }
    
    public void mostrarGrade() {        
        
        Collections.sort(canaisDisponiveis);

        for( int i = 0; i < canaisDisponiveis.size(); i++) {
            System.out.println("Nome do canal: " + canaisDisponiveis.get(i).getNome());
            System.out.println("Número do canal: " + canaisDisponiveis.get(i).getNumeroDoCanal());
            System.out.println("Canal HD: " + canaisDisponiveis.get(i).getHd());
        }
    }
}
