/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import java.awt.image.BufferedImage;

/**
 *
 * @author Rafael
 */
public class Imagem {
    private Segmentacao segmentacao;
    private Anotacao anotacao;
    private BufferedImage imagem;
    
    public Imagem(){
        segmentacao = new Segmentacao();
        anotacao = new Anotacao();
        imagem = null;
    }

    public Segmentacao getSegmentacao() {
        return segmentacao;
    }

    public void setSegmentacao(Segmentacao segmentacao) {
        this.segmentacao = segmentacao;
    }

    public Anotacao getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(Anotacao anotacao) {
        this.anotacao = anotacao;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }
    
}
