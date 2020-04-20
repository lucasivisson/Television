package main;

import java.util.ArrayList;

public class ControleRemoto {
    private ArrayList<Televisao> listaDeTv = new ArrayList<Televisao>();

    public ArrayList<Televisao> getListaDeTv() {
        return listaDeTv;
    }

    public void setControle(ArrayList<Televisao> listaDeTv) {
        this.listaDeTv = listaDeTv;
    }
    
    public void adicionarTv(Televisao tv){
        try{
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(tv.id)){
                throw new TvExistente(tv.getId());
            }else if(!listaDeTv.get(i).getId().equals(tv.id)){
                listaDeTv.add(tv);
            }
        }
        } catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void aumentarVolume(String id, String escolha){
        for(int i=0; i<listaDeTv.size(); i++){
            if(listaDeTv.get(i).getId().equals(id)){
                listaDeTv.get(i).alterarVolume(escolha);
            }
        }
    }
}
