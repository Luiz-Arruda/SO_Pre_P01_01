package Controller;

import java.util.concurrent.Semaphore;

public class CalculoFCFS extends Thread {
	
	private int IdThread;
	private Semaphore semaforo;
	
	public CalculoFCFS(int IdThread, Semaphore semaforo) {
		this.IdThread = IdThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			CalculoProcesso(IdThread);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaforo.release();
	}
	
	public void CalculoProcesso(int IdThread) {
		int tempo;
		tempo = (int)(Math.random() * 116 + 4);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Processo: " + IdThread + "tempo: " +tempo);
	} // fim calculo procesos
}
