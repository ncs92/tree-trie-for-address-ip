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

    private static final Node raiz = new Node();

    private static Node buscaNoEsquerda(Node raiz, String b) {
        Node no = new Node();

        if (raiz.getEsquerda() == null) {
            no = raiz;
        } else {

            buscaNoEsquerda(raiz.getEsquerda(), b);
        }
        no.setValor(String.valueOf(somaElementosE(raiz))+b);
        return no;
    }

    private static Node buscaNoDireita(Node raiz, String b) {
        Node no = new Node();

        if (raiz.getDireita() == null) {
            no = raiz;
        } else {
            buscaNoDireita(raiz.getDireita(), b);
        }
        no.setValor(String.valueOf(somaElementosD(raiz))+b);
        return no;
    }

    private static String somaElementosD(Node raiz) {
        if (raiz != null) {
            String soma = Arvore.somaElementosD(raiz.getDireita()) + raiz.getValor();
            return soma;
        }
        return null;
    }

    private static String somaElementosE(Node raiz) {
        if (raiz != null) {
            String soma = Arvore.somaElementosE(raiz.getEsquerda()) + raiz.getValor();
            return soma;
        }
        return null;
    }

    public Arvore() {
        if (raiz == null) {
            raiz.setValor("raiz");

        }
    }

    /**
     *
     * @param binario
     */
    public static void insereNo(String binario) {
        for (int i = 0; i < binario.length(); i++) {
            int b = Integer.parseInt(String.valueOf(binario.charAt(i)));

            if (b == 0) {
                if (raiz.getEsquerda() == null) {
                    Node no = new Node();
                    no.setValor(String.valueOf(b));
                    raiz.setEsquerda(no);
                } else {
                    Node no = new Node();
                    no = buscaNoEsquerda(raiz, String.valueOf(b));
                }
            } else {
                if (raiz.getDireita() == null) {
                    Node no = new Node();
                    no.setValor(String.valueOf(b));
                    raiz.setDireita(no);
                } else {
                    Node no = new Node();
                    no = buscaNoDireita(raiz,String.valueOf(b));  
                }
            }

        }
        imprime(raiz);
    }

    public void removeNo() {

    }

    public void buscaNo() {

    }

    public static void imprime(Node raiz) {
        if (raiz == null) {
            return;
        } else {
            System.out.println("\n " + raiz.getValor());
            imprime(raiz.getEsquerda());
            imprime(raiz.getDireita());
        }

    }
}
