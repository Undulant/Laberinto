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

	public Ventana() {
		
	this.setSize(594,591);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Laberinto");
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
	JPanel fondo = new JPanel();
	fondo.setBackground(new Color(35,45,70));
    fondo.setLayout(new BorderLayout());
	this.add(fondo);
	
	JPanel abajo = new JPanel();
	abajo.setBackground(new Color(35,95,70));
	abajo.setLayout(new GridLayout(1,3));
	fondo.add(abajo, BorderLayout.SOUTH);
	JLabel espacioPO = new JLabel("X:    666", JLabel.LEFT);
	espacioPO.setFont(new Font("Arial",Font.BOLD,30));
	espacioPO.setOpaque(false);
	espacioPO.setForeground(new Color(35,95,70));
	abajo.add(espacioPO);
	JButton reinicio = new JButton("REINICIO");
	reinicio.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.print("Se");
		}
		
	});
	abajo.add(reinicio);
	JLabel espacioPO2 = new JLabel("X: ", JLabel.LEFT);
	espacioPO2.setFont(new Font("Arial",Font.BOLD,30));
	espacioPO2.setOpaque(false);
	espacioPO2.setForeground(new Color(35,95,70));
	abajo.add(espacioPO2);
	
	JLabel marco1 = new JLabel("pofads");
	marco1.setBackground(new Color(85,45,70));
	fondo.add(marco1, BorderLayout.WEST);
	JLabel marco2 = new JLabel("pofads");
	marco2.setBackground(new Color(85,45,70));
	fondo.add(marco2, BorderLayout.NORTH);
	JLabel marco3 = new JLabel("pofads");
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

