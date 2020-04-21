package main;

import java.util.ArrayList;

public class ControleRemoto {
    private ArrayList<Televisao> listaDeTv;

    public ControleRemoto(ArrayList<Televisao> listaDeTv) {
        this.listaDeTv = listaDeTv;
    }

    public ArrayList<Televisao> getListaDeTv() {
        return listaDeTv;
    }

    public void setControle(ArrayList<Televisao> listaDeTv) {
        this.listaDeTv = listaDeTv;
    }
    
    public void adicionarTv(Televisao tv){
        try{
        int quantDeTv = listaDeTv.size();
            if(quantDeTv > 0){
                for(int i=0; i<quantDeTv - 2; i++){
                    if(listaDeTv.get(i).getId().equals(tv.id)){
                        throw new TvExistente(tv.getId());
                    }
                }
            } else {
                listaDeTv.add(tv);   
            }
        } catch(TvExistente e){
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void verificarCanalExistente(String tvId, int numeroDoCanal, String nomeDoCanal, boolean ehHd){
        boolean tvExiste = false;
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(tvId)){
                tvExiste = true;
                Canal canalExiste = new Canal(numeroDoCanal, nomeDoCanal, ehHd);
                
                boolean existeCanal = listaDeTv.get(i).verificarCanalExistente(canalExiste);
                if(existeCanal){
                    System.out.println("O canal existe!");
                }else{
                    System.out.println("O canal não existe!");
                }
            }
        }
        if(!tvExiste){
            System.out.println("A tv escolhida não existe");
        }
    }
    
    public void alterarVolume(String id, String escolha){
        int volumeAtual = 0;
        boolean tvExiste = false;
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(id)){
                tvExiste = true;
                volumeAtual = listaDeTv.get(i).alterarVolume(escolha);
                System.out.println("TV: " + listaDeTv.get(i).getId());
                System.out.println("Volume: " + volumeAtual);
            }
        }
        if(!tvExiste){
            System.out.println("A tv escolhida não existe");
        }
    }
    
    public void sintonizar(String id, int numeroDoCanal){
        boolean existeTv = false;
        boolean existeCanal = false;

        for(int i = 0; i < listaDeTv.size(); i++) {
            if(listaDeTv.get(i).getId().equals(id)) {
                existeTv = true;

                for(int j = 0; j < listaDeTv.get(i).canaisDisponiveis.size(); j++) {
                    if(listaDeTv.get(i).canaisDisponiveis.get(j).getNumeroDoCanal() == numeroDoCanal) {
                        listaDeTv.get(i).sintonizar(numeroDoCanal);
                        System.out.println("Canal sintonizado com sucesso!");
                        System.out.println("Canal Atual: " + listaDeTv.get(i).toString());

                        existeCanal = true;
                    }
                    if(existeCanal) {
                        break;
                    }
                }

            }
        }
        if(!existeTv) {
            System.out.println("Tv não existe, tente novamente.");
        }
        if(!existeCanal) {
            System.out.println("Canal não existe, tente novamente.");
        }
    }
    
    public void alterarCanal(String id, String escolha){
        boolean existeTv = false;
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(id)){
                existeTv = true;
                listaDeTv.get(i).alterarCanal(escolha);
            }
        }
        if(!existeTv){
            System.out.println("Tv não existe, tente novamente.");
        }
    }
    
    public void informarDados(String id){
        boolean existeTv = false;
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(id)){
                existeTv = true;
                listaDeTv.get(i).informarDados();
            }
        }
        if(!existeTv){
            System.out.println("Tv não existe, tente novamente.");
        }
    }
    
    public void mostrarGrade(String id){
        boolean tvExiste = false;
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(id)){
                tvExiste = true;
                listaDeTv.get(i).mostrarGrade();
            }
        }
        if(!tvExiste){
            System.out.println("A tv escolhida não existe");
        }
    }
    
    public void mostrarTvsDisponiveis(){
        for(int i=0; i<listaDeTv.size(); i++){
            System.out.println(listaDeTv.get(i).getId());
        }
    }
}
