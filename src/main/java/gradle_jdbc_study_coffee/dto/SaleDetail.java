package gradle_jdbc_study_coffee.dto;

public class SaleDetail {
	//공급가액, 부가세액, 판매금액, 마진액
	private int supplytax;
	private int addtax;
	private int saleprice;
	private int marginprice;
	
	//생성자
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}

	public SaleDetail(int supplytax, int addtax, int saleprice, int marginprice) {
		this.supplytax = supplytax;
		this.addtax = addtax;
		this.saleprice = saleprice;
		this.marginprice = marginprice;
	}

	//getter, setter
	
	public int getSupplytax() {
		return supplytax;
	}

	public void setSupplytax(int supplytax) {
		this.supplytax = supplytax;
	}

	public int getAddtax() {
		return addtax;
	}

	public void setAddtax(int addtax) {
		this.addtax = addtax;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getMarginprice() {
		return marginprice;
	}

	public void setMarginprice(int marginprice) {
		this.marginprice = marginprice;
	}

	
	//toString
	@Override
	public String toString() {
		return "SaleDetail [supplytax=" + supplytax + ", addtax=" + addtax + ", saleprice=" + saleprice
				+ ", marginprice=" + marginprice + "]";
	}
	
	
	
}
