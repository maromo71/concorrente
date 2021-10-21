package net.maromo.prjcorrida;

public class Piloto extends Thread {
    private String nome;

    public Piloto(String nomePiloto){
        this.nome = nomePiloto;
    }

    @Override
    public void run() {
        System.out.println("*****LARGADA****** ->" + nome);
        System.out.println("Primeira Volta: " + nome);
        for (int i = 0; i < 100000 ; i++) {}
        System.out.println(nome + " finalizou a corrida");

    }
}
