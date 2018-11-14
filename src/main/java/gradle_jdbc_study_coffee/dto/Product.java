package gradle_jdbc_study_coffee.dto;

public class Product {
	//product 테이블 => 제품코드, 제품명
	private String code;
	private String name;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Product(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + "]";
	}
	
	
}
