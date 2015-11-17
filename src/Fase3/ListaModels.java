/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * Classe responsável por inserir os elementos no Jlist da aplicação
 * @author rafael
 */
public class ListaModels {
    
    private DefaultListModel listaModels;
    
    public ListaModels(){
        listaModels = new DefaultListModel();
    }
    
    public DefaultListModel getListaModels() {
        return listaModels;
    }
    
    public void addListaModels(String descricao) {
        listaModels.addElement(descricao); 
    }
    
    public void addListaModels(ArrayList<String> descricoes) {
        for (String desc: descricoes){
            listaModels.addElement(desc); 
        }
    }
    
    public void removeListaModels(String descricao){
        listaModels.removeElement(descricao);
    }
    
    //Esvazia a lista de models - Para adicionar as descrições no Jlist 
    public void clearListaModels(){
        listaModels.clear();
    }
    
    public boolean contains(String descricao){
        return listaModels.contains(descricao);
    }
}
