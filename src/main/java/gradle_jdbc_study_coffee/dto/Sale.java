package gradle_jdbc_study_coffee.dto;

public class Sale {
	private int no;
	private String code;	//제품코드
	private int price;	//제품단가
	private int saleCnt;	//판매수량
	private int marginRate;		//마진율
	private SaleDetail detail;
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int no, String code, int price, int saleCnt, int marginRate, SaleDetail detail) {
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.detail = detail;
	}

	public Sale(int no, String code, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public Sale(String code) {
		this.code = code;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	public SaleDetail getDetail() {
		return detail;
	}

	public void setDetail(SaleDetail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Sale [no=" + no + ", code=" + code + ", price=" + price + ", saleCnt=" + saleCnt + ", marginRate="
				+ marginRate + ", detail=" + detail + "]";
	}
	
	
}
