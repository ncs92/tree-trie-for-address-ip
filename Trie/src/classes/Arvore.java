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
public class Arvore {

    private static Node raiz;


    public Arvore() {
        if (raiz == null) {
            raiz.setValor("raiz");
           raiz.setPai(null);
        }
    }

    /**
     *
     * @param binario
     */
    public static void insereNo(String binario) {        
        for (int i = 0; i < binario.length(); i++) {
            int b = binario.charAt(i);
            if (b == 0) {
                if(raiz.getEsquerda() == null){
                    raiz.getEsquerda().setValor(String.valueOf(binario));                   
                }else{
                    Node no = new Node();
                    
                }
            } else {
                if(raiz.getDireita() == null){
                    raiz.getDireita().setValor(String.valueOf(binario));                       
                }else{
                    Node no = new Node();
                }
            }

        }

    }

    public void removeNo() {

    }

    public void buscaNo() {

    }
}
