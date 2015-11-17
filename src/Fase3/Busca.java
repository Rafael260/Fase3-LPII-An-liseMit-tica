/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author EliseuMedeiros;RafaelOliveira
 * @version 13/11/2015 - 11:55
 */
public class Busca {
    
    
    public Busca(){
        
    }
    
    //Retornar um arraylist de regioes que tenha a descrição especificada
    public ArrayList<Integer> getRegioesComDescricao(String descricao,Map<Integer,String> regioes){
        ArrayList<Integer> regioesComDescricao = new ArrayList<>();
        Set<Integer> chaves = regioes.keySet();
        
        for(Integer regiao: chaves){
            if (regioes.get(regiao).equals(descricao)){
                regioesComDescricao.add(regiao);
            }
        }
        return regioesComDescricao;
    }
    
    public ArrayList<String> getDescricoesComInicio(String prefixo, Map<Integer,String> regioes){
        ArrayList<String> descricoes = new ArrayList<>();
        Set<Integer> chaves = regioes.keySet();
        if (!prefixo.isEmpty()){
            for(Integer regiao: chaves){
                if (regioes.get(regiao).startsWith(prefixo) && !descricoes.contains(regioes.get(regiao))){
                    descricoes.add(regioes.get(regiao));
                }
            }
        }
        
        return descricoes;
    }
}
