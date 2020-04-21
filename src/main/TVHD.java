package main;

import java.util.*;

public class TVHD extends Televisao {
    private String modelo;

    public TVHD( ArrayList<Canal> canaisDisponiveis, String modelo, String id ) {
        super(canaisDisponiveis, id);
        this.modelo = modelo;
    }

    @Override
    public void cadastrarCanais() {
        for(int i = 0; i < canaisCadastrados.size(); i++) {
            if(canaisCadastrados.get(i).getHd()) {
                canaisDisponiveis.add(canaisCadastrados.get(i));
            }
        }
        setCanalAtual(canaisDisponiveis.get(canaisDisponiveis.size() - 1));
    }
}