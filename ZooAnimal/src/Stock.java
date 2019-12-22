
public class Stock {

	private int stock;
	
	Stock(){
		
	}
	
	public Stock(int stock) {
		this.stock=stock;
	}
	
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int updateStockDepositing(int amount) {
		this.stock = this.stock+amount;
		return stock;
	}
	
	public int updateFeedingStock(int amount) {
		this.stock=this.stock-amount;
		return stock;
	}
	
}
