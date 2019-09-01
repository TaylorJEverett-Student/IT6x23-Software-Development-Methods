package EpicVotingSystem;

/*
 * File Name :Interface
 * author :Taylor Everett
 * Date :27/9/2017
 * Description :version 1.2
 */

public class admin 
{
	
	private int id;
    private String name;
    private String userName;
    private String passWord;
    
	public admin(int id, String name, String userName, String passWord) 
	{
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.passWord = passWord;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
}
