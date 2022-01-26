package client;

//import com.sun.awt.AWTUtilities;

import com.sun.awt.AWTUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {
    private Reloj reloj = new Reloj(){
        @Override
        public void notificarVista() {
            miNotificarVista();
        }
    };
    private Tablero tablero = new Tablero();
    private JToolBar jToolBar1 = new JToolBar();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton jButton4 = new JButton();
    private JButton jButton5 = new JButton();
    private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private boolean flotar =  true;
    private JPanel jPanel1 = new JPanel();
    private JButton jButton8 = new JButton();

    public VentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(486, 528));
        this.setTitle("Fidget Spinner - Juguete antiestr�s");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
                public void windowIconified(WindowEvent e) {
                    this_windowIconified(e);
                }

                public void windowDeiconified(WindowEvent e) {
                    this_windowDeiconified(e);
                }
            });
        //jToolBar1.setSize(new Dimension(400, 437));
        tablero.setOpaque(true);
        jToolBar1.setSize(new Dimension(467, 209));
        //jToolBar1.setLayout(null);
       // jToolBar1.setSize(new Dimension(400, 293));
        tablero.setBounds(new Rectangle(5, 45, 400, 410));
        tablero.setSize(new Dimension(400, 400));
        tablero.setLayout(null);
        //tablero.setOpaque(false);
        jToolBar1.setBounds(new Rectangle(0, 0, 420, 40));
       // jToolBar1.setRollover(true);
        //jToolBar1.setFloatable(false);
        jButton1.setText("Parar");
        jButton1.setToolTipText("Detener giro");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("+");
        jButton2.setToolTipText("Aumenta la velocidad");
        jButton2.setPreferredSize(new Dimension(20, 20));
        jButton2.setMinimumSize(new Dimension(20, 20));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jButton3.setText("-");
        jButton3.setToolTipText("Disminuye la velocidad");
        jButton3.setMinimumSize(new Dimension(20, 20));
        jButton3.setPreferredSize(new Dimension(20, 20));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3_actionPerformed(e);
                }
            });
        jLabel1.setText("RPM=");
        jLabel1.setToolTipText("Revoluciones por minuto");
        jLabel2.setText("6.0");
        jButton4.setText("FS 1");
        jButton4.setToolTipText("Fidget Spinner 1");
        jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4_actionPerformed(e);
                }
            });
        jButton5.setText("FS 2");
        jButton5.setToolTipText("Fidget Spinner 2");
        jButton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton5_actionPerformed(e);
                }
            });
        jButton6.setText("X");
        jButton6.setToolTipText("Cerrar");
        jButton6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton6_actionPerformed(e);
                }
            });
        jButton7.setText("=");
        jButton7.setToolTipText("Encima de las ventanas");
        jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton7_actionPerformed(e);
                }
            });
        jButton8.setText("_");
        jButton8.setToolTipText("Minimiza la ventana");
        jButton8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton8_actionPerformed(e);
                }
            });
        jToolBar1.add(jButton1, null);
        jToolBar1.add(jButton2, null);
        jToolBar1.add(jButton3, null);
        jToolBar1.add(jLabel1, null);
        jToolBar1.add(jLabel2, null);
        jToolBar1.add(jButton4, null);
        jToolBar1.add(jButton5, null);
        jPanel1.add(jButton8, null);
        jPanel1.add(jButton7, null);
        jPanel1.add(jButton6, null);
        jToolBar1.add(jPanel1, null);
        this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
        this.getContentPane().add(tablero, BorderLayout.CENTER);
        this.setAlwaysOnTop(flotar);
        tablero.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jPanel1_mouseClicked(e);
                }
            });
        tablero.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    tablero_mouseDragged(e);
                }
            });
        tablero.setAltoAncho(400, 400);
       // this.setUndecorated(true);
     //   AWTUtilities.setWindowOpaque(this, false); //setWindowOpacity (this,0.5f); 
    
        reloj.start();
        tablero.LanzarJuego(jLabel2);
        tablero.repaint();
        
    }
    public static void main(String[] args) {
      VentanaPrincipal vp = new VentanaPrincipal();
      vp.setDefaultCloseOperation(vp.EXIT_ON_CLOSE);
      vp.setLocationRelativeTo(null);
      vp.setVisible(true);
    }
    private void miNotificarVista(){
        jLabel2.setText(""+(int)Math.floor(Globales.incremento*50));
        //if(!(this.getState()==this.NORMAL)) {
        //    Globales.Minimizado=true;
        //}else{
        //    Globales.Minimizado=false;
        //}
    }
    private void jButton1_actionPerformed(ActionEvent e) {
        Globales.incremento=(float)0.1;
        Globales.giro=(float)0.0;
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        float incrementar = (float)(Math.random() * (double)1.0);
        Globales.incremento=Globales.incremento + incrementar;
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        float incrementar = (float)(Math.random() * (double)1.0);
        float velocidad = Globales.incremento - incrementar;
        if(velocidad > (float)0.1) {      
          Globales.incremento = velocidad;
        }else{
          Globales.incremento = (float)0.1;
        }
    }

    private void jPanel1_mouseClicked(MouseEvent e) {
        int nClick = e.getClickCount();
        if(nClick==1){
            float incrementar = (float)(Math.random() * (double)1.5);
            float velocidad = Globales.incremento + incrementar;
            Globales.incremento=velocidad;
        }else{
            float incrementar = (float)(Math.random() * (double)1.0);
            float velocidad = Globales.incremento - incrementar;
            if(velocidad > (float)0.1) {
              Globales.incremento=velocidad;        
            }else{
              Globales.incremento=(float)0.1;
            }
        }
    }

    private void jButton4_actionPerformed(ActionEvent e) {
        tablero.setFS01();
    }

    private void jButton5_actionPerformed(ActionEvent e) {
        tablero.setFS02();
    }

    private void jButton6_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    private void jButton7_actionPerformed(ActionEvent e) {
        if(flotar==true){
            this.setAlwaysOnTop(false);
            flotar=false;
            jButton7.setText("--");
        }else{
            this.setAlwaysOnTop(true);
            flotar=true;            
            jButton7.setText("=");
        }
    }

    private void jButton8_actionPerformed(ActionEvent e) {
        this.setState(this.ICONIFIED);
    }
    Point point = null;
    private void tablero_mouseDragged(MouseEvent e) {      
        point = e.getLocationOnScreen();
        this.setLocation(point.x-(400/2), point.y-(400/2));
    }

    private void this_windowIconified(WindowEvent e) {
        Globales.Minimizado=true;   
    }

    private void this_windowDeiconified(WindowEvent e) {
        Globales.Minimizado=false;
    }
}


