package net.maromo.prjdeadlock;

public class ThreadControl implements Runnable {
    Control controle;
    Thread threadPosse;

    public ThreadControl(String nomeThread, Control controle){
        this.controle = controle;
        threadPosse = new Thread(this, nomeThread);

        threadPosse.start();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            if(threadPosse.getName().equalsIgnoreCase("SisterA")){
                for (int i = 0; i < 3; i++) {
                    controle.sisterA(true);
                }
                controle.sisterA(false);
            }else{
                for(int i = 0; i<3; i++){
                    controle.sisterB(true);
                }
                controle.sisterB(false);
            }
        }catch(Exception e){
            System.out.println("Aconteceu o erro: " + e.getMessage());
        }
    }
}
