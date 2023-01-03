package dto;

public class Member {
	private String m_id;
	private String m_pw;
	private String m_phone;
	private String m_email;
	private String m_nickname;
	private int m_class = 1;
	
	public Member() {
		super();
	}

	public Member(String m_id, String m_pw, String m_phone, String m_email, String m_nickname, int m_class) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_nickname = m_nickname;
		this.m_class = m_class;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public int getM_class() {
		return m_class;
	}

	public void setM_class(int m_class) {
		this.m_class = m_class;
	}
	
	
	
}
