import java.awt.*;
import javax.swing.*;

/**
 * Cette classe decrit le plateau de jeu. Le plateau est compose de 3x3 cases.
 * 
 * @see Case
 */
public class VuePlateau {
 
	/**
	 * Un plateau est un tableau d'objets de type Case.
	 */
    public Case[][] plateau;

	/**  
    * Construit un nouvel objet VuePlateau caracterise par un tableau de 3x3 objets Case avec un contenue aleatoire definie.
    */
	public VuePlateau(){
    plateau = new Case[3][3];
    for(int i=0;i<3;i++){
	for(int j=0;j<3;j++){
		/*plateau[i][j]= new Case(choixCase());*/
		plateau[i][j]= choixCase();

	}
}

}

/**
 * Determine aleatoirement l'element contenue dans une case du plateau. 
 * Il y a 50% de chances que ce soit le Monstre, 20% de chances d'avoir un sac d'or, 17,5% d'avoir une arme et 12,5% de chances d'avoir une potion.
 * @return La creation d'un nouvel objet dans une case du type de l'element choisi au hasard.
 */
public Case choixCase(){		
double random = Math.random();
if(random < 0.5){			
	return new Monstre();
}
 if(random < 0.7){			
	return new Or();
}
 if(random < 0.875){	
	return new Arme();
}
else 
	return new Potion();				
}

/**
 * Permet d'acceder a une case en particulier.
 * @param i le numero de la ligne de la case a laquelle on souhaite acceder.
 * @param j le numero de la colonne de la case a laquelle on souhaite acceder.
 * @return la case situee a la position (i, j) du plateau.
 */
public Case getCase(int i,int j){
return plateau[i][j];
}

/**
 * Mets a jour une case en particulier.
 * @param i le numero de la ligne de la case que l'on souhaite modifier.
 * @param j le numero de la colonne de la case que l'on souhaite modifier.
 * @param c l'element que l'on rentre rdans cette case
 */
public void setCase(Case c,int i, int j){
plateau[i][j]=c;
}


}