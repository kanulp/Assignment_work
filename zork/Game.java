import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game implements PlayGameInter,EnemyInter{

    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    
    @Override
    public Player createPlayer(){
        System.out.println("Welcome to the Game");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
       
        System.out.print("Enter your gender: ");
        String gender = input.nextLine();
       
        System.out.print("Enter your age: ");
        int age = input.nextInt();
       
        System.out.print("Enter your birthdate: ");
        String bdate = input.nextLine();

        Player p = new Player(name,gender,age,bdate);
        System.out.println("\nPlayer "+name+" created.");
        //input.close();
        return p;

    }

    @Override
    public void printPlayer(Player p){
        System.out.println("Welcome ....");
        System.out.println("Player Name : "+p.getName());
        System.out.println("Player Gender : "+p.getGender());
        System.out.println("Player Age : "+p.getAge());
        System.out.println("Player Birthdaye :"+p.getDate());
    }

    @Override
    public void playGame(Player player){

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to Game.\nThere are Enemies in all direction.Move towards every directions and dodge enemies.");
        boolean running = true;
        createEnemies();

        GAME:
        while (running) {
            
            Enemy myEnemey = getEnemy();

            //int enemyHealth = random.nextInt(Constants.maxEnemyHealth);
            int enemyHealth = myEnemey.getMaxEnemyHealth();
            
            while (!checkHealth(enemyList)) {
                System.out.println("--------------------------------");
                System.out.println("You are currently in "+player.getPosition()+" direction.");
                System.out.println("\nWhere do you want to go ? Type direction :");
                String inputDirection;
                inputDirection = in.nextLine().toUpperCase();
                while (running) {
                    switch (inputDirection) {
                        case "EAST":
                            System.out.println("You are headed EAST, Look for enemies.");
                            player.setCount();
                            player.setPosition("East");
                            
                            break;
                        case "WEST":
                            System.out.println("You are headed WEST, Look for enemeis.");
                            printCount(player);
                            player.setPosition("West");

                        break;

                        case "NORTH":
                        System.out.println("You are headed NORTH, Look for enemeis.");
                        printCount(player);
                        player.setPosition("North");
                        break;

                        case "SOUTH":
                        System.out.println("You are headed SOUTH, Look for enemeis.");
                        printCount(player);
                        player.setPosition("South");
                        break;

                        case "CENTER":
                        System.out.println("You are headed CENTER, Look for enemeis.");
                        printCount(player);
                        player.setPosition("Center");
                        break;

                        default:
                        System.out.println("Invalid Choice.");
                        break;
                    }
                    if(inputDirection.toLowerCase().equals("east") || inputDirection.toLowerCase().equals("west") || inputDirection.toLowerCase().equals("north") || inputDirection.toLowerCase().equals("south") || inputDirection.toLowerCase().equals("center")){
                        break;
                    }else{
                        inputDirection = in.nextLine().toUpperCase();
                    }
                }

                //String enemy = Constants.enemies[random.nextInt(Constants.enemies.length)];
                String enemy = myEnemey.getEnemyName();
                System.out.println(enemy+" has appeared!");    
                System.out.println("\nYour Health : "+player.getHealth());
                System.out.println("Enemy Health : "+enemyHealth);
                System.out.println("What would you like to do : \n1.Attack\n2.Health Option\n3.Run!");

                String input = in.nextLine();
                switch (input) {
                    case "1":
                        int damageDealt = random.nextInt(Constants.attackDamage);
                        //int damageTaken = random.nextInt(Constants.enemyAttackDamage);
                        int damageTaken = myEnemey.getEnemyAttackDamage();
                        enemyHealth -= damageDealt;

                        int health = player.getHealth();
                        health-=damageTaken;
                        player.setHealth(health);

                        System.out.println("You attacked the "+enemy+" for "+damageDealt+" damage.");
                        System.out.println("You received : "+damageTaken);

                        if(health<1){
                            System.out.println("You have taken too much damage.");
                            break;
                        }
                        player.setCount();

                        break;
                    case "2":
                    if (player.getNumHealthPostions()>0) {
                        player.setHealth(player.getHealth()+Constants.healthPotionMealAmount);
                        //health+=healthPotionMealAmount;
                        //numHealthPostions--;
                        player.setNumHealthPostions(player.getNumHealthPostions()-1);
                        System.out.println("You are healing youself for : "+Constants.healthPotionMealAmount+"\nYour health : "+player.getHealth()+"\nHealth Postion left : "+player.getNumHealthPostions());

                    }else{
                        System.out.println("You have no choice left: ");
                    }
                    player.setCount();

                    break;
                    case "3":
                    System.out.println("You run away from "+enemy);
                    player.setCount();
                    continue GAME;
                    default:
                    System.out.println("Invalid choice");
                        break;
                }
                if(player.getHealth()<1){
                    System.out.println("You lost the battle. Bye...");
                    printCount(player);
                    System.exit(0);
                }
                System.out.println("-----------------------");
                System.out.println(enemy+" was defeated!");
                System.out.println("You have health : "+player.getHealth());
                if(random.nextInt(100)<Constants.healthPotionDropChance){
                    player.setNumHealthPostions(player.getNumHealthPostions()+1);
                    //numHealthPostions++;
                    System.out.println(enemy+" dropped heath postion.");
                    System.out.println("You have "+player.getNumHealthPostions()+" health position");

                }
                System.out.println("-----------------------");
                System.out.println("Would you like to do mow?");
                System.out.println("1. Continue Fighting");
                System.out.println("2. Exit");

                String input2 = in.nextLine();
                while (running) {
                    switch (input2) {
                        case "1":
                            System.out.println("You continue to choose play further.");
                            player.setCount();
                            break;
                        case "2":
                            System.out.println("You exited.");
                            printCount(player);
                            System.exit(0);
                        break;
                        default:
                        System.out.println("Invalid Choice.");
                            break;
                    }
                    break;
                }
                

            }
        }
        in.close();
    }

    public static void printCount(Player p){
        System.out.println("Your total choice Count : "+p.getCount());
    }

    @Override
    public void createEnemies() {

        enemyList.add(new Enemy("Skeleton", 100, 40));
        enemyList.add(new Enemy("Zombie", 100, 30));
        enemyList.add(new Enemy("Warrior", 100, 20));
        enemyList.add(new Enemy("Assasin", 100, 60));
        enemyList.add(new Enemy("Bewarewolf", 100, 10));
        enemyList.add(new Enemy("Tyrannosaura", 100, 40));
    }

    @Override
    public Enemy getEnemy() {
        int random = new Random().nextInt(enemyList.size());
        System.out.println("Ran is : "+random);
        Enemy ee = enemyList.get(0);
        System.out.println("name is :"+ee.getEnemyName());
        return enemyList.get(new Random().nextInt(enemyList.size()));
    }

    @Override
    public boolean checkHealth(ArrayList<Enemy> enemyList) {
        boolean areAllDefeated = true;
        for (Enemy enemy : enemyList) {
            if(enemy.getMaxEnemyHealth() > 1){
                areAllDefeated=false;
            }
        }
        return areAllDefeated;
    }

}