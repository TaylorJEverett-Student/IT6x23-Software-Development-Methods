package EpicVotingSystem;

/*
 * File Name :Interface
 * author :Taylor Everett
 * Date :27/9/2017
 * Description :version 1.2
 */
public class Candidate
{
    int candidateCode = 999;//999 is not an eligible candidate
    String name = null;
    int votes = 0; //total votes

    //constructor
    public Candidate(int candidateCode, String name, int votes)
    {
        this.candidateCode = candidateCode;
        this.name = name;
        this.votes = votes;
    }

    public int getCandidateCode ()
    {
        return candidateCode;
    }

    public String getName()
    {
        return  name;
    }

    public int getVotes()
    {
        return  votes;
    }

    public void addVote()
    {
        votes++;
    }

}