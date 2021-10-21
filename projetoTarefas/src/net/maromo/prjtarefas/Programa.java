package net.maromo.prjtarefas;

public class Programa {

    public static void main(String[] args) {
	// write your code here
        try {
            System.out.println("Começar o exemplo de Thread");

            Tarefa t1 = new Tarefa(1);
            Tarefa t2 = new Tarefa(2);
            Tarefa t3 = new Tarefa(3);
            Tarefa t4 = new Tarefa(4);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }catch (Exception e){
            System.out.println("Aconteceu o erro: " + e.getMessage());
        }




    }
}
