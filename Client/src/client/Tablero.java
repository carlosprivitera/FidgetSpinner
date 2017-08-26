package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;

import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {
    private ImageIcon fs01 = new ImageIcon(getClass().getResource("/recursos/fs01.png"));
    private ImageIcon fs02 = new ImageIcon(getClass().getResource("/recursos/fs02.png"));
    private Image fs03 = null;
    private Graphics2D g2d = null;
    private int alto = 0;
    private int ancho = 0;
    private int xCentro = 0;
    private int yCentro = 0;
    private Ciclo ciclo = new Ciclo() {
        @Override
        public void mover() {
            miRepaint();
        }
    };

    public void setAltoAncho(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        this.xCentro = ancho / 2;
        this.yCentro = alto / 2;
    }

    public Tablero() {
        super();
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LanzarJuego(JLabel jl) {
        fs03 = fs02.getImage();
        ciclo.start();
    }

    public void setFS01() {
        fs03 = fs01.getImage();
    }

    public void setFS02() {
        fs03 = fs02.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D)g;
        g2d.translate(xCentro, yCentro);
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.rotate(Globales.giro); //(0 < giro < (2*PI)) * K_incremento
        g2d.drawImage(fs03, -xCentro, -yCentro, ancho, alto, null);
    }

    private void miRepaint() {
        this.repaint();
    }

    public void update(Graphics g) {
        // super.update(g);
        return; //anular el método update(...)
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(400, 400));
    }
}
