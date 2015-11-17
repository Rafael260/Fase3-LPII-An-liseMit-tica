/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

/** Classe responsável em pegar strings que possam ser convertidas para números
 * @author EliseuMedeiros;RafaelOliveira
 * @version 13/11/2015 - 11:55
 */
public class StringNumeral{
    private String string;
    
    public StringNumeral(String str){
        string = str;
    }
    
    public boolean isEmpty(){
        return string.isEmpty();
    }
    
    /**
     * Testa se o texto contém caracteres que impede a conversão para número
     * @return true se contém, falso caso contrário
     */
    public boolean temCaracter(){
        char[] text = string.toCharArray();
        for (int i = 0; i < text.length; i++){
            if ((text[i] < '0' || text[i] > '9') && text[i] != '.')
                return true;
        }
        return false;
    }
}
