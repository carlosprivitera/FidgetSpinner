package client;

public abstract class Reloj extends Thread {

    public Reloj() {
        super();
    }

    public void run() {
        super.run();
        do {
            try {
                this.sleep(500);
                notificarVista();
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public abstract void notificarVista();
}
