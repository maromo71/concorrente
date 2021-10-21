package net.maromo.prjcontasincronizado;

public class Conta {
    private int idConta;
    private String nome;
    private double saldo;



    public Conta(int idConta, String nome){
        this.idConta = idConta;
        this.nome = nome;
    }

    public boolean depositar(double valor){
            synchronized (this) {
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valor do depósito deve ser positivo");
                }
                saldo += valor;
                return true;
            }
    }

    public boolean sacar(double valor){
        synchronized (this){
            if(valor>saldo){
                throw new IllegalArgumentException("Saldo insuficiente para saque");
            }
            saldo -= valor;
            return true;
        }

    }

    public double getSaldo() {
            synchronized (this){
                return saldo;
            }



    }
}
