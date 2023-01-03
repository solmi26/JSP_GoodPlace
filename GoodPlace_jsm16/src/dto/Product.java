package dto;


//Product라는 클래스. 자바빈 객체
public class Product {
	
	
	private int p_id;
	private String p_category;
	private String p_title;
	private int p_price;
	private String p_period;
	private String p_inst;
	private String p_desc;
	private String p_img;

	public Product() {
		super();
	
	}
	public Product(int p_id, String p_category, String p_title, int p_price, String p_period, String p_inst,
			String p_desc, String p_img) {
		super();
		this.p_id = p_id;
		this.p_category = p_category;
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_period = p_period;
		this.p_inst = p_inst;
		this.p_desc = p_desc;
		this.p_img = p_img;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_period() {
		return p_period;
	}
	public void setP_period(String p_period) {
		this.p_period = p_period;
	}
	public String getP_inst() {
		return p_inst;
	}
	public void setP_inst(String p_inst) {
		this.p_inst = p_inst;
	}
	public String getP_desc() {
		return p_desc;
	}
	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	
	

	
	

	

}
