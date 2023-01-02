/*
 * 321/2015081
 * Kargaki Maria
 * Prwth Atomikh Ergasia
 * 
 */

package icsd15081_Lab01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Util {

    public void writeTofile(Stoixeia s) { //synarthsh h opoia grafei sto arxeio

        File f = new File("file.txt"); //shmiourgia arxeiou
        if (f.exists()) { //ean to arxeio yparxei
            FileOutputStream fd = null; 
            ObjectOutputStream os = null; 
            try {
                fd = new FileOutputStream("file.txt", true); // ti tha grapsei, dhmiourgia rohs pros to arxeio
                os = new ObjectOutputStream(fd) {// pou tha grapsei, to kanoume gia na mporeoume na filtraroumr to arxeio gia na diavasei ta antikeimena mesw serializable
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };

                os.writeObject(s); //grafei sto arxeio ksi pernaei san parametro ena antikeimeno typou stoixeio

                os.flush(); //katharizei ton buffer meta apo kathe eggrafh
                
                fd.close();
                os.close(); //kleinoume to arxio

            } catch (IOException e) {
                System.out.println(e);

            }

        } else {
            FileOutputStream fd = null;
            ObjectOutputStream os = null;
            try { //block try catch
                fd = new FileOutputStream("file.txt"); //dhmiourgia rohs pros to arxeio
                os = new ObjectOutputStream(fd) {// pou tha grapsei to kanoume gia na mporeoume na filtraroumr to arxeio gia na diavasei ta antikeimena mesw serializable

                };

                os.writeObject(s);

                os.flush();
                fd.close();
                os.close();

            } catch (IOException e) {
                System.out.println(e);

            }

        }

    }

    public ArrayList<Stoixeia> readFromfile(Stoixeia s) { //synarthsh h opoia diavazei apo to arxeio ta periodkia kai ta vivlia pou exoun kataxwrithei
        FileInputStream fi = null;
        ObjectInputStream ob = null;
        ArrayList<Stoixeia> list = new ArrayList<>(); //dhmiourgia arraylist


        try {
            fi = new FileInputStream("file.txt");
            ob = new ObjectInputStream(fi);

            while (ob != null && fi.available() != 0) { //oso den einai einai keno to arxeio
                Stoixeia stoixeia; //metavlhth tupou stoixeia
                stoixeia = (Stoixeia) ob.readObject();

                if (s instanceof Vivlio) { //ginetai sygkrish 
                    if (stoixeia.getTitle().equals(s.getTitle())) { //ki an o titlos  einai idios me afton pou dinei o xrhsths
                        list.add(stoixeia); //tote apothikeyetsai sth lista

                    } else if (((Vivlio) s).ISBN.equals(((Vivlio) stoixeia).ISBN)) { //an o kwdikos isbn pou exei kataxwrithei einai idios me afton pou dinei 
                        list.add(stoixeia); //tote prosthetei sth lista ta stoixeia
                    }

                } 
                else if (s instanceof Periodiko) { //to idio kai gia otan einai periodiko
                    if (stoixeia.getTitle().equals(s.getTitle())) {
                        list.add(stoixeia);

                    } else if (stoixeia.getYear() == s.getYear()) {
                        list.add(stoixeia);
                    }

                }


            }
            ob.close(); //kleinei to arxeio
        } catch (IOException e) {
        	


        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list; //epistrefei thn lista

    }

    public ArrayList<Stoixeia> search(Stoixeia s) { //dhmiouria synarthshsh typou arraylist <Stoixeia> h opoia pairnei parametro mia metavlhth stoixea

        ArrayList<Stoixeia> eggrafes = null; //dhlws arraylist

        if (s instanceof Periodiko) { //ginetai sygkrish kaiean afto pou tha dwsei o xrhsths gia anazhthsh einai idio me afto pou exei kataxwrhthtei sto periodiko
            s = new Periodiko(s.getTitle(), s.getYear()); //pairnei ton titlo kai to etos ekdoshs gia to periodiko

            eggrafes = new ArrayList<>(readFromfile(s)); //kai diavazri apo to arxeio tis eggrafes pou exoun kataxwrithei

        } else if (s instanceof Vivlio) {//ginetai sygkrish kaiean afto pou tha dwsei o xrhsths gia anazhthsh einai idio me afto pou exei kataxwrhthtei sto vivlio

            s = new Vivlio(s.getTitle(), ((Vivlio) s).getISBN()); //ainrei ton tilto kai to isbn an einai vivlio
            eggrafes = new ArrayList<>(readFromfile(s)); //kai diavazri apo to arxeio tis eggrafes pou exoun kataxwrithei

        }

        return eggrafes; //epistrefei tis eggrafes

    }
}
