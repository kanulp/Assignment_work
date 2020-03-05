public class Player {

    private String name;
    private String gender;
    private int age,health;
    private String date;
    private  int count=0;
    private int numHealthPostions;
    private String position;

    public Player(){
        
    }

    public Player(String name,String gender,int age,String date){
        this.name=name;
        this.gender=name;
        this.age = age;
        this.date = date;
        numHealthPostions=0;
        count=0;
        health=100;
        position="center";
    }

    public int getNumHealthPostions(){
        return numHealthPostions;
    }

    public void setNumHealthPostions(int n){
        numHealthPostions = n;
    }

    public void setCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    
    
}