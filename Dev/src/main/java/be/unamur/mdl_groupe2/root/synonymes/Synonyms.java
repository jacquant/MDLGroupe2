package be.unamur.mdl_groupe2.root.synonymes;

import rita.RiWordNet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * The type Synonyms.
 */
public class Synonyms {

    /**
     * Gets synonyms.
     *
     * @param text the text
     * @return the synonyms
     * @throws FileNotFoundException the file not found exception
     */
    public static List<String> getSynonyms(String text) throws FileNotFoundException {
        text = Synonyms.removeStopWords(text);
        List<String> synonyms = new ArrayList<>();
        List<String> textArray = Synonyms.StringToStringArray(text);
        String[] synonymsTab;

        RiWordNet rw = new RiWordNet("WordNet-3.0/");
        rw.randomizeResults(false);

        for (String s : textArray) {
            synonymsTab = rw.getSynset(s, "n");
            Collections.addAll(synonyms, synonymsTab);
        }
        return synonyms;
    }

    private static List<String> StringToStringArray(String text) {
        String[] txt = text.split(" ");
        List<String> textArray = new ArrayList<>();
        Collections.addAll(textArray, txt);
        return textArray;
    }

    public static String removeStopWords(String text) throws FileNotFoundException {

        List<String> ls = new ArrayList<>();
        File file = new File("stopWords.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            ls.add(input.next());
        }

        List<String> textArray = Synonyms.StringToStringArray(text.toLowerCase());

        for (String l : ls) {
            for (int j = 0; j < textArray.size(); j++) {
                if (textArray.get(j).equals(l)) {
                    textArray.remove(j);
                }
            }
        }

        return String.join(" ", textArray);
    }
}
