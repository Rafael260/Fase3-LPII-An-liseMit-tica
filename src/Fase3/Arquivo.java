/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Classe para manipulação de arquivo. Salvar ou ler um arquivo do tipo de projeto do Mitotic Analyses.
 * @author EliseuMedeiros
 */
public class Arquivo {
    /** ---------------------------------------*/
    private String caminhoImagem;
    private double blurLevel, minSize, colorRadius;
    private HashMap<Integer, String> descricaoArquivo;
    /** ---------------------------------------*/
    private BufferedReader lerArq;
    private String linha;
    private final String[] extensoesArquivo = { ".amp"};
    private final String nomeArquivoListaImagens = "imagens_projeto.amp";
    public Arquivo(){
        
    }
    public double getBlurLevel(){
        return blurLevel;
    }
    public double getMinSize(){
        return minSize;
    }
    public double getColorRadius(){
        return colorRadius;
    }
    public String getCaminhoImagem(){
        return caminhoImagem;
    }
    public HashMap<Integer, String> getDesceicaodoArquivo(){
        return descricaoArquivo;
    }
    //Testa se o arquivo escolhido é mesmo uma extensão do projeto
    public boolean ehProjeto(String nomeArquivo){
        for (String extensao : extensoesArquivo) {
            if (nomeArquivo.endsWith(extensao)) {
                return true;
            }
        }
        return false;
    }
    
    public void lerArquivo(String name){
        String[] auxParametros;
        try {
            FileReader arq;
            arq = new FileReader(name);
            lerArq = new BufferedReader(arq);
            descricaoArquivo = new HashMap<>();
 
            //primeira linha contem o caminho da imagem
            caminhoImagem =lerArq.readLine();
            //pegando parâmetros do arquivo (segunda linha) ex. -> 0.5  50  500
            auxParametros = lerArq.readLine().split("\t");
            blurLevel = Double.parseDouble(auxParametros[0].trim());
            colorRadius = Double.parseDouble(auxParametros[1].trim());
            minSize = Double.parseDouble(auxParametros[2].trim());
            linha = lerArq.readLine();
               while ( linha != null) {// lê da primeira linha até a ultima
                   auxParametros = linha.split("\t");
                   //guarda o valor inteiro (da primeira posição da linha do arquivo. E a descrição
                   descricaoArquivo.put(Integer.parseInt(auxParametros[0].trim()), auxParametros[1]);
                   linha = lerArq.readLine();
                }
               arq.close();
            } catch (FileNotFoundException ex) {
                    System.out.println("Arquivo de leitura não encontrado.");
                    Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    /**
     * Salva o caminho da imagem, as configurações de segmentação e as anotações com
     * os respectivos números da região segmentada.
     * @param guardaArq 
     * @param nomeArquivo 
     */
    public void salvarArquivo(ArrayList<String> guardaArq, String nomeArquivo)
    {    
        PrintWriter gravarArq;
        FileWriter arq = null;
        try {
            //certifica-se para que o nome do arquivo a ser salvo termine com  a extensão do projeto (".txt").
            //if(!ehProjeto(CaminhoArq)) 
            //    arq = new FileWriter(CaminhoArq + ".txt");
            //else
            //    arq = new FileWriter(CaminhoArq);
            
            arq = new FileWriter("anotacoes\\" + nomeArquivo + ".amp");
            
        } catch (IOException ex) {
            System.out.println("Problemas ao criar arquivo");
            return;
        }
        gravarArq = new PrintWriter(arq);
       
        for(String linha : guardaArq) {
            gravarArq.println(linha);
        }
        try {
            arq.close();

        } catch (IOException ex) {
            System.out.println("problemas para finalizar o arquivo.");
        }
    }
    
    /**
     * Salva a imagem no diretório padrão do projeto
     * @param segmentacao
     * @throws IOException 
     */
    public void salvarArquivo(Segmentacao segmentacao) throws IOException{
        File outputFile = new File("imagens\\" + segmentacao.getNomeArquivo()+ ".jpg");
        ImageIO.write(segmentacao.getImagemSegmentada(),"jpg",outputFile);
    }
}