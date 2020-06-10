package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille < 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.stk=new Stack<Object>();
        this.capacite=taille;
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();        
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {

        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {

        return this.taille()==this.capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for(int i =this.taille()-1;i>=0;i--){
            s=s+stk.get(i).toString();
            if(i>0)
                s=s+", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
       if(o==null)return false;
        if (o instanceof Pile2) {
            Pile2 pi2 =(Pile2)o;
            boolean b1= this.taille()==pi2.taille();
            boolean b2=this.capacite()==pi2.capacite();

            if((b1==false)||(b2==false))return false;

            boolean hash = this.hashCode() == pi2.hashCode();
            if(hash) 
                return true;
            return false;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {

        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {

        return this.capacite;
    }

} // Pile2.java
