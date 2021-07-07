Question 2.5

Que pensez vous de cette réponse pour les classes Pile, Pile2, Pile3 et Pile4 ?
Est-elle correcte ?, quelle est la règle à retenir ? (à toutes fins utiles la javadoc de java.lang.Object)

public boolean equals(Object o) {
    if (o instanceof PileI) {
      PileI p = (PileI) o;
      return this.capacite() == p.capacite()
          && this.hashCode() == p.hashCode();
    } else
      return false;
    
    }
    
    Réponse:
    
    - Dans cette methode on peut savoir si deux piles sont égaux mais sans comparer le type de l'objet dans 
    chaque pile par compter sur instanceof.
    
    par exemple 522 est different de "522"
    
    
      public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    c'est faux par ce que la capacité et la taille ne sont pas testé s'ils sont égaux ou non.