import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;


public class Artist  extends final1
{
			
		//String sparqlQuery;
		
		//Scanner reader1 = new Scanner(System.in);
		//System.out.println("Enter the Artist:");
		//String input1 = reader1.nextLine();
		
	static void call(String input1)
	{
		String fileName ="D:\\Ranjani\\Docs\\sem 1\\musicassistant.owl";
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		model.setNsPrefix("owl", OWL.getURI());
		model.setNsPrefix("rdf", RDF.getURI());
		model.setNsPrefix("rdfs", RDFS.getURI());
		model.setNsPrefix("ma", "http://www.semanticweb.org/rschet/ontologies/2014/10/MusicAssistant#");
		try {
			File file = new File(fileName);
			FileInputStream reader = new FileInputStream(file);
			model.read(reader,null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	Map<Integer, albumList> genre_heuristic_akon = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_eminem = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_ladygaga = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_katyperry = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_michaeljackson = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_shakira = new HashMap<Integer,albumList>();
	Map<Integer, albumList> genre_heuristic_enriqueiglesias = new HashMap<Integer,albumList>();
	
	albumList RB = new albumList();
	RB.setGenere("R&B");
	Map<Integer,String> alb = new HashMap<Integer,String>();
	alb.put(1,"Konvicted");
	alb.put(2,"Trouble");
	alb.put(3,"Freedom");
	alb.put(4, "Insomaniac");
	RB.setAlbums((Map<Integer, String>) greedySortingGenre(alb));
	
	
	albumList Hiphop = new albumList();
	Hiphop.setGenere("Hiphop");
	Map<Integer,String> alb1 = new HashMap<Integer,String>();
	alb1.put(1,"Encore");
	alb1.put(7,"Relapse");
	alb1.put(8,"Recovery");
	Hiphop.setAlbums((Map<Integer, String>) greedySortingGenre(alb1));
	
	
	albumList pop = new albumList();
	pop.setGenere("Pop");
	Map<Integer,String> alb2 = new HashMap<Integer,String>();
	alb2.put(1,"Invincible");
	alb2.put(9,"Escape");
	alb2.put(10,"Freedom");
	pop.setAlbums((Map<Integer, String>) greedySortingGenre(alb2));
	
	albumList Reggae = new albumList();
	Reggae.setGenere("Reggae");
	Map<Integer,String> alb3 = new HashMap<Integer,String>();
	alb3.put(1,"Trouble");
    Reggae.setAlbums((Map<Integer, String>) greedySortingGenre(alb3));
    
    albumList Dancepop = new albumList();
	Dancepop.setGenere("Dancepop");
	Map<Integer,String> alb4 = new HashMap<Integer,String>();
	alb4.put(1,"The_Fame");
	alb4.put(2,"Born_this_way");
	alb4.put(3,"Invincible");
	alb4.put(4,"Prism");
	Dancepop.setAlbums((Map<Integer, String>) greedySortingGenre(alb4));
	
	albumList Jazz = new albumList();
	Jazz.setGenere("Jazz");
	Map<Integer,String> alb5 = new HashMap<Integer,String>();
	alb5.put(1,"Cheek_to_Cheek");
    Jazz.setAlbums((Map<Integer, String>) greedySortingGenre(alb5));
    
    albumList Disco = new albumList();
	Disco.setGenere("Disco");
	Map<Integer,String> alb6 = new HashMap<Integer,String>();
	alb6.put(1,"Prism");
	alb6.put(2, "Teenage_Dream");
    Disco.setAlbums((Map<Integer, String>) greedySortingGenre(alb6));
    
    albumList Poprock  = new albumList();
	Poprock.setGenere("Poprock");
	Map<Integer,String> alb7 = new HashMap<Integer,String>();
	alb7.put(1,"Laundry_Service");
	Poprock.setAlbums((Map<Integer, String>) greedySortingGenre(alb7));
	
	albumList Latinpop  = new albumList();
	Latinpop.setGenere("Latinpop");
	Map<Integer,String> alb8 = new HashMap<Integer,String>();
	alb8.put(1,"Insomaniac");
	Latinpop.setAlbums((Map<Integer, String>) greedySortingGenre(alb8));
	
	
	genre_heuristic_akon.put(1, RB);
	genre_heuristic_akon.put(2, Hiphop);
	genre_heuristic_akon.put(7, Reggae);
	genre_heuristic_akon.put(3, pop);
	genre_heuristic_eminem.put(1, Hiphop);
	genre_heuristic_ladygaga.put(1, Dancepop);
	genre_heuristic_ladygaga.put(2, Jazz);
	genre_heuristic_katyperry.put(1, Disco);
	genre_heuristic_katyperry.put(7, pop);
	genre_heuristic_katyperry.put(8, Hiphop);
	genre_heuristic_katyperry.put(6, Dancepop);
	genre_heuristic_michaeljackson.put(1, pop);
	genre_heuristic_michaeljackson.put(2, Dancepop);
	genre_heuristic_michaeljackson.put(3, RB);
	genre_heuristic_shakira.put(1, Poprock);
	genre_heuristic_shakira.put(2, pop);
	genre_heuristic_enriqueiglesias.put(1, Latinpop);
	genre_heuristic_enriqueiglesias.put(12, pop);
	genre_heuristic_enriqueiglesias.put(4, RB);
	
	//printMap(greedySortingArtist(genre_heuristic_akon));
	
	int min = 1;
	
	Tree Akon = new Tree("Akon",greedySortingArtist(genre_heuristic_akon));
	Tree Eminem = new Tree("Eminem",greedySortingArtist(genre_heuristic_eminem));
	Tree Ladygaga = new Tree("Ladygaga",greedySortingArtist(genre_heuristic_ladygaga));
	Tree Katyperry = new Tree("Katyperry",greedySortingArtist(genre_heuristic_katyperry));
	Tree Shakira = new Tree("Shakira",greedySortingArtist(genre_heuristic_shakira));
	Tree Michaeljackson = new Tree("Michaeljackson",greedySortingArtist(genre_heuristic_michaeljackson));
	Tree Enriqueiglesias = new Tree("Enriqueiglesias",greedySortingArtist(genre_heuristic_enriqueiglesias));
	
	//int temp;
	List<Tree> artists = new ArrayList<Tree>();
	artists.add(Akon);
	artists.add(Eminem);
    artists.add(Ladygaga);	
	artists.add(Katyperry);
	artists.add(Shakira);
	artists.add(Michaeljackson);
	artists.add(Enriqueiglesias);
	
    String input = input1;
    String new1;
	for(Tree artist : artists)
	{
		if(input.equalsIgnoreCase(artist.getArtist()))
		{
			System.out.println("Artist :" + artist.getArtist());
			for (Map.Entry<Integer, albumList> entry :artist.getGenre_heuristic().entrySet())
			{
				if(min==entry.getKey())
				{
					albumList albm = (albumList) entry.getValue();
					System.out.println("Genre :" + albm.getGenere());
					Map<Integer, String> albums = albm.getAlbums();
					for(Map.Entry<Integer, String> album :albums.entrySet() )
					{
						if(album!=null && min==album.getKey()){
						System.out.println("Album :" + album.getValue());
						new1 = album.getValue();
					
	//System.out.println("Enter the Album:");
	//String input2 = reader1.nextLine();
	//reader1.close();
	
	String sparqlQuery = //"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
			 //"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
			 //"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
			 //"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
			"PREFIX ma: <http://www.semanticweb.org/rschet/ontologies/2014/10/MusicAssistant#>\n"
				+ "SELECT ?subject  WHERE { ?subject ma:IsListedinAlbum ma:"+new1+" . } "; 
	Query query = QueryFactory.create(sparqlQuery);
	QueryExecution qe = QueryExecutionFactory.create(query,model);
	
	// Method to display the result on the console
	ResultSet results = qe.execSelect();
	
	//ResultSetFormatter.out(System.out, results, query);
	
	while (results.hasNext())
	{
		QuerySolution qs = results.nextSolution();
		//System.out.println("Inside while");
		System.out.println(qs.getResource("subject"));
		
		RDFNode r = qs.get("subject"); //convert the result from the query into an RDFNode
		if (r.isURIResource())			//only one RDFNode can be created for each variable in the query
		{
			//System.out.println("URI Resource");
		}
		else if (r.asNode().isBlank())	//logic to traverse blank nodes
			{							//blank node is a pointer to another blank or non-blank node
				Node n = r.asNode();
				//int counter = 0;
				while (n.isBlank()){
					StmtIterator stmts = model.listStatements(null,null,r);
					while (stmts.hasNext()){
						Statement st = stmts.nextStatement();
						if (!st.getSubject().asNode().isBlank())
							{
								System.out.println("Subject : "+st.getSubject().toString());
								//System.out.println("Predicate : "+st.getPredicate().toString());
							}
						r = st.getSubject().asResource();
						n = r.asNode();
					}
				}
			}
		}
						}
	}
	        }
	    }
	}
	}
}
	
	
	
	
	public static Map<Integer, String> greedySortingGenre(Map<Integer, String> heuristic)
	{
		Map<Integer, String> treeMap = new TreeMap<Integer, String>(
				new Comparator<Integer>() 
				{
	 
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
	 
			});
			treeMap.putAll(heuristic);
			//printMap1(treeMap);
			return treeMap;
	}
	public static Map<Integer, albumList> greedySortingArtist(Map<Integer, albumList> heuristic)
	{
		TreeMap<Integer, albumList> treeMap = new TreeMap<Integer, albumList>(
				new Comparator<Integer>()
				{
	 
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return o2.compareTo(o1);
				}
	 
			});
			treeMap.putAll(heuristic);
			return treeMap;
	}
	public static void main(String args[])
	{

		
		String fileName ="D:\\Ranjani\\Docs\\sem 1\\musicassistant.owl";
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		model.setNsPrefix("owl", OWL.getURI());
		model.setNsPrefix("rdf", RDF.getURI());
		model.setNsPrefix("rdfs", RDFS.getURI());
		model.setNsPrefix("ma", "http://www.semanticweb.org/rschet/ontologies/2014/10/MusicAssistant#");
		try {
			File file = new File(fileName);
			FileInputStream reader = new FileInputStream(file);
			model.read(reader,null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Scanner reader1 = new Scanner(System.in);
		//System.out.println("Enter the Genre:");
		//String input = reader1.nextLine();
		//artistheu ah = new artistheu();

			
			//reader1.close();
			//Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("\nWhat would you like to base your search on?:\n 1. Artist\n 2. Year\n 3. Exit");
				int choice=reader1.nextInt();
				switch(choice)
				{
				case 1: System.out.println("\nEnter the Artist name:\n1.Eminem\n2.Michael Jackson\n3.Enrique Iglesias\n4.Katy Perry\n5.Akon\n6.Lady Gaga\n7.Shakira");
				        String artist = reader1.next();
				        call(artist);
				        break;
				case 2: System.out.println("\nEnter the Year value(From 2001 to 2014):");
				        int year = reader1.nextInt();
				        final1 f1 = new final1();
				        List<secondlevel> val = f1.call(year);
				      	System.out.println("Songs in the 'Album with highest rating:' ");
				    	for(secondlevel a : val)
				    	{
				    		System.out.println(a.getArtist()+" \n" + a.getAlbum());
				    		String sparqlQuery = //"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
				    				 //"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
				    				 //"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
				    				 //"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
				    				"PREFIX ma: <http://www.semanticweb.org/rschet/ontologies/2014/10/MusicAssistant#>\n"
				    					+ "SELECT ?subject  WHERE { ?subject ma:IsListedinAlbum ma:"+a.getAlbum()+" . } "; 
				    		Query query = QueryFactory.create(sparqlQuery);
				    		QueryExecution qe = QueryExecutionFactory.create(query,model);
				    		
				    		// Method to display the result on the console
				    		ResultSet results = qe.execSelect();
				    		
				    		//ResultSetFormatter.out(System.out, results, query);
				    		
				    		while (results.hasNext())
				    		{
				    			QuerySolution qs = results.nextSolution();
				    			//System.out.println("Inside while");
				    			System.out.println(qs.getResource("subject"));
				    			
				    			RDFNode r = qs.get("subject"); //convert the result from the query into an RDFNode
				    			if (r.isURIResource())			//only one RDFNode can be created for each variable in the query
				    			{
				    				//System.out.println("URI Resource");
				    			}
				    			else if (r.asNode().isBlank())	//logic to traverse blank nodes
				    				{							//blank node is a pointer to another blank or non-blank node
				    					Node n = r.asNode();
				    					//int counter = 0;
				    					while (n.isBlank()){
				    						StmtIterator stmts = model.listStatements(null,null,r);
				    						while (stmts.hasNext()){
				    							Statement st = stmts.nextStatement();
				    							if (!st.getSubject().asNode().isBlank())
				    								{
				    									System.out.println("Subject : "+st.getSubject().toString());
				    									//System.out.println("Predicate : "+st.getPredicate().toString());
				    								}
				    							r = st.getSubject().asResource();
				    							n = r.asNode();
				    						}
				    					}
				    				}
				    			}
				    		
				    	}
				    	
				        
				        break;
				case 3:System.exit(0);
				default: System.out.println("Invalid Choice!!");
				}
			}
	}			
	
}



		
		

		


/*class MyOutputStream extends OutputStream{
	StringBuffer buf;
	public MyOutputStream (){
		buf = new StringBuffer();
	}
	public void write(int character) throws IOException{
		buf.append((char) character);
	}
	public String getString(){
		return buf.toString();
	}
} 
*/

