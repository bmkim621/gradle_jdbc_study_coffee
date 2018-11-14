package gradle_jdbc_study_coffee.dto;

public class Product {
	//product 테이블 => 제품코드, 제품명
	private String code;
	private String name;
	
	//생성자 만들기
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pCode, String pName) {
		this.code = pCode;
		this.name = pName;
	}

	public Product(String pCode) {
		this.code = pCode;
	}

	//getter, setter
	public String getpCode() {
		return code;
	}

	public void setpCode(String pCode) {
		this.code = pCode;
	}

	public String getpName() {
		return name;
	}

	public void setpName(String pName) {
		this.name = pName;
	}

	//toString
	@Override
	public String toString() {
		return "product [pCode=" + code + ", pName=" + name + "]";
	}
}
