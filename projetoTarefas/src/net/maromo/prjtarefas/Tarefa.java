package net.maromo.prjtarefas;

public class Tarefa extends Thread {
    //Atributos id
    private int id;

    public Tarefa(int id){
        this.id = id;
    }

    @Override
    public void run() {
        executeTarefa();

    }

    private void executeTarefa() {
        String flag;
        if(this.id % 2 ==0){
            flag = "P";
        }else{
            flag = "I";
        }
        for (int i = 1; i <= 2000 ; i++) {
            if(i % 80 == 0) System.out.println();
            System.out.print(flag);
        }
    }
}
