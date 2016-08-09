package entity;

public class UserEntity {
	private String uid;
	private String upw;
	private String uname;
	private String uemail;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(String uid,String upw,String uname,String uemail){
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	
}
