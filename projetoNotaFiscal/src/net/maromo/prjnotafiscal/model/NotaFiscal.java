package net.maromo.prjnotafiscal.model;

public class NotaFiscal implements Runnable {
    private int idNota;

    public int getIdNota() {
        return idNota;
    }
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    //construtor
    public NotaFiscal(int id) {
        this.idNota = id;
    }
    @Override
    public void run() {
        //Logica para gerar o pdf  (simulado)
        System.out.println("Gerando PDF Nota n. " + idNota);

    }
}
