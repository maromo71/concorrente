package net.maromo.prjdeadlock;

public class ControlManagement {

    public static void main(String[] args) {
	    Control controle = new Control();
        ThreadControl sisterA = new ThreadControl("SisterA", controle);
        ThreadControl sisterB = new ThreadControl("SisterB", controle);
        try{
            sisterA.threadPosse.join();
            sisterB.threadPosse.join();
        }catch(InterruptedException ex){
            System.out.println("Aconteceu o erro: " + ex.getMessage());
        }
    }
}
