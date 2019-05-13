package be.unamur.mdl_groupe2.root.synonymes;

import rita.RiWordNet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Synonymes {

   public static List<String> getSyno(String texte) throws FileNotFoundException {
       texte = Synonymes.removeStopWords(texte);
       List<String> synonymes = new ArrayList<String>();
       List<String> texteArray = Synonymes.StringToStringArray(texte);
       String[] synonymesTab;

       RiWordNet rw = new RiWordNet("WordNet-3.0/");
       rw.randomizeResults(false);

       for (String s : texteArray) {
           synonymesTab = rw.getSynset(s, "n");
           Collections.addAll(synonymes, synonymesTab);
       }
       return synonymes;
    }

    private static List<String> StringToStringArray(String texte) {
       String[] txt = texte.split(" ");
       List<String> texteArray = new ArrayList<String>();
       Collections.addAll(texteArray, txt);
       return texteArray;
    }

    private static String removeStopWords(String texte) throws FileNotFoundException {

        List<String> ls = new ArrayList<String>();
        File file = new File("stopWords.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            ls.add(input.next());
        }

        List<String> texteArray = Synonymes.StringToStringArray(texte.toLowerCase());

        for (String l : ls) {
            for (int j = 0; j < texteArray.size(); j++) {
                if (texteArray.get(j).equals(l)) {
                    texteArray.remove(j);
                }
            }
        }

        String texteChecked = String.join(" ", texteArray);

        return texteChecked;
    }
}
