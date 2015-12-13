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

    private static Node buscaNoEsquerda(Node raiz) {
         if(raiz.getEsquerda() == null){
             return raiz;
         }else{
             buscaNoEsquerda(raiz.getEsquerda());
         }
        
        return null;
    }
    private static Node buscaNoDireita(Node raiz) {
         if(raiz.getDireita() == null){
             return raiz;
         }else{
             buscaNoDireita(raiz.getDireita());
         }
        
        return null;
    }


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
                    no = buscaNoEsquerda(raiz);
                    String valor = no.getEsquerda().getValor();
                    valor += b;
                    buscaNoEsquerda(raiz).getEsquerda().setValor(valor);
                }
            } else {
                if(raiz.getDireita().getValor().isEmpty()){
                    raiz.getDireita().setValor(String.valueOf(binario));                       
                }else{
                   Node no = new Node();
                    no = buscaNoDireita(raiz);
                    String valor = no.getDireita().getValor();
                    valor += b;
                    buscaNoDireita(raiz).getDireita().setValor(valor);
                }
            }

        }

    }

    public void removeNo() {

    }

    public void buscaNo() {

    }
}
