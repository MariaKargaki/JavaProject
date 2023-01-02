/*
 * 321/2015081
 * Kargaki Maria
 * Prwth Atomikh Ergasia
 * 
 */

package icsd15081_Lab01;

import java.io.Serializable;

//klash apo thn opoia klhronomoun oi klaseis periodiko kai vivlio
//h klash afth periexei ta koina stoixeia twn 2 allwn klasewn 
//epishs  kanei implements Serializable gia na mporesoume to apothikeusoume se arxeio
public class Stoixeia implements Serializable{
	
	String title;
	int year; 
	int numberOfPages;
	int position;
	
	
	public Stoixeia() { //default costructor

	}

	public Stoixeia(String title, int year, int numberOfPages, int position) { //overload costructor
		this.title = title;
		this.year = year;
		this.numberOfPages = numberOfPages;
		this.position = position;
	}

	public Stoixeia(String title, int year) { //costructor gia thn periodiko
		this.title = title;
		this.year = year;
	}
	
	
	public Stoixeia(String title) {
		this.title = title;
		
	}
	public Stoixeia( int year) {
		this.year = year;
		
	}
	//getters
	public String getTitle() {
		return title;
	}

	

	public int getYear() {
		return year;
	}

	

	
	@Override
	public String toString() { //methodos toString
		return "Stoixeia [Title: " + title + ", Year: " + year + ", NumberOfPages: " + numberOfPages + ", Position: "+ position + "]";
	}
	
	

}
