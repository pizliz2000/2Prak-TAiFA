package prak2;


import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailDefinder {
    private static final String EXAMPLE_TEST =
            "На дворе — трава, betmen2000@inbox.ruc на траве — дрова. Не руби дрова на траве двора! betmen2000@inbox.ru";
    public static void main(String[] args) {


        Pattern pattern =
                Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        SortedSet<String> words = new TreeSet<>();

        while (matcher.find())
            words.add(matcher.group().toLowerCase());

        for (String word : words)
            System.out.println("mail = " + word);
    }
}
