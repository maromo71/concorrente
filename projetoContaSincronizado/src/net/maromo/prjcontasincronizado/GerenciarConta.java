package net.maromo.prjcontasincronizado;

public class GerenciarConta {

    public static void main(String[] args) {
	    //Instaciar uma conta do Eliezer
        Conta conta = new Conta(1, "Eliezer");
        try{
            Transacao t1 = new Transacao(conta, 300, TipoTransacao.Depositar);
            Transacao t2 = new Transacao(conta, 200, TipoTransacao.Depositar);
            Transacao t3 = new Transacao(conta, 200, TipoTransacao.Depositar);
            Transacao t4 = new Transacao(conta, 500, TipoTransacao.Depositar);
            Transacao t5 = new Transacao(conta, 300, TipoTransacao.Depositar);
            Transacao t6 = new Transacao(conta, 0, TipoTransacao.ExibirSaldo);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t5.join();
            t6.start();

        }catch(Exception ex){
            System.out.println("Aconteceu o erro: " + ex.getMessage());
        }
    }
}
