/*
 * 321/2015081
 * Kargaki Maria
 * Prwth Atomikh Ergasia
 * 
 */
package icsd15081_Lab01;

public class Periodiko extends Stoixeia{

	//dhlwsh metavlhtwn
	int number;
	int magazineIssue;
	String theme;
	
	//costuctor pou periexei ton titlo kai tos etos ekdoshs pou xreiazomaste sthn Periodiko wste na ginetai elegxos kai na pernaei to titlo h to etos
	public Periodiko(String title, int year) {
		super(); 
		//elegxoi gia ta titlo kai etos
		if((title!=null || !title.equals("")) && year!=0 )
		{
			super.title=title;
			this.year = year;
		}
		else if (title!=null || !title.equals(""))
		{
			super.title=title;
		}
		else if(year!=0)
		{
			this.year = year;
		}


	}
	
	public Periodiko(String title) {
		super(title);
		
	}
	
	
	public Periodiko(int year) {
		super(year);
		
	}


	public Periodiko() { //default costructor
		
	}

	//costructor pou periexei ola ta stoixeia gia to Periodiko, overload costructor
	public Periodiko(String title, int number, int year,  int magazineIssue, String theme, int numberOfPages, int position) {
		super(title, year, numberOfPages, position);
		this.number = number;
		this.magazineIssue = magazineIssue;
		this.theme = theme;
	}
	

	
	
	@Override
	public String toString() {
		return "Periodiko: "+super.getTitle()+" Etos: "+super.getYear()+" Number: " + number + "\n MagazineIssue: " + magazineIssue + ", Theme: " + theme +"\n";
	}

	

}
