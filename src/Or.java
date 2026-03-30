import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe decrit une case contenant un sac d'or.
 * Un sac d'or apparait lorsque le monstre est battu.
 * 
 * Cette classe herite de Case.
 * @see Case 
 */
public class Or extends Case{

/**
 * Construis un nouvel objet Or caracterise par 20 la valeur du sac, et ses informations d'affichage. Ainsi le hero obtiens autant de points que la valeur du sac d'or lorsqu'il le recupere.
 * Le sac d'or est identifie par le jeu par un numero d'entite de 2.
 */
public Or(){ 
	super(2);
	this.val=20;
	this.nom="Sac d'or";
	setName();
}

/**
 * la valeur initiale du sac d'or.
 */
private int valeur=20;

/**
 * Recupere la valeur du sac d'or.
 * 
 * @return la quantite d'or
 */
public int getVal(){
	return valeur;
}


}