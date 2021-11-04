package net.maromo.prjcontroladoredicao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiltroVogais extends Thread {
    Reader reader;
    Writer writer;
    int tamanho;
    char[] buffer;

    public FiltroVogais(PipedReader reader, PipedWriter writer, int tamanho) {
        this.reader = reader;
        this.writer = writer;
        this.tamanho = tamanho;
        buffer = new char[tamanho];
    }



    @Override
    public void run() {
        // Ler dados de entrada
        try {
            reader.read(buffer, 0, tamanho);
        } catch (IOException e) {
            System.out.println("Erro de Leitura, desci��o: " + e.getMessage());
            return;
        }

        //Retirar as vogais
        List<String> semVogais = new ArrayList<>();
        for (char c : buffer) {
            if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u') {
                semVogais.add(String.valueOf(c));
            }
        }
        for (int i= 0; i < buffer.length; i++) {
            buffer[i] = ' ';
        }
        for(int i = 0; i<semVogais.size(); i++) {
            buffer[i] = semVogais.get(i).charAt(0);
        }
        try {
            writer.write(buffer, 0, tamanho);
        } catch (Exception e) {
            System.out.println("Erro de escrita, descrição: " + e.getMessage());
        }
    }
}
