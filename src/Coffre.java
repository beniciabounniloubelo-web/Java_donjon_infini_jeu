
/**
 * Cette classe permet au hero d'obtenir des elements supplementaires.
 */
public class Coffre{

	/**
	 * L'arme que contient le coffre.
	 */
	public Arme arme;
	/**
	 * Le sac d'or que contient le coffre.
	 */
	public Or or;
	/**
	 * La potion que contient le coffre.
	 */
	public Potion potion;

/**
 * Construis un coffre contenant de un sac d'or, une potion et une arme. On reattribue de nouvelles valeurs achque element.
 */
	public Coffre(){
		or = new Or();
		arme = new Arme();
		potion = new Potion();

			or.setNewOr(500);
			or.nom="Coffre Magique";
			or.setEntite(6);
			or.setName();

			arme.setPower(50);
			arme.setDura(200);
			arme.nom="Coffre Magique";
			arme.setEntite(6);
			arme.setName();

			potion.setNewPv(100);
			potion.nom="Coffre Magique";
			potion.setEntite(6);
			potion.setName();
	}
	
	/**
	 * Soit le coffre contient une arme, une potion ou un sac d'or.
	 * 
	 * @return l'element contenue
	 */
	public Case getCoffre(){
		
		if(choixCase() instanceof Or){
			return or;	
		}else{
		if(choixCase() instanceof Arme){
			return arme;
		}else{
			return potion;
		}
	}
		
	}

/**
 * Determine aleatoirement l'element contenue dans le coffre. 
 * Il y a 40% de chances que ce soit un sac d'or, 30% de chances d'avoir une arme, 25% de chances d'avoir une potion.
 * @return La creation d'un nouvel objet dans une case du type de l'element choisi au hasard.
 */
	public Case choixCase(){		// choisi un  element aleatoire, en respectant les pourcentage indique
double random = Math.random();
if(random < 0.40){			//40% Or
	return new Or();
}
 if(random < 0.75){			//35% 
	return new Arme();
}

else 
	return new Potion();	//25%			
}



}