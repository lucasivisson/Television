package main;

import java.util.*;

public class SmartTV extends Televisao {
    private Double quantidadeDePolegadas;

    public SmartTV ( ArrayList<Canal> canaisDisponiveis, Double quantidadeDePolegadas, String id ) {
        super(canaisDisponiveis, id);
        this.quantidadeDePolegadas = quantidadeDePolegadas;
    }
    
    public Double getQuantidadeDePolegadas() {
        return this.quantidadeDePolegadas;
    }
    public void setQuantidadeDePolegadas(Double quantidadeDePolegadas) {
        this.quantidadeDePolegadas = quantidadeDePolegadas;
    }

    @Override
    public void cadastrarCanais() {
        canaisDisponiveis.addAll(canaisCadastrados);
        setCanalAtual(canaisCadastrados.get(0));
    }
}
