package net.maromo.prjcorrida;

public class TesteCorrida {

    public static void main(String[] args) {
	// write your code here
        Piloto um = new Piloto("Hamilton");
        Piloto dois = new Piloto("Verstapen");
        Piloto tres = new Piloto("Kimi");
        um.start();
        dois.start();
        tres.start();
    }
}
