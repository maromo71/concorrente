package net.maromo.prjcontroladoredicao;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;

public class ContadorVogais extends Thread {
    Reader reader;
    Writer writer;
    int tamanho;
    char[] buffer;

    public ContadorVogais(PipedReader reader, PipedWriter writer, int tamanho) {
        this.reader = reader;
        this.writer = writer;
        this.tamanho = tamanho;
        buffer = new char[tamanho];
    }
    @Override
    public void run() {
        int numeroVogais = 0;
        //Ler dados de entrada
        try {
            reader.read(buffer, 0, tamanho);
        } catch (Exception e) {
            System.out.println("Erro de Leitura, descrição: " + e.getMessage());
            return;
        }

        //Contar as vogais
        for (int i = 0; i < tamanho; i++) {
            if(buffer[i]=='a' || buffer[i]=='e' ||
                    buffer[i]=='i' || buffer[i]=='o' || buffer[i] =='u') {
                numeroVogais++;
            }
        }
        //Informar o número de vogais
        System.out.println("Quantidade de vogais = " + numeroVogais);

        //Escrever dados na saída
        try {
            writer.write(buffer, 0, tamanho);
        } catch (Exception e) {
            System.out.println("Erro de escrita, descrição: " + e.getMessage());
            return;
        }
    }
}
