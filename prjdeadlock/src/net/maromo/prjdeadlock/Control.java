package net.maromo.prjdeadlock;

public class Control {
    boolean remoteSisterA;

    synchronized void sisterA(boolean executando)throws InterruptedException{
        if(!executando){
            remoteSisterA = true;
            notify();
            return;
        }
        Thread.sleep(3000);
        System.out.println("Controle Remoto está em posse da Irmã A");

        remoteSisterA = true;
        notify();
        try{
            while(remoteSisterA){
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("Aconteceu o erro: " + e.getMessage());
        }


    }
    synchronized void sisterB(boolean executando)throws InterruptedException{
        if(!executando){
            remoteSisterA = false;
            notify();
            return;
        }
        Thread.sleep(3000);
        System.out.println("Controle Remoto está em posse da Irmã B");

        remoteSisterA = false;
        notify();
        try{
            while(!remoteSisterA){
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("Aconteceu o erro: " + e.getMessage());
        }

    }


}
