import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


/**
 * Cette classe gere les deplacements et interactions entre le hero et les differents elements du plateau. 
 * 
 * Cette classe herite de KeyListener.
 * @see KeyListener
 */
public class Controleur implements KeyListener{
	/**
    * vide
    */
	private static int x=1;

	/**
    * vide
    */
    private static int y=1;

	/**
    * vide
    */
    private static int oldX=0;

	/**
    * vide
    */
    private static int oldY=0;

	/**
    * vide
    */
    private static int point=0;

	/**
    * vide
    */
    private static JFrame fenetreDI;

	/**
    * vide
    */
    private static VuePlateau plt;

	/**
    * vide
    */
    private static Hero hero;

	/**
    * vide
    */
    private static String actionTxt;

	/**
    * vide
    */
    private static String statTxt;

	/**
    * vide
    */
    private static JPanel infoPv;

	/**
    * vide
    */
    private static JPanel infoAction;

	/**
    * vide
    */
    private static JPanel infoScore;

	/**
    * vide
    */
    private static BufferedImage imageMort;
    
	/**
    * vide
    */
    private static Boutique boutique;

/**  
 * Construit un nouvel objet Controleur qui est une fenetre affichant par plusieurs elements graphiques:
 * des informations sur des actions, des points de vie, un score, un hero et un plateau.
 * 
 * @param fenetre la fenetre sur laquelle s'affiche le plateau de jeu
 */
public Controleur(JFrame fenetre){
	this.fenetreDI=fenetre;
infoAction = new JPanel();
infoPv = new JPanel();
infoScore = new JPanel();
plt= new VuePlateau();
hero = new Hero();
}

/**
 * Gere les rencontres entre le hero et les autres elements et determine le scenario qui s'ensuit selon l'element rencontre.
 * Elle met a jour les informations d'affichage sur la fenetre.
 * 
 * Le hero parcours les cases du tableau. 
 * Si il rencontre un monstre et qu'il meurt, la case ou le monstre est mort devient une case contenant de l'or. 
 * Si la case rencontree n'est pas un monstre, on cree une nouvelle case aleatoire.
 * Les points du hero sont augmentes en fonction de la valeur de la case. A la fin de la partie les points du hero seront sont score.
 * Si le hero possede 125 d'or, il aura acces a la boutique.
 * 
 * @param fenetre la fenetre principale du jeu.
 */
public static void miseAJour(JFrame fenetre){
	fenetre.getContentPane().removeAll();
		if(hero.estMort()==false){
	
		Case lastCase = new Case(0); 
		
for(int i=0;i<4;i++){	
	for(int j=0;j<4;j++){		
if(i==x&&j==y){
		infoPv.removeAll();
		infoAction.removeAll();
		infoScore.removeAll();
	lastCase=plt.getCase(i,j);
	if(oldX!=x||oldY!=y){
	hero.rencontre(lastCase.getEntite(),lastCase);

		if(lastCase.getEntite()==1){	
			Monstre monstre = (Monstre) lastCase;

			if(monstre.estMort()==true){	
				Case newOr = new Or();
				newOr.setNewOr(lastCase.getValeur());
				plt.setCase(newOr,i,j);	
	
	point=point + lastCase.getValeur();

}
}
// if(lastCase.getEntite()==2){			
// 	point=point + lastCase.getValeur();
// 	plt.setCase(plt.choixCase(),i,j);

// }
// if(lastCase.getEntite()==3){			

// 	plt.setCase(plt.choixCase(),i,j);
// 	point=point + lastCase.getValeur();
// }
// if(lastCase.getEntite()==4){			
// 	plt.setCase(plt.choixCase(),i,j);
// 	point=point + lastCase.getValeur();

// }
if(lastCase.getEntite()!=1){			// NOUVEAU : modif (optimisation)
	plt.setCase(plt.choixCase(),i,j);
	point=point + lastCase.getValeur();

}

actionTxt = hero.getAction();
statTxt = hero.getStat();
}else{
	actionTxt="<html>Vous ne pouvez pas allez plus loin,<br>vous avez atteint la bordure du jeu</html>";
}
	fenetre.add(hero);



}else{
fenetre.add(plt.getCase(i,j));

}

	}
}
	infoScore.add(new JLabel("<html>Score : "+point+"<br>Or : "+hero.getOr()+"</html>"));	
	infoPv.add(new JLabel(statTxt));
	infoAction.add(new JLabel(actionTxt));
		fenetre.add(infoAction);
		fenetre.add(infoPv);
		fenetre.add(infoScore);

if(hero.getOr()>=125){								// NOUVEAU (boutique)
		boutique = new Boutique(hero,fenetre);
		fenetre.add(boutique.getBtn());

	}else{
		fenetre.add(new JLabel("<html><div style='text-align:center'>BOUTIQUE</div><br>Récupérer 125 or pour pouvoir <br>acheter une armure</html>"));

	}												



	}else{
		
fenetre.setLayout(new GridLayout(2, 1));
		
		JLabel mort = new JLabel("<html><div style='text-align:center'>VOUS ETES MORT !<br><br>SCORE : "+point+"</div></html>", SwingConstants.CENTER); 
		JPanel deadText = new JPanel();
		fenetre.add(mort);
		try{
		BufferedImage imageMort = ImageIO.read(new File("mort.png"));
		JLabel pic = new JLabel(new ImageIcon(imageMort));
		fenetre.add(pic);
	}catch(IOException e){}
		System.out.println("SCORE FINAL: "+point);
	
	
	}
	oldX=x;
	oldY=y;
fenetre.revalidate();
fenetre.repaint();

}


/**
 * Gere les deplacements du hero. Ce dernier peut se deplacer sur une case adjacente (haut, bas, gauche, droite) grace aux touches en forme de fleche du clavier. 
 * De plus, elle rajout un nombre fixe de points a chaque deplacement.
 * 
 * @param e l'evenement qui capture la touche pressee
 */
public void keyPressed(KeyEvent e){
if(e.getKeyCode()==KeyEvent.VK_UP && x > 0){
	x--;
point=point+5;	//NOUVEAU
}
if(e.getKeyCode()==KeyEvent.VK_DOWN && x < 3){
	x++;
point=point+5;
}

if(e.getKeyCode()==KeyEvent.VK_LEFT && y > 0){
y--;
point=point+5;
}
if(e.getKeyCode()==KeyEvent.VK_RIGHT && y < 3){
	y++;
point=point+5;	
}
miseAJour(fenetreDI);
}

/**
 * Ne fait rien lorsqu'une touche est relachee.
 * 
 * @param e l'evenement clavier
 */
public void keyReleased(KeyEvent e){}

/**
 * Ne fait rien lorsqu'une touche est tapee.
 * 
 * @param e l'evenement clavier
 */
public void keyTyped(KeyEvent e){}
}