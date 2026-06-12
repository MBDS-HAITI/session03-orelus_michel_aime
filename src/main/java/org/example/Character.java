package org.example; // Déclare que cette classe appartient au package "org.example"

/**
 * Classe abstraite représentant un personnage du jeu.
 *
 * "Abstraite" signifie qu'on ne peut pas créer un objet Character directement.
 * Il faut obligatoirement passer par une sous-classe (Warrior, Magus, etc.).
 * Cela force chaque type de personnage à implémenter la méthode action().
 */
public abstract class Character {

    // --- ATTRIBUTS (données privées du personnage) ---

    private final String name;      // Nom du personnage (ex: "Thor") — ne change jamais (final)
    private final String typeName;  // Type du personnage (ex: "Warrior") — ne change jamais (final)
    private final Weapon weapon;    // L'arme que porte le personnage — ne change jamais (final)
    private final int hpMax;        // Points de vie maximum — fixés à la création, ne changent plus
    private int hp;                 // Points de vie actuels — varient pendant le combat
    private boolean alive;          // true = vivant, false = mort

    // --- CONSTRUCTEUR ---

    /**
     * Constructeur appelé par les sous-classes via super(...).
     * Il initialise tous les attributs du personnage à sa création.
     *
     * @param hpMax     Points de vie maximum du personnage
     * @param weapon    L'arme du personnage
     * @param typeName  Le nom du type ("Warrior", "Magus", etc.)
     * @param name      Le nom unique choisi par le joueur
     */
    public Character(int hpMax, Weapon weapon, String typeName, String name) {
        this.hpMax    = hpMax;    // Mémorise le maximum de HP
        this.hp       = hpMax;    // Au départ, le personnage a tous ses HP
        this.weapon   = weapon;   // Mémorise l'arme
        this.typeName = typeName; // Mémorise le type
        this.name     = name;     // Mémorise le nom
        this.alive    = true;     // Le personnage commence vivant
    }

    // --- MÉTHODES DE GESTION DES HP ---

    /**
     * Inflige des dégâts au personnage.
     * Si les HP tombent à 0, le personnage est marqué comme mort.
     *
     * @param amount  Quantité de dégâts à infliger
     */
    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount); // On soustrait les dégâts, mais HP ne peut pas descendre sous 0
        if (hp == 0) {
            alive = false; // Si HP = 0, le personnage meurt définitivement
        }
    }

    /**
     * Restaure des points de vie au personnage.
     * Les HP ne peuvent pas dépasser le maximum.
     *
     * @param amount  Quantité de HP à restaurer
     */
    public void restoreHp(int amount) {
        hp = Math.min(hpMax, hp + amount); // On ajoute les HP, mais sans dépasser le maximum
    }

    // --- GETTERS (méthodes pour lire les attributs privés depuis l'extérieur) ---

    public String getName()     { return name; }      // Retourne le nom du personnage
    public String getTypeName() { return typeName; }  // Retourne le type ("Warrior", etc.)
    public Weapon getWeapon()   { return weapon; }    // Retourne l'objet Weapon du personnage
    public int getHp()          { return hp; }        // Retourne les HP actuels
    public int getHpMax()       { return hpMax; }     // Retourne les HP maximum
    public boolean isAlive()    { return alive; }     // Retourne true si le personnage est vivant

    // --- MÉTHODE ABSTRAITE ---

    /**
     * Méthode abstraite : chaque sous-classe DOIT l'implémenter.
     * Elle affiche un message décrivant l'état du personnage.
     */
    public abstract void action();

    // --- AFFICHAGE ---

    /**
     * Retourne une ligne de texte formatée représentant le personnage.
     * Exemple : "Thor           [Warrior ]  HP:  85 / 100"
     * Appelée automatiquement quand on fait System.out.println(unPersonnage).
     */
    @Override
    public String toString() {
        // Si vivant : affiche les HP actuels / HP max. Sinon : affiche "DEFEATED"
        String status = alive ? String.format("HP: %3d / %3d", hp, hpMax) : "DEFEATED";

        // %-14s = texte aligné à gauche sur 14 caractères, %-8s = aligné à gauche sur 8 caractères
        return String.format("%-14s [%-8s]  %s", name, typeName, status);
    }
}
