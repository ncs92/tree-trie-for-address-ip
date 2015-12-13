/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author nani
 */
public class Trie {
    private Node raiz;   
    
       
    public void inseriNó(Node no, int binario){
        if(raiz == null){
            raiz.setValor("raiz");
            if(binario == 0){
                raiz.getEsquerda().setValor(String.valueOf(binario));
            }else{
                raiz.getDireita().setValor(String.valueOf(binario));
            }
        }else{
        }
    }
   
    public void removeNó(){
        
    }

    
    public void buscaNó(){
        
    }
}
