package view;

import java.util.concurrent.Semaphore;

import Controller.CalculoFCFS;

public class Main {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int IdThread = 0; IdThread < 20; IdThread ++) {
			Thread IDT = new CalculoFCFS(IdThread, semaforo);
			IDT.start();
		} // fim for
	}
}
