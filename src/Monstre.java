import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Cette classe decrit une case contenant le monstre.
 * C'est l'adversaire du heros. Si le monstre est battu, un sac d'or apparait.
 * 
 * Cette classe herite de Case.
 * @see Case
 */
public class Monstre extends Case{

	/**
    * vide
    */
    private int pv; 

	/**
    * Le Monstre est caracterise par un niveau.
    */
    public String niveau;

/**  
 * Construit un nouvel objet Monstre caracterise par la valeur de ses points de vie et son niveau. 
 * L'arme est identifiée par le jeu par un numero d'entite de 3.
 */
public Monstre(){  
	super(1);
	niveau= "";
	this.val=choixPv();
	this.pv=this.val;
	this.nom=niveau;
	setName();
}

/**
 * Determine aleatoirement la valeur des points de vie du monstre.
 * Le monstre a 35% de chances d'avoir des points de vie de 15, 50% de chances d'avoir des poinst de vie de 25 et 15% de chances d'avoir des poinst de 40.
 * @return Les points d evie du monstre.
 */
public int choixPv(){		
double random = Math.random();
if(random < 0.35){			
	niveau = "<html>Monstre<br>NIV I</html>";
	return 15;
	
}
 if(random < 0.85){			
 	niveau = "<html>Monstre<br>NIV II</html>";
	return 25;
	
}
 else{	
 	niveau = "<html>Monstre<br>NIV III</html>";
	return 40;
	
}
}

/**
 * Retourne la valeur des points de vie actuelle du monstre.
 * @return Les points de vie actuelles du monstre.
 */
public int getPv(){
	return pv;
}

/**
 * Retourne la valeur des points de vie du monstre.
 * @return Les points de vie du monstre.
 */
public int getPvDebut(){
	return pvDebut;
}

/**
 * Retourne la chaine de caractere indiquant le niveau du monstre.
 * @return Le niveau du monstre.
 */
public String getNiv(){
	return niveau;
}

/**
 * Dans le cas ou le hero possede une arme, il attaque le monstre avec son arme et il l'endommage d’autant que la valeur de son arme, et l’arme perd autant de valeur que les points de vies du monstre.
 * Autre: Dans le cas ou le hero n'a pas d'arme, il prend autant de degats que la valeur des points de vie du monstre. 
 * Autre: Si le monstre est battu, un sac d’or apparaît de valeur égale au nombre de points de vie initiaux du monstre.
 * 
 * @param degat les degats subit par le monstre
 * @see Hero
 * @see Or
 */
public void subir(int degat){
pv = pv - degat;
if(pv<1){
	pv=0;
}
}

/**
 * Le monstre est mort ou non.
 * @return Si le monstre est mort ou pas.
 */
public boolean estMort(){
	if(pv<1){
		return true;
	}else{
		return false;
	}
}


}