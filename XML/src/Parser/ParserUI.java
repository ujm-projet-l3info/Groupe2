package Parser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserUI {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("ParserUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 300);
		// frame.setPreferredSize(new Dimension(605,490));
		frame.setResizable(false);

		JLabel bdd = new JLabel("Adresse BDD :");
		JLabel id = new JLabel("Identifiant :");
		JLabel mdp = new JLabel("Mot de passe :");
		JLabel osm = new JLabel("Fichier osm :");

		final TextField tbdd = new TextField();
		final TextField tid = new TextField();
		final TextField tmdp = new TextField();
		
		tbdd.setText("jdbc:mysql://127.0.0.1/application_android_projet");
		ParserParam.bdd = "jdbc:mysql://127.0.0.1/application_android_projet";

		tbdd.addTextListener(new TextListener() {

			public void textValueChanged(TextEvent e) {
				ParserParam.bdd = tbdd.getText();
			}
		});

		tid.addTextListener(new TextListener() {

			public void textValueChanged(TextEvent e) {
				ParserParam.id = tid.getText();
			}
		});

		tmdp.addTextListener(new TextListener() {

			public void textValueChanged(TextEvent e) {
				ParserParam.mdp = tmdp.getText();
			}
		});

		JPanel posm = new JPanel();

		final TextField bosm = new TextField();
		bosm.setEditable(false);
		bosm.setPreferredSize(new Dimension(80, 25));
		JButton jbosm = new JButton("Parcourir");

		posm.add(bosm);
		posm.add(jbosm);

		JPanel haut = new JPanel();
		haut.setLayout(new GridLayout(4, 2));

		jbosm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fcosm = new JFileChooser();
				int retour = fcosm.showOpenDialog(null);
				if (retour == JFileChooser.APPROVE_OPTION) {
					fcosm.getSelectedFile().getName();
					ParserParam.chemin = fcosm.getSelectedFile().getAbsolutePath();
					bosm.setText(ParserParam.chemin);
				}
			}
		});

		haut.add(bdd);
		haut.add(tbdd);
		haut.add(id);
		haut.add(tid);
		haut.add(mdp);
		haut.add(tmdp);
		haut.add(osm);
		haut.add(posm);

		frame.getContentPane().add(haut, BorderLayout.CENTER);

		JPanel boutonBas = new JPanel();
		JButton initialiser = new JButton("Initialiser");
		boutonBas.add(initialiser);
		JButton update = new JButton("Update");
		boutonBas.add(update);

		initialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				ParserSAX handler = new ParserSAX();
				try {
					SAXParser saxparseur = factory.newSAXParser();
					saxparseur.parse(ParserParam.chemin, handler);
				} catch (ParserConfigurationException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SAXException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				frame.dispose();
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				UpdateParser handler = new UpdateParser();
				try {
					SAXParser saxparseur = factory.newSAXParser();
					saxparseur.parse(ParserParam.chemin, handler);
				} catch (ParserConfigurationException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SAXException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				frame.dispose();
			}
		});
		
		
		frame.getContentPane().add(boutonBas, BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.pack();

	}

}
