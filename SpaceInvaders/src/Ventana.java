import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	Jugador jugador;
	
	public Ventana() {
		
	this.setSize(1094,591);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Laberinto");
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
	JPanel fondo = new JPanel();
	fondo.setBackground(new Color(66,150,54));
    fondo.setLayout(new BorderLayout());
	this.add(fondo);
	
	JPanel abajo = new JPanel();
	abajo.setBackground(new Color(48,48,48));
	abajo.setLayout(new GridLayout(1,3));
	fondo.add(abajo, BorderLayout.SOUTH);
	JLabel espacioPO = new JLabel("X:    666", JLabel.LEFT);
	espacioPO.setFont(new Font("Arial",Font.BOLD,30));
	espacioPO.setOpaque(false);
	espacioPO.setForeground(new Color(48,48,48));
	abajo.add(espacioPO);
	JButton reinicio = new JButton("REINICIO");
	reinicio.setForeground(new Color(66,150,54));
	reinicio.setBackground(new Color(48,48,48));
	reinicio.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jugador.x = 27;
			jugador.y = 27;

		}
		
	});
	abajo.add(reinicio);
	JLabel espacioPO2 = new JLabel("X: ", JLabel.LEFT);
	espacioPO2.setFont(new Font("Arial",Font.BOLD,30));
	espacioPO2.setOpaque(false);
	espacioPO2.setForeground(new Color(48,48,48));
	abajo.add(espacioPO2);
	
	JLabel marco1 = new JLabel("pofads");
	marco1.setBackground(new Color(66,150,54));
	marco1.setForeground(new Color(66,150,54));
	fondo.add(marco1, BorderLayout.WEST);
	JLabel marco2 = new JLabel("pofads");
	marco2.setBackground(new Color(85,45,70));
	marco2.setForeground(new Color(66,150,54));
	fondo.add(marco2, BorderLayout.NORTH);
	JLabel marco3 = new JLabel("pofads");
	marco3.setForeground(new Color(66,150,54));
	marco3.setBackground(new Color(85,45,70));
	fondo.add(marco3, BorderLayout.EAST);
	
	AdminitradorJuego juego = new AdminitradorJuego();
	fondo.add(juego, BorderLayout.CENTER);
	
	reinicio.setFocusable(false);
	juego.setFocusable(true);
	juego.requestFocus();
	
	juego.iniciarHiloJuego();
	this.revalidate();	
	}
}

