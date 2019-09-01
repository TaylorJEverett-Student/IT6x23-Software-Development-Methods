package EpicVotingSystem;

/*
 * File Name :Interface
 * author :Taylor Everett
 * Date :27/9/2017
 * Description :version 1.2
 */

public class Staff
{
    private int id;
    private String name;
    private int voted; //has the staff voted or not ?
    private String password;
    private String date;

    public Staff(int id, String name, int voted, String password, String date)
    {
            this.id = id;
            this.name = name;
            this.voted = voted;
            this.password = password;
            this.date = date;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setVoted()
    {
        this.voted = 1;
    }
    public void setExpireVote()
    {
        this.voted = 2;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }
    
    public void setDate(String date)
    {
    	this.date = date;
    }

    public int getId()
    {
    	return id;
    }

    public String getName()
    {
    	return name;
    }

    public int hasVoted()
    {
    	return voted;
    }
    
    public String getPassword()
    {
    	return password;
    }
    
    public String getDate()
    {
    	return date;
    }

}

