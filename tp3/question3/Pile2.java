package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
       if (taille < 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.stk=new Stack<T>();
        this.capacite=taille;
    }

    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();        
        return stk.pop();
    }

    public T sommet() throws PileVideException{
         if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    public boolean estVide() {

        return stk.isEmpty();
    }
    
    public boolean estPleine() {

        return this.taille()==this.capacite();
    }
    
    public int taille() {

        return stk.size();
    }

   
    public int capacite() {

        return this.capacite;
    }
    
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
    
    public int hashCode() {
        return toString().hashCode();
    }
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2