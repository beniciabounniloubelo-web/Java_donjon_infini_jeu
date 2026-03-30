import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe decrit une case contenant une arme.
 * Le hero la recupere pour l'aider a vaincre le monstre. Il ramasse l’arme s’il n’en a pas ou si elle possede une valeur d’attaque superieure à celle de son arme et ne se deplace pas.
 * 
 * Cette classe herite de Case.
 * @see Case
 */
public class Arme extends Case {

	/**
    * vide
    */
	private int puissance=choixPuissance(); 

	/**
    * vide
    */
    private int duraInitiale = 100; 

	/**
	 * L'arme est caracterise par une durabilite.
	 */
    public int dura=duraInitiale; 

/**  
 * Construit un nouvel objet Arme caracterise par la valeur de sa puissance d'attaque et ses informations d'affichage. Ainsi le hero gagne autant de points que la valeur de la puissance d'attaque de l’arme et le monstre est endommage d’autant que la puissance de l'arme.
 * L'arme est identifiée par le jeu par un numero d'entite de 3.
 */
	public Arme(){
	super(3);
	this.val=puissance;
	this.nom="<html>Arme<br>POWER : "+puissance+"</html>";
	setName();
    }


/**
 * Determine aleatoirement la puissance de l'arme avec laquelle le hero attaque le monstre. 
 * L'arme a 45% de chances d'avoir une puissance de 10, 50% de chances d'avoir une puissance de 15 et 5% de chances d'avoir une puissance de 30.
 * @return La puissance de l'arme.
 */
public int choixPuissance(){	

double random = Math.random(); 

 if(random < 0.45){			
	return 10;
}

 if(random < 0.95){			
	return 15;
}

 else{	
	return 30;
}
}


/**
 * L'arme inflige au monstre des degats equivalents à sa puissance.
 * En retour, elle perd autant de durabilité que les points de vie retires au monstre.
 * Si sa durabilite devient inferieure ou egale à 0, l'arme se casse et le heros la perd.
 * 
 * @param degat Les degats infligés au monstre, correspondant à la perte de durabilité de l'arme. 
 */
public void degradation(int degat){
dura=dura-degat;
if(dura<1){
	dura=0;
}
}


/**
 * Retourne la valeur de la durabilite actuelle de l'arme.
 * @return La durabilite de l'arme.
 */
public int getDura(){
	return dura;
}


/**
 * Retourne la valeur de la puissance de l'arme.
 * @return La puissance de l'arme.
 */
public int getVal(){  
	return puissance;
}


}