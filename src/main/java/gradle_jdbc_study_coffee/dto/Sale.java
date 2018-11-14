package gradle_jdbc_study_coffee.dto;

public class Sale {
	private int no;
	private String code;	//제품코드
	private int price;	//제품단가
	private int saleCnt;	//판매수량
	private int marginRate;		//마진율
	
	
	//생성자
	private Sale() {
		// TODO Auto-generated constructor stub
	}

	private Sale(int no, String pCode, int unitCost, int sAmount, int margin) {
		this.no = no;
		this.code = pCode;
		this.price = unitCost;
		this.saleCnt = sAmount;
		this.marginRate = margin;
	}

	private Sale(String pCode) {
		this.code = pCode;
	}

	
	//getter, setter
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getpCode() {
		return code;
	}


	public void setpCode(String pCode) {
		this.code = pCode;
	}


	public int getUnitCost() {
		return price;
	}


	public void setUnitCost(int unitCost) {
		this.price = unitCost;
	}


	public int getsAmount() {
		return saleCnt;
	}


	public void setsAmount(int sAmount) {
		this.saleCnt = sAmount;
	}


	public int getMargin() {
		return marginRate;
	}


	public void setMargin(int margin) {
		this.marginRate = margin;
	}

	
	//toString
	@Override
	public String toString() {
		return String.format("sale [no=%s, pCode=%s, unitCost=%s, sAmount=%s, margin=%s]", no, code, price, saleCnt,
				marginRate);
	}
}
