package dto;

import java.sql.Timestamp;

public class OrderList {
	private int o_id;
	private String m_id;
	private int p_id;
	private Timestamp o_date;
	
	public OrderList() {
		super();
	}

	public OrderList(int o_id, String m_id, int p_id, Timestamp o_date) {
		super();
		this.o_id = o_id;
		this.m_id = m_id;
		this.p_id = p_id;
		this.o_date = o_date;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Timestamp getO_date() {
		return o_date;
	}

	public void setO_date(Timestamp o_date) {
		this.o_date = o_date;
	}

	
	
	
}
