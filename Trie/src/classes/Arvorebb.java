/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author maa
 */
public class Arvorebb {

    private No raiz;

    public Arvorebb() {
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void insereRaiz(int valor) {
        raiz = new No();
        raiz.setValor(valor);
    }

    public No inserir(No node, int valor) {
        if (valor == 0) {
            if (node.getEsquerda() != null) {
//                System.out.println("ENCONTROU NÓ ESQUERDA");
                return node.getEsquerda();

            } else {
//                System.out.println("NOVO NO ESQUERDA");
                node.setEsquerda(new No());
                node.getEsquerda().setValor(valor);
                node.getEsquerda().setPai(node);
                return node.getEsquerda();
            }

        } else if (valor == 1) {
            if (node.getDireita() != null) {
//                System.out.println("ENCONTROU NÓ DIREITA");
                return node.getDireita();

            } else {
//                System.out.println("NOVO NÓ DIREITA");
                node.setDireita(new No());
                node.getDireita().setValor(valor);
                node.getDireita().setPai(node);
                return node.getDireita();
            }
        }
        return null;

    }

    public void inserirPorta(No node, int valor, String porta) {

        if (node.getValor() > valor) { //esquerda
            if (node.getEsquerda() != null) {
                inserir(node.getEsquerda(), valor);

            } else {
                node.setEsquerda(new No());
                node.getEsquerda().setValor(valor);
                node.getEsquerda().setPorta(porta);
                node.getEsquerda().setPai(node);
            }
//            System.out.println("inseriou esquerda");

        } else { //direita

            if (node.getDireita() != null) {
                inserir(node.getDireita(), valor);

            } else {
                node.setDireita(new No());
                node.getDireita().setValor(valor);
                node.getDireita().setPorta(porta);
                node.getDireita().setPai(node);
            }
//            System.out.println("inseriou direita");
        }

    }

    public void imprime(No raiz) {
        if (raiz == null) {
            return;

        } else {
            if (raiz.getPai() != null && raiz.getPorta() != null) {
                System.out.println("\n " + raiz.getValor() + " pai " + raiz.getPai().getValor() + " endereco " + raiz.getPorta());

            } else if (raiz.getPai() != null) {
                System.out.println("\n " + raiz.getValor() + " pai " + raiz.getPai().getValor());
            } else {
                System.out.println("\n " + raiz.getValor());
            }
            imprime(raiz.getEsquerda());

            imprime(raiz.getDireita());
        }

    }

    public No busca(No node) {
        if (node.getValor() == 0) {
            System.out.println("ENCONTROU NÓ ESQUERDA");
            System.out.println("No " + node.getValor());
            return node.getEsquerda();
            
        } else if (node.getValor() == 1) {
            
            System.out.println("ENCONTROU NÓ DIREITA");
            System.out.println("No " + node.getValor());
            return node.getDireita();
            
        }
            return null;
        
    }
}
