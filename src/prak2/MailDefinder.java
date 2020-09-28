package prak2;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class MailDefinder {
//    private static final String EXAMPLE_TEST =
//            "На дворе — трава, betmen2000@inbox.ruc на траве — дрова. Не руби дрова на траве двора! betmen2000@inbox.ru";
//    public static void main(String[] args) {
//
//
//        Pattern pattern =
//                Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", Pattern.UNICODE_CHARACTER_CLASS
//                        | Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
//        SortedSet<String> words = new TreeSet<>();
//
//        while (matcher.find())
//            words.add(matcher.group().toLowerCase());
//
//        for (String word : words)
//            System.out.println("mail = " + word);
//    }
//}

    public class MailDefinder {
        public static final int START = 0;
        public static final int DOG= 1;
        public static final int DIGIT1 = 2;
        public static final int DOT1 = 3;
        public static final int DIGIT2 = 4;

        public static void main(String[] args) {
            List<Character> digits = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
            Set<Integer> endStates = Collections.singleton(5);
            StateMachine sm = new StateMachine(0, endStates);
            sm.add(0, digits, 1);
            sm.add(1, digits, 1);
            sm.add(1, '@', 2);
            sm.add(2, digits, 3);
            sm.add(3, digits, 3);
            sm.add(3, '.', 4);
            sm.add(4, digits, 5);
            sm.add(5, digits, 5);

//            sm.add(START, digits, DOG);
//            sm.add(DOG, '@', DIGIT1);
//            sm.add(DIGIT1, digits, DOT1);
//            sm.add(DOT1, '.', DIGIT2);
//            sm.add(DIGIT2, digits, DIGIT2);
// Поиск всех вхождений в строке:
            String str = "abba 01.01.2017 x@7.78 x@7.79@@z@@@@zy a@a7.a @ 02.02.2017 aa@aa.aa   assda@as.ae";
            sm.findAll(str);
        }
    }
