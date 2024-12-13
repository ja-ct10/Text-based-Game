package consolegame;

public interface PlayerInfo {
    
    public void playerName(String name);
    public String showName();
    
    public void CharacterClass(String characterClass);
    public String showCharacterClass();
    
    public void Health(int health);
    public int showHealth();
    
    public void Weapon(String weapon);
    public String showWeapon();
    
    public boolean isDefeated();
    public boolean isAlive();
    public void takeDamage(int damage);
}