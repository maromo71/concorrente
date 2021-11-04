package net.maromo.prjcontroladoredicao;

import javax.swing.*;
import java.io.PipedReader;
import java.io.PipedWriter;

public class ControladorEdicao {

    public static void main(String[] args) {
            // Criar a mensagem a ser enviada
            String msg = JOptionPane.showInputDialog("Digite seu texto");
            char[] mensagem = msg.toLowerCase().toCharArray();

            //Criar pipes para a comunicão
            PipedWriter writerA = new PipedWriter();
            PipedWriter writerB = new PipedWriter();
            PipedWriter writerC = new PipedWriter();
            PipedReader readerA = new PipedReader();
            PipedReader readerB = new PipedReader();
            PipedReader readerC = new PipedReader();

            //Conectar pipes
            try {
                readerB.connect(writerA);
                readerC.connect(writerB);
                readerA.connect(writerC);
            } catch (Exception e) {
                System.out.println("Erro no uso de Pipes");
            }

            //Criar os threads e interligar via pipes
            ContadorVogais threadA = new ContadorVogais(readerB, writerB, mensagem.length);
            FiltroVogais threadB =new FiltroVogais(readerC, writerC, mensagem.length);

            //Ativar os threads
            threadA.start();
            threadB.start();

            //Escrever os dados atraves da pipe A:
            try {
                writerA.write(mensagem, 0, mensagem.length);
                readerA.read(mensagem, 0, mensagem.length);
            } catch (Exception e) {
                System.out.println("Erro no uso de pipes");
                return;
            }
            for (int i = 0; i < mensagem.length; i++) {
                if(mensagem[i]!=' ') System.out.println(mensagem[i]);
            }

        }
}
