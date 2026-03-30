import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe decrit une case contenant le hero.
 *  
 * Cette classe herite de Case.
 * @see Case
 */
public class Hero extends Case{
	/**
    * vide
    */
	private int pvDebut = 100;

	/**
	 * les points de vie de depart du hero
	 */
	public int pv=pvDebut;

	/**
	 * le hero jne detient pas d'arme
	 */
	public boolean detientArme=false;
	/*private int score;*/
	/**
    * vide
    */
	private Arme arme;
	/**
    * vide
    */
	private int degat=0;
	/**
    * vide
    */
	private String action;
	/**
    * vide
    */
	private String stat;
	/**
    * vide
    */
	private int or=0;
	/**
    * Le niveau de protection.
    */
	public int pvShield=0;
	/**
    * vide
    */
	private String statDura;
	/**
    * vide
    */
	private boolean detientFullShield=false;

/**  
 * Construit un nouvel objet Hero caracterise par une valeur initiale de points de vie de 100, son nom. 
 * L'arme est identifiée par le jeu par un numero d'entite de 5.
 */
public Hero(){
	super(5);
	this.val=100;
	this.nom="Hero";
	setName();
}

/**
 * Retourne la valeur des points de vie du hero.
 * 
 * @return pv les points de vie du hero
 */
	public int getPv(){
	return pv;
}

/**
 * Recupere l'arme rencontree.
 * 
 * @param slot l'arme rencontree
 */
public void setArme(Case slot){
	this.arme= (Arme) slot;
}


/**
 * Determine les interactions du hero avec les autres elements.
 * 
 * @param element identifie le type de la case rencontree
 * @param cible la case rencontree
 */
public void rencontre(int element,Case cible){
		if(pvShield<=0){	// NOUVEAU								
		pvShield=0;
	}
	if(pvShield>=100){
		
		pvShield=100;
	}						//
	stat = "<html>Point de vie : "+pv+"<br>Point d'armure ["+pvShield+"]</html>"; // NOUVEAU : modif
	
																		

if(element==6){	//si on rencontre un coffre magique avec une potion, placer ici pour optimiser l'affichage	// NOUVEAU
	if (cible instanceof Potion) {
		pvShield=100;
	}
}
																			//											

/*------------------------------------------------------------------*/

if(cible instanceof Arme){//croise une arme
		if(detientArme==false||cible.getValeur()>degat||(cible.getValeur()==degat&&arme.getDura()<100)){ // si t'as pas d'arme ou si ton l'arme rencontrer est plus puissante
			detientArme=true;
			setArme(cible);
			degat=cible.getValeur();
action = "Vous avez obtenue une arme !";
}else{
	action = "Vous possèdez déjà une arme !";
}
	}

// --------

if(cible instanceof Monstre){//Monstre

		if(detientArme==true){
			Monstre monstre = (Monstre) cible;
			monstre.subir(degat);
			arme.degradation(cible.getValeur());
		action = "<html>Vous êtes entrain de daba le monstre<br>Il a perdu "+degat+"PV.<br>(PV Restant : "+monstre.getPv()+")</html>";
		
		if(monstre.estMort()==true){
			action = "<html>Vous avez trop daba ce monstre<br>Il est mort.<br>(PV restant : 0)</html>";	
		}
		}else{
			if(pvShield>0){					// NOUVEAU
		pvShield=pvShield-cible.getValeur();
			if(pvShield<=0){
		pvShield=0;
	}
	detientFullShield=false;
}else{										//
pv=pv-cible.getValeur();
}
if(pv<1){
	pv=0;
}
action = "<html>Un monstre vous attaqué<br>Vous perdez "+cible.getValeur()+"PV</html>";
stat = "<html>Point de vie : "+pv+"<br>Point d'armure ["+pvShield+"]</html>";
}
}

// -------

if(cible instanceof Or){// croise or
	action = "Vous avez récupérer "+cible.getValeur()+" Or";
	or=or+cible.getValeur();
								

}

// --------

if(cible instanceof Potion){ //croise potion
	pv=pv+cible.getValeur();
	action = "Vous avez récupérer "+cible.getValeur()+" PV";

		if(pv>100){
	int max=cible.getValeur()-(pv-100);
	action = "Vous avez récupérer "+max+" PV";
	pv=100;
										
}
stat = "<html>Point de vie : "+pv+"<br>Point d'armure ["+pvShield+"]</html>";

}
	if(detientArme==true){							// NOUVEAU : modif
		statDura= "<html><br>Durabilité de votre arme : "+arme.getDura()+"<br>Puissance : "+arme.getValeur()+"</html>";				
stat = "<html>Point de vie : "+pv+"<br>Point d'armure ["+pvShield+"]"+statDura+"</html>";
if(arme.getDura()<1){
			detientArme=false;
			stat = "<html>Point de vie : "+pv+"<br>Point d'armure ["+pvShield+"]"+statDura+"<br>Votre arme c'est cassé  ! </html>";
			
		}											//
	}	

	if(element==6){	//rencontre d'un coffre magique	// NOUVEAU
	if(cible instanceof Or){				
		action="<html> Le coffre magique renfermez une fortune<br>Vous récupéré 500 Or !</html>";
	}
	if(cible instanceof Potion){	
		action = "<html> Le coffre magique renfermez la potion de la vie<br>Vous récupéré la totalité de vos PV !</html>";
		
	}
	if(cible instanceof Arme){
		action="<html> Le coffre magique renfermez l'Arme Ultime<br>Vous récupéré une arme très puissante !</html>";
	}
}	

}

/**
 * Indique si le hero a en sa possession ou non une arme
 * 
 * @return true si il a une arme, false si il n'a pas d'arme
 */
public boolean detientArme(){
	return this.detientArme;
}

/**
 * Retourne la chaine de carcteres indiquant les points de vie actuelles du hero.
 * 
 * @return le points de vie actuels du hero
 */
public String getAction(){
	return this.action;
}

    /**
	* Retourne la valeur actuelle des points de vie du hero.
    * @return Les points de vie du hero.
    */
public String getStat(){
	return this.stat;
}

    /**
	* Retourne l'indication sur si le hero est mort (c'est-a-dire si ses points de vie sont inferieurs à 1).
    * 
    * @return true si le hero est mort, false sinon
    */ 
public boolean estMort(){
	if(pv<1){
		return true;
	}else{
		return false;
	}
}


/**
 * Indique si le hero a en sa possession ou non une protection.
 * 
 * @return true si il a une protection, false si il n'a pas de protection
 */
public boolean detientFullShield(){
	return this.detientFullShield;
}

/**
 * Met a jour le niveau de protection du hero
 * 
 * @param bonus les points de protection supplementaires
 */
public void setShield(int bonus){
pvShield=pvShield+bonus;
}

/**
 * Retourne la valeur du niveau de protection du hero.
 * 
 * @return le niveau de protection du hero
 */
public int getShield(){
	return pvShield;
}

/**
 * Réduit la quantite d’or du hero après un achat.
 *
 * @param perte Le montant d’or a soustraire du total du hero.
 */
public void setOrHero(int perte){
or=or-perte;
}

/**
 * Retourne la valeur de la quantite d'or du hero.
 * 
 * @return la quantite d'or du hero
 */
public int getOr(){
	return or;
}

}