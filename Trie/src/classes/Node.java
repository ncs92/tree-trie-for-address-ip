/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author nani
 */
public class Node {
    private String valor;
    private Node esquerda;
    private Node direita;
 

    public Node() {
     //   this.esquerda = new Node();
     //   this.direita = new Node();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.esquerda, other.esquerda)) {
            return false;
        }
        if (!Objects.equals(this.direita, other.direita)) {
            return false;
        }
        return true;
    }

  

    @Override
    public String toString() {
        return "Node{" + "valor=" + valor + ", esquerda=" + esquerda + ", direita=" + direita + '}';
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    
    
    
    
}
