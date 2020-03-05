
public class Enemy {

    private String enemyName;
    private int maxEnemyHealth;
    private int enemyAttackDamage = 25;
    public Enemy(){

    }

    public Enemy(String enemyName,int maxEnemyHealth,int enemyAttackDamage){
        this.enemyName = enemyName;
        this.maxEnemyHealth=maxEnemyHealth;
        this.enemyAttackDamage=enemyAttackDamage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public void setMaxEnemyHealth(int maxEnemyHealth) {
        this.maxEnemyHealth = maxEnemyHealth;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public void setEnemyAttackDamage(int enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    


}