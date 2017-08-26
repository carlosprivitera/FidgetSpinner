package client;

public abstract class Ciclo extends Thread  {
    public Ciclo() {
        super();
    }
    private final int fps = 1000/50; //20 cuadros por segundos
    private final float arco = (float)((Math.PI*(double)2) / (double)50.0); //pizza de 50 porciones
    private final float frenado = (float)0.001;
    public void run() {
        super.run();
        while (true) {
            mover();
            Globales.giro = Globales.giro + (arco * Globales.incremento); 
            if(Globales.incremento > 0.0) {
              Globales.incremento = Globales.incremento - frenado;
            }else{
              Globales.incremento = (float)0.1;  
            }
            if(Globales.giro > 9999999) Globales.giro = (float)0.0;
            try {
                if(Globales.Minimizado==false) {
                    this.sleep(fps); 
                }else{
                    this.sleep(1000); 
                }
                
            } catch (InterruptedException e) {
            }
        }
    }

    public abstract void mover();
}
