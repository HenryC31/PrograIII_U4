import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

		JLabel usuario_tag = new JLabel("Usuario:");
		usuario_tag.setBounds(140, 100, 200, 30);
		this.add(usuario_tag);
		JTextField usuario_txt = new JTextField();
		usuario_txt.setBounds(140, 130, 200, 30);
		this.add(usuario_txt);

		JLabel contra_tag = new JLabel("Contraseña:");
		contra_tag.setBounds(140, 180, 200, 30);
		this.add(contra_tag);
		JPasswordField pass_txt = new JPasswordField();
		pass_txt.setBounds(140, 210, 200, 30);
		this.add(pass_txt);

		JLabel cuentas = new JLabel("Cuentas para iniciar sesión en la consola");
		cuentas.setBounds(125, 250, 300, 100);
		this.add(cuentas);

		JButton boton = new JButton("Iniciar sesión");
		boton.setBounds(140, 350, 200, 50);
		boton.setFont(new Font("", Font.BOLD, 20));
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerJSON leerJSON = new LeerJSON();
				LeerJSON.guardar();
				if (LeerJSON.leer(usuario_txt.getText(), new String(pass_txt.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente");
					usuario_txt.setText("");
					pass_txt.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos");
				}
//				leerJSON.evaluar("Hola", "Adiós");
			}
		});
		this.add(boton);
		this.repaint();
		this.revalidate();
		System.out.println(
				"Cuenta 1:\nUsuario: henryc22\nContra: hola123\n\nCuenta 2:\nUsuario: armando33\nContra: adios123");
	}

}
