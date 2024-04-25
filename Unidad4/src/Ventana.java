import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana() {
		this.setVisible(true);
		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
	}

	private void iniciar() {

		JButton boton = new JButton("Pushame");
		boton.setBounds(140, 200, 200, 50);
		boton.setFont(new Font("", Font.BOLD, 20));
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerJSON leerJSON = new LeerJSON();
				LeerJSON.guardar();
				LeerJSON.leer();
			}
		});
		this.add(boton);
	}

}
