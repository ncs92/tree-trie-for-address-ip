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
    private ArrayList<Node> proximo;

    public Node() {
    }

    
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Node> getProximo() {
        return proximo;
    }

    public void setProximo(ArrayList<Node> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Node{" + "valor=" + valor + ", proximo=" + proximo + '}';
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
        if (!Objects.equals(this.proximo, other.proximo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
