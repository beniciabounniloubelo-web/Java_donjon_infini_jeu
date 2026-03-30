import java.awt.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe permet au hero d'acheter une armure. 
 */
public class Boutique {

    /**
     * vide
     */
    private JButton btn;
    /**
     * vide
     */
    private int prixArmure = 125;
    /**
     * vide
     */
    private int shield = 25;
 
/**
 * Cree un bouton pour permettre au hero d'acheter une armure. Pour acceder a la boutique il faut avoir 125 or.
 * 
 * Voici les scenarios possibles:
 * Dans le cas ou le hero a une quantite d'or est superieur au prix de l'armure, il peut acheter une armure.
 * Sinon, dans le cas ou le hero a une protection maximale, il ne peut plus acheter d'armure.
 * Sinon, dans le cas ou le hero a une quantite d'or inferieure au prix de l'armure, il ne peut pas acheter l'armure.
 * 
 * @param hero le hero qui va pouvoir passer des achats a la boutique
 * @param fenetre la fenetre sur laquelle s'affiche le bouton
 */
    public Boutique(Hero hero, JFrame fenetre) {
        btn = new JButton("<html>Acheter une armure (" + prixArmure + " or)");
		
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hero.getOr() >= prixArmure && hero.getShield()<100) {
                    hero.setOrHero(prixArmure);
                    hero.setShield(shield);
               
                    JOptionPane.showMessageDialog(null, "<html>Armure achetée !<br>Votre or : "+hero.getOr()+"</html>");
                   
                    fenetre.requestFocusInWindow(); // si on ne l'ajoute pas une foois l'armure acheter on ne peut plus déplacer le hero
                } 

                    if (hero.getShield()>=100) {
                    JOptionPane.showMessageDialog(null, "<html>Vous avez atteind le max de protection !<br>Votre or : "+hero.getOr()+"</html>");
                    fenetre.requestFocusInWindow(); // si on ne l'ajoute pas une fois l'armure acheter on ne peut plus déplacer le hero
                }

                    if(hero.getOr()<prixArmure){
                    JOptionPane.showMessageDialog(null, "<html>Vous n'avez plus assez d'or !<br>Votre or : "+hero.getOr()+"</html>");
                }

                

                fenetre.requestFocusInWindow(); // si on ne l'ajoute pas une foois l'armure acheter on ne peut plus déplacer le hero
               
            }

        });

    }

/**
 * Permet de recuperer le bouton dans la classe Controleur.
 * 
 * @return le bouton de la boutique
 * 
 * @see Controleur
 */
    public JButton getBtn() {
        return btn;
    }

}