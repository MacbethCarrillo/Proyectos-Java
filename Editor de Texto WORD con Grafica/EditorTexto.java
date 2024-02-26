package U1;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class EditorTexto extends JFrame implements ActionListener {

	// Elementos del programa jeje
	JTextArea textArea;
	JScrollPane barraScroll;
	JComboBox elegirFuente;
	JMenuBar menuBarra;

	// Menu Archivo
	JMenu MenuArchivo;
	JMenuItem MenuNuevo;
	JMenuItem MenuGuardar;
	JMenuItem MenuSalir;
	JMenuItem MenuImprimir;

	// Menu Edicion
	JMenu MenuEdicion;
	JMenuItem MenuCopiar;
	JMenuItem MenuPegar;

	// Menu Ayuda
	JMenu MenuAyuda;
	JMenuItem MenuAcerca;
	JMenuItem MenuAbrir;

	EditorTexto() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Primer proyecto de la Unidad GUI");
		this.setSize(500, 600);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16)); // Tamaño de la letra

		barraScroll = new JScrollPane(textArea);
		barraScroll.setPreferredSize(new Dimension(450, 450));
		barraScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		elegirFuente = new JComboBox(fuentes);
		elegirFuente.addActionListener(this);
		elegirFuente.setSelectedItem("Arial");

		// ------ Menu Archivo ------

		menuBarra = new JMenuBar();

		MenuArchivo = new JMenu("Archivo");
		MenuNuevo = new JMenuItem("Nuevo");
		MenuAbrir = new JMenuItem("Abrir");
		MenuGuardar = new JMenuItem("Guardar como");
		MenuImprimir = new JMenuItem("Imprimir");
		MenuSalir = new JMenuItem("Salir");

		MenuNuevo.addActionListener(this);
		MenuAbrir.addActionListener(this);
		MenuImprimir.addActionListener(this);
		MenuGuardar.addActionListener(this);
		MenuSalir.addActionListener(this);

		MenuArchivo.add(MenuNuevo);
		MenuArchivo.add(MenuAbrir);
		MenuArchivo.add(MenuGuardar);
		MenuArchivo.add(MenuImprimir);
		MenuArchivo.add(MenuSalir);
		menuBarra.add(MenuArchivo);

		// -------- Menu Edicion --------------

		MenuEdicion = new JMenu("Edicion");
		MenuCopiar = new JMenuItem("Copiar");
		MenuPegar = new JMenuItem("Pegar");
		menuBarra.add(MenuEdicion);

		MenuCopiar.addActionListener(this);
		MenuPegar.addActionListener(this);

		MenuEdicion.add(MenuCopiar);
		MenuEdicion.add(MenuPegar);

		// -------- Menu Ayuda --------------

		MenuAyuda = new JMenu("Ayuda");
		MenuAcerca = new JMenuItem("Acerca de...");
		menuBarra.add(MenuAyuda);
		MenuAcerca.addActionListener(this);
		MenuAyuda.add(MenuAcerca);

		this.setJMenuBar(menuBarra);
		this.add(elegirFuente);
		this.add(barraScroll);
		this.setVisible(true);
	}

	// Acciones de los menus
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == MenuNuevo) {
			textArea.setText("");
		}

		if (e.getSource() == elegirFuente) {
			textArea.setFont( // Elegir fuente
					new Font((String) elegirFuente.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
		}

		if (e.getSource() == MenuAbrir) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filtroTXT = new FileNameExtensionFilter("Archivos de Texto , Macbeth Carrillo",
					"txt");
			fileChooser.setFileFilter(filtroTXT);

			int valoRetorno = fileChooser.showOpenDialog(null);

			if (valoRetorno == JFileChooser.APPROVE_OPTION) {
				File archivo = fileChooser.getSelectedFile();
				try {
					BufferedReader leer = new BufferedReader(new FileReader(archivo));
					textArea.read(leer, null);
					leer.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		if (e.getSource() == MenuGuardar) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));

			int respuesta = fileChooser.showSaveDialog(null);

			if (respuesta == JFileChooser.APPROVE_OPTION) {
				File ArchivoGuardar;
				PrintWriter ArchivoSalida = null;

				ArchivoGuardar = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					ArchivoSalida = new PrintWriter(ArchivoGuardar);
					ArchivoSalida.println(textArea.getText());
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				} finally {
					ArchivoSalida.close();
				}
			}
		}
		if (e.getSource() == MenuSalir) {
			System.exit(0);
		}

		if (e.getSource() == MenuCopiar) {
			textArea.copy();
		} else if (e.getSource() == MenuPegar) {
			textArea.paste();
		}

		if (e.getSource() == MenuAcerca) {
			JOptionPane.showMessageDialog(this, "Autor del programa: Macbeth Adolfo Carrillo Ibarra", "Pongame 100",
					JOptionPane.PLAIN_MESSAGE);
		}

		if (e.getSource() == MenuImprimir) {
			try {
				textArea.print();
			} catch (PrinterException ex) {
				JOptionPane.showMessageDialog(this, "Error al imprimir: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}