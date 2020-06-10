package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IHMPile  extends JFrame implements ActionListener {
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("empiler")){
            try{
            Object s = donnee.getText();
            p.empiler(s);
           contenu.setText( p.toString());
            // en cas d'exception
            }catch (PilePleineException ep){contenu.setText( p.toString() + " estPleine !");}
            

        }else{
            try{
                Object o =p.depiler();
                sommet.setText(o.toString());
                contenu.setText( p.toString());
            // en cas d'exception
        } catch(PileVideException ev){contenu.setText(  p.toString() + " estVide !");
           

        }
            
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
