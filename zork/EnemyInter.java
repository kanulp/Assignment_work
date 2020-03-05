import java.util.ArrayList;

public interface EnemyInter {

    public void createEnemies();
    public Enemy getEnemy();

    public boolean checkHealth(ArrayList<Enemy> enemyList);
    
}