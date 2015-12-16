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

/**
 *
 * @author nani
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    private static No node = null;
    private static Arvorebb arvore = new Arvorebb();

    public static void main(String[] args) throws IOException {
        ler();
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
            if (cont == 1) {
                System.out.println("\n" + line);
                transformaBinario(line);
                break;
            }

        }

        in.close();
    }
    
    private static String completaBit(int valor){
         String bin = Integer.toBinaryString(valor);
         int falta = 8 - bin.length();
         String zero = "";
         for(int i = 0; i < falta; i++){
             zero += "0";
         }
         bin = zero + bin;
         return bin;
    }

    private static void transformaBinario(String line) {

        String ip = line.split("\\|")[0];
        String porta = line.split("\\|")[2];
        System.out.println("\n ip : " + ip);
        String binario = "";
        for (int i = 0; i < ip.split("\\.").length; i++) {
            int valor = Integer.parseInt(ip.split("\\.")[i]);
             binario += completaBit(valor);           
        }
        System.out.println("\n binario : " + binario);
        
        if (arvore.getRaiz() == null) {
            arvore.setRaiz(new No());
            arvore.getRaiz().setValor(Integer.parseInt(String.valueOf(binario.charAt(0)))); //adiciona
            node = arvore.getRaiz();
        }

        for (int i = 1; i < binario.length(); i++) {            
            if(i == binario.length()-1){
               arvore.inserirPorta(node, Integer.parseInt(String.valueOf(binario.split("")[i])),porta); 
            }else{
               arvore.inserir(node, Integer.parseInt(String.valueOf(binario.split("")[i])));
            }
          //  System.out.println("valor " + String.valueOf(binario.split("")[i]) + "\n");
        }

        arvore.imprime(arvore.getRaiz());
        
    }
}
