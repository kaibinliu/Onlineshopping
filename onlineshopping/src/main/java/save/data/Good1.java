package save.data;

public class Good1 {
    private int GNo;
    private String GName;
    private String GDescribe;
    private String GPicture;
    private double GPrice;
    private int GStock;
    private String GState;
    
    public int getGNo() {
		return GNo;
	}
	public void setGNo(int gNo) {
		GNo = gNo;
	}
	public String getGName() {
		return GName;
	}
	public void setGName(String gName) {
		GName = gName;
	}
	public String getGDescribe() {
		return GDescribe;
	}
	public void setGDescribe(String gDescribe) {
		GDescribe = gDescribe;
	}
	public String getGPicture() {
		return GPicture;
	}
	public void setGPicture(String gPicture) {
		GPicture = gPicture;
	}
	public double getGPrice() {
		return GPrice;
	}
	public void setGPrice(double gPrice) {
		GPrice = gPrice;
	}
	public int getGStock() {
		return GStock;
	}
	public void setGStock(int gStock) {
		GStock = gStock;
	}
	public String getGState() {
		return GState;
	}
	public void setGState(String gState) {
		GState = gState;
	}
	public Good1() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Good1(int gNo, String gName, String gDescribe, String gPicture, double gPrice, int gStock, String gState) {
		super();
		GNo = gNo;
		GName = gName;
		GDescribe = gDescribe;
		GPicture = gPicture;
		GPrice = gPrice;
		GStock = gStock;
		GState = gState;
	}

}
