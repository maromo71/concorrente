package net.maromo.prjcontasincronizado;

public class Transacao extends Thread{
    private Conta conta;
    private double valor;
    private TipoTransacao tipo;

    public Transacao(Conta conta, double valor, TipoTransacao tipo){
        this.conta = conta;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try{
            if(tipo == TipoTransacao.Depositar){
                boolean ok = conta.depositar(valor);
                if(ok){
                    System.out.println("Depósito efetuado com sucesso: ");
                }

            }
            if(tipo== TipoTransacao.Sacar){
                boolean ok = conta.sacar(valor);
                if(ok){
                    System.out.println("Saque efetuado com sucesso");
                }
            }

            if(tipo == TipoTransacao.ExibirSaldo){
                System.out.println("Saldo do correntista é: " + conta.getSaldo());
            }
        }catch (Exception ex){
            System.out.println("Aconteceu o erro seguinte: " + ex.getMessage());
        }
    }
}
