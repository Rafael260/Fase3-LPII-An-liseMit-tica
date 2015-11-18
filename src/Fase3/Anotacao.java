/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Classe responsável por gravar as anotações de regiões de imagens
 * @author EliseuMedeiros;RafaelOliveira
 * @version 13/11/2015 - 11:55
 */
public class Anotacao {
    //Serve para colocar os nomes anotados na lista
    private Map<Integer,String> regioes;
    public Anotacao(){
        regioes = new HashMap<>();
    }
 
    public Map<Integer,String> getHashRegioes(){
        return regioes;
    }
    public void setHashRegioes(Map<Integer,String> newHashRegioes){
        this.regioes = newHashRegioes;
    }
    /**
     * Anota a região selecionada pelo usuário na HashMap
     * @param descricao - Descrição das regiões selecionadas
     * @param regioesSelecionadas - Lista de regiões que foram selecionadas
     */
    public void anotarRegiao(String descricao, ArrayList<Integer> regioesSelecionadas){
        int valorRegiao;
        //Enquanto tiver regiões na lista, adiciona na Hash
        while (!regioesSelecionadas.isEmpty()){
            //Pega uma região clicada
            valorRegiao = regioesSelecionadas.get(0);
            //Remove do arraylist
            regioesSelecionadas.remove(0);
            //E coloca na hash
            regioes.put(valorRegiao,descricao);  
        }      
    }
    
    /**
     * Pesquisa e remove todas os pares chave/valor que o valor seja a descrição
     * @param descricao - Descrição das regiões
     */
    public void removerAnotacaoDaHash(String descricao){
        //Se não existir essa descrição na hash, não há o que fazer
        if (!regioes.containsValue(descricao)){
            return;
        }
        
        Set<Integer> chaves = regioes.keySet();
        Iterator<Integer> it = chaves.iterator();
        Integer key;
        //Percorre a hash removendo os pares onde há valor = descricao
        while (it.hasNext()){
             key = it.next();
             if (regioes.get(key).equals(descricao)){
                 it.remove();
             }
        }
    }
     
    /**
     * Elimina todas as anotações feitas
     */
    public void esvaziarHash(){
        regioes.clear();
    }
    
    /**
     * Função que devolve um arraylist com todas as regiões anotadas no HashMap
     * @return 
     */
    public ArrayList<Integer> getRegioesAnotadas(){
        ArrayList<Integer> regioesAnotadas = new ArrayList<>();
        Set<Integer> chaves = regioes.keySet();
        regioesAnotadas.addAll(chaves);
        /*for (Integer chave : chaves){
            regioesAnotadas.add(chave);
        }*/
        return regioesAnotadas;
    }
    
    /**
     * Retorna a imagem mostrando apenas as regiões anotadas
     * @param segmentacao
     * @return 
     */
    public BufferedImage getImagemComRegioesAnotadas(Segmentacao segmentacao){
        ArrayList<Integer> regioesAnotadas = this.getRegioesAnotadas();
        BufferedImage novaImagem = this.getMapaImagemNovoBrilho(segmentacao, regioesAnotadas, true);
        return novaImagem;
    }
    
    /**
     * Retorna a imagem com o novo brilho
     * @param image é a imagem segmentada
     * @return a imagem com o brilho atualizado
     */
    public BufferedImage getMapaImagemNovoBrilho(Segmentacao image, ArrayList<Integer> regioesSelecionadas, boolean gerarNovaImagem){ //Método de teste
        BufferedImage novaImagem = image.getImagemSegmentada();
        Color corAtual;
        int red, green, blue;
        int [] mapaDeRegioes = image.getMapaDeRegioes();
              //laços para aplicar a escala de cinza na criação do mapa de rótulos
              
        Color branco = new Color(255, 255, 255);
        for(int i = 0, cont = 0; i < novaImagem.getHeight(); i++){
            for(int j = 0; j < novaImagem.getWidth(); j++, cont++){
                //pegando cor do pixel atual
                corAtual = new Color(novaImagem.getRGB(j, i));
                red = corAtual.getRed();
                green = corAtual.getGreen();
                blue = corAtual.getBlue();
                //Os traços de segmentação continuam com a cor original
                if (red == 255 && blue == 0 && green == 0 && !gerarNovaImagem){
                    continue;
                }
                
                //Se tiver tratando de uma região que não foi clicada, deve escurecê-la
                if(!regioesSelecionadas.contains(mapaDeRegioes[cont])){
                    if (gerarNovaImagem)
                        novaImagem.setRGB(j,i, branco.getRGB());
                    else
                        novaImagem.setRGB(j,i, new Color(red/2, green/2, blue/2).getRGB());
                }
                
            }
        }
        
        return novaImagem;
    }
}
