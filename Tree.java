import java.util.Map;



public class Tree {

	
	String Artist; 
	Map<Integer, albumList> genre_heuristic;
	
	public Tree(String artist,Map<Integer, albumList>genre_heuristic ) 
	{
		this.Artist = artist;
		this.genre_heuristic = genre_heuristic;
		
	}

	public String getArtist() 
	{
		return Artist;
	}

	public void setArtist(String artist) 
	{
		Artist = artist;
	}

	public Map<Integer, albumList> getGenre_heuristic() 
	{
		return genre_heuristic;
	}

	public void setGenre_heuristic(Map<Integer, albumList> genre_heuristic) 
	{
		this.genre_heuristic = genre_heuristic;
	}
	
}
