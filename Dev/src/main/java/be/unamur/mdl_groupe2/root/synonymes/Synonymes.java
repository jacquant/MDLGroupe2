package be.unamur.mdl_groupe2.root.synonymes;

import rita.RiWordNet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Synonymes {

    public static HashMap<String, String[]> getSyno(String texte) throws FileNotFoundException {

        texte = Synonymes.removeStopWords(texte);

        HashMap<String, String[]> synonymes = new HashMap<String, String[]>();

        List<String> texteArray = Synonymes.StringToStringArray(texte);

        RiWordNet rw = new RiWordNet("/Users/maximevanspeybroeck/Documents/MDLGroupe2/Dev/src/main/java/be/unamur/mdl_groupe2/root/synonymes/WordNet-3.0");
        rw.randomizeResults(false);

        for(int i=0;i<texteArray.size();i++) {
            synonymes.put(texteArray.get(i), rw.getSynset(texteArray.get(i), "n"));
        }

        return synonymes;

    }

    public static List<String> StringToStringArray(String texte) {
        String[] txt = texte.split(" ");
        List<String> texteArray = new ArrayList<String>();
        for(int k=0;k<txt.length;k++) {
            texteArray.add(txt[k]);
        }
        return texteArray;
    }

    public static String removeStopWords(String texte) throws FileNotFoundException {

        List<String> ls = new ArrayList<String>();
        File file = new File("/Users/maximevanspeybroeck/Documents/MDLGroupe2/Dev/src/main/java/be/unamur/mdl_groupe2/root/synonymes/stopWords.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            ls.add(input.next());
        }

        List<String> texteArray = Synonymes.StringToStringArray(texte.toLowerCase());

        for(int i=0;i<ls.size();i++) {
            for(int j=0;j<texteArray.size();j++) {
                if(texteArray.get(j).equals(ls.get(i))) {
                    texteArray.remove(j);
                }
            }
        }

        String texteChecked = String.join(" ", texteArray);

        return texteChecked;
    }
}
