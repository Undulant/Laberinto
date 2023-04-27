import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AdminitradorJuego extends JPanel implements Runnable{
	
	//CONFIGURACIONES DE PANTALLA
		final int escalaOriginal = 16; //16x16 CUADROS
		final int escala = 3;
		
		public final int tamPantalla = escalaOriginal * escala; //48x48 CUADROS
		public final int maxColPantalla = 16;
		public final int maxFilPantalla = 12;
		public final int anchoPantalla = tamPantalla * maxColPantalla; // 768 PIXELES
		public final int alturaPantalla = tamPantalla * maxFilPantalla; // 576 PIXELES
	
	
	int FPS = 60;
	
	Controles teclas = new Controles();
	Thread hiloJuego;
	
	int jugadorX = 10;
	int jugadorY = 350;
	int velocidad = 5;
	
	public AdminitradorJuego() {
		
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(teclas);
		this.setFocusable(true);
		

	}
	
	public void iniciarHiloJuego() {
		
		hiloJuego = new Thread(this);
		hiloJuego.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//CONTROL DE FPSSSSSSSSSSS 1
				double intervaloDibujado = 1000000000/FPS;
				double tiempoDibujado = System.nanoTime() + intervaloDibujado;
				
				while(hiloJuego !=null) {
					
					/*long currentTiempo = System.nanoTime();
					System.out.println("Tiempo: "+currentTiempo);*/
					
					//1 ACTUALIZA: ACTUALIZA LA INFORMACION COMO LA POSICION DEL PERSONAJE
					actualizar();
					
					//2 DRAW: DIBUJA EN PANTALLA LA ACTUALIZACION DE INFORMACION
					repaint();
					
				//CONTROL DE FPSSSSSSSSSS 2
				try {
					double tiempoRestante = tiempoDibujado - System.nanoTime();
					tiempoRestante = tiempoRestante/1000000;
					
					if(tiempoRestante < 0) {
						tiempoRestante = 0;
					}
					
					Thread.sleep((long) tiempoRestante);
					
					tiempoDibujado += intervaloDibujado;
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public void actualizar() {
		
		
		if(teclas.arriba == true) {
			jugadorY -= velocidad;
		}
		else if(teclas.abajo == true) {
			jugadorY += velocidad;
		}
		else if(teclas.izqui == true) {
			jugadorX -= velocidad;
		}
		else if(teclas.dere == true) {
			jugadorX += velocidad;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(jugadorX, jugadorY, tamPantalla, tamPantalla);
		
		g2.dispose();
	}
}
