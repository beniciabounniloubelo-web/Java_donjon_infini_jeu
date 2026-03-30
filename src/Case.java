import java.awt.*;
import javax.swing.*;

/**
 * Cette classe decrit une case du plateau de jeu. Elle peut contenir un element.
 */
public class Case extends JPanel{

	/**
    * Une case est caracterise par une valeur.
    */
	protected int val; 
	
	/**
    * vide
    */
	private Hero hero; 
	
	/**
    * vide 
    */
	private Monstre monstre;
	
	/**
    * vide 
    */
	private Or or;

	/**
    * vide
    */
	private Arme arme;
	
	/**
    * vide
    */
	private Potion potion;

	/**
    * vide
    */
	private JLabel nomAffiche;

	/**
    * Une case identifie son element contenue avec un numero d'entite.
    */
	public int rEntite; 

	/**
    * Une case est caracterise par un nom.
    */
	protected String nom;

	/**
    * Construit un nouvel objet Case identifiee par un numero d'entite.
    * Par defaut, la case est blanche. Elle est magenta pour un hero, rouge pour un monstre, jaune pour un coffre.
    * @param entite Le numero identifiant l'entite contenue dans la case.
	*/
	public Case(int entite){ 
		super();
		this.rEntite=entite; 
		setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	if(entite==1){
		setBackground(Color.RED);
		}
	if(entite==5){ 
		setBackground(Color.MAGENTA);
		}
	}

		/**
        * Retourne la valeur du numero d'entite de l'element contenue dans la case.
        * @return Le numero d'entite de la case.
        */
		public int getEntite(){
			return rEntite;
		}

		/**
        * Retourne la valeur de la case.
        * @return La valeur de la case.
        */
		public int getValeur(){
			return val;
		}

		/**
        * Affiche le nom de l'element contenue dans la case.
        */
		public void setName(){
			add(new JLabel(nom)); 

		}

		/**
        * Modifie la valeur de l'element Or.
        * @param newOr La nouvelle valeur de l'element Or.
        */
		public void setNewOr(int newOr){
			if(rEntite==2){
        this.val=newOr;
        }
        }

		

}