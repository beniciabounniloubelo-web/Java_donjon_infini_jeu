import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe represente dans le jeu une case qui comporte une potion dans le jeu. 
 * Le hero la consomme pour guerir.
 * 
 * Cette classe herite de Case.
 * @see Case 
 */
public class Potion extends Case{


/**
 * Construis un nouvel objet Potion caracterise par 25 la valeur de la potion, et ses informations d'affichage. Ainsi le hero gagne autant de points de vie et de points que la valeur de la potion lors de sa consommation.
 * La potion est identifie par le jeu par un numero d'entite de 4.
 */
public Potion(){ 
	super(4);
	this.val=25;
	this.nom="<html>Potion<br>+"+this.val+" HEAL</html>";
	setName();
}

/**
 * vide
 */
private int valeur=25;

/**
 * Retourne les points que rapporte ce sac d'or.
 * @return La valeur en points du sac d'or.
 */
public int getVal() {
    return valeur;
}



}