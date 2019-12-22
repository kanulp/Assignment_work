
public class Feeding implements Runnable{

	private volatile int value;
	private int foodStock,demand;

	Feeding(int foodStock,int demand){
		this.foodStock=foodStock;
		this.demand=demand;
	}
	
	@Override
    public void run() {
       value =  (int)(Math.random()*((n-1)+1))+1;
       Stock st = new Stock();
       st.updateFeedingStock(demand);
    }

    public int getValue() {
        return value;
    }
}
