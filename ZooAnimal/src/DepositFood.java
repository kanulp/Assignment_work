
public class DepositFood implements Runnable{
	
    private volatile int value;

	
	 @Override
     public void run() {
        value =  (int)(Math.random()*((20-1)+1))+1;
        Stock st = new Stock();
        st.updateStockDepositing(value);
     }

     public int getValue() {
         return value;
     }

}
