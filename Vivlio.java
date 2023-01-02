/*
 * 321/2015081
 * Kargaki Maria
 * Prwth Atomikh Ergasia
 * 
 */

package icsd15081_Lab01;

public class Vivlio extends Stoixeia { //klhronomei apo thn Stoixeia

	String ISBN;
	String writter;
	String description, kind;
	

	
	public Vivlio() { //default costructor

	}
	
		//overload costructor pou periexei ola ta stoixeia tou vivliou
	public Vivlio(String title, int year, int numberOfPages, int position, String iSBN, String writter, String description, String kind) {
		super(title, year, numberOfPages, position);
		this.ISBN = iSBN;
		this.writter = writter;
		this.description = description;
		this.kind = kind;
	}
	
	
	//elgxos to otan dwsoume titlo h isbn gia anazhthsh vivliou kai na mas to emfanisei analoga me to gnwrisma
	public Vivlio(String title, String ISBN) {

		super();
		if((title!=null || !title.equals("")) && (ISBN!=null || !ISBN.equals("")))
		{
			super.title=title;
			this.ISBN = ISBN;
		}
		else if (title!=null || !title.equals(""))
		{
			super.title=title;
		}
		else if(ISBN!=null || !ISBN.equals(""))
		{
			this.ISBN = ISBN;
		}

	}
	public Vivlio(String title) {
		super(title);
		

	}
	

	public String getISBN() {//getter gia to isbn
		return ISBN;
	}


	@Override
	public String toString() {  //methodos  toString
		return "Titlos: "+super.title+" ISBN: " + ISBN + ", Writter: \n" + writter + ", Description: " + description + ", Kind: " + kind+"\n";
	}
	

}
