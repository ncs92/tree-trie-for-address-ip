/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import classes.Arvorebb;
import classes.No;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JOptionPane;

/**
 *
 * @author nani
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    private static Arvorebb arvore = new Arvorebb();

    public static void main(String[] args) throws IOException {
        String destino = null;
        ler();
//        arvore.imprime(arvore.getRaiz());
        do {
            destino = JOptionPane.showInputDialog("Digite um IP | Mácara");
            procuraDestino(destino);

        } while (!destino.equals("x"));

    }

    private static void ler() throws IOException {

        File f = new File("tabelas_de_rotas.txt");
        FileInputStream fis = new FileInputStream(f);
        FileChannel fc = fis.getChannel();

        MappedByteBuffer mmb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        byte[] buffer = new byte[(int) fc.size()];
        mmb.get(buffer);

        fis.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)));
        int cont = 0;
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            cont++;
//            if (cont == 1) {
            System.out.println("\n" + line);
            insereNaArvore(line);
//                break;
//            }

        }

        in.close();
    }

    private static String completaBit(int valor) {
        String bin = Integer.toBinaryString(valor);
        int falta = 8 - bin.length();
        String zero = "";
        for (int i = 0; i < falta; i++) {
            zero += "0";
        }
        bin = zero + bin;
        return bin;
    }

    private static void insereNaArvore(String line) {

        String ip = line.split("\\|")[0];
        int mascara = Integer.parseInt(String.valueOf(line.split("\\|")[1]));
        String porta = line.split("\\|")[2];
        System.out.println("\n ip : " + ip);
        String binario = "";
        No noAtual = null;

        for (int i = 0; i < ip.split("\\.").length; i++) {
            int valor = Integer.parseInt(ip.split("\\.")[i]);
            binario += completaBit(valor);
        }
        System.out.println("\n binario : " + binario);

        noAtual = arvore.getRaiz();

        for (int i = 0; i < mascara; i++) {
            if (arvore.getRaiz() == null) { //inicializa a raiz
                arvore.setRaiz(new No());
                arvore.getRaiz().setValor(Integer.parseInt(String.valueOf(binario.charAt(i)))); //adiciona
                noAtual = arvore.getRaiz();

            } else if (i == mascara - 1) {   // insere o destino na ultima posição do endereço
                arvore.inserirPorta(noAtual, Integer.parseInt(String.valueOf(binario.split("")[i])), porta);
            } else {
                noAtual = arvore.inserir(noAtual, Integer.parseInt(String.valueOf(binario.split("")[i])));
            }
        }
    }

    private static void procuraDestino(String destino) {
        String[] aux = destino.split("\\|");
        String ip = aux[0];
        int mascara = Integer.parseInt(String.valueOf(aux[1]));
        String binario = "";
        No noAtual = arvore.getRaiz();

        for (int i = 0; i < ip.split("\\.").length; i++) {
            int valor = Integer.parseInt(ip.split("\\.")[i]);
            binario += completaBit(valor);
        }

        System.out.println("Binario destino : " + binario);
        for (int i = 0; i < mascara; i++) {
            noAtual = arvore.inserir(noAtual,Integer.parseInt(String.valueOf(binario.split("")[i])));
        }

        if(noAtual == null){
            System.out.println("404");
        } else {
            System.out.println("Destino : " + noAtual.getPorta());
        }
    }

}
