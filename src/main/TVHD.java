package main;

import java.util.*;

public class TVHD extends Televisao {
    private String modelo;
    private ArrayList<Canal> lista = new ArrayList<Canal>();

    public TVHD( ArrayList<Canal> canaisDisponiveis, String modelo, String id ) {
        super(canaisDisponiveis, id);
        this.modelo = modelo;
    }

    @Override
    public void cadastrarCanais() {
        for(int i = 0; i < canaisDisponiveis.size(); i++) {
            if(canaisDisponiveis.get(i).getHd()) {
                canaisCadastrados.add(canaisDisponiveis.get(i));
            }
        }
        setCanalAtual(canaisCadastrados.get(lista.size() - 1));
    }
}