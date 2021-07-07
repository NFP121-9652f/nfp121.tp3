package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author ZIAD DAOUD
 * @version 06/07/2021
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
         if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }
    
    //La méthode sommet retourne le sommet de la pile (sans dépiler)
    public Object sommet() throws PileVideException {
        return this.zone[ptr-1];
    }
    
    //indique le nombre maximal d'éléments que l'on peut empiler.
    public int capacite() {
        return this.zone.length;
    }
    
    //retourne le nombre d'éléments présents dans cette pile.
    public int taille() {
        //in case empty
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }

    public boolean estVide() {
        return this.ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }
    
    
    //teste l'égalité de deux Piles : Deux piles sont égales si elles ont la même taille, même capacité, et les éléments contenus identiques.
    public boolean equals(Object o) {
        if(!(o instanceof Pile)){
            return false;
        }
         if( this == o ){
            return true;
        }   
        
        Pile p1 = (Pile)o;
        
           if (p1.capacite() == this.capacite()  && p1.taille() == this.taille()){
            boolean isEqual = false;
            for(int i=zone.length - 1; i >=0; i--){
                Object obj = zone[i];
                boolean equal = false;
                for(int j = zone.length-1; j>=0; j--){
                    if(obj == p1.zone[i]){
                        equal = true;
                    }       
                }
                if(equal){
                    isEqual = true;
                }else{
                    return false;
                }
            }
            return true;
        }                
        return false;
    }
    

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
          StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    
    }
}