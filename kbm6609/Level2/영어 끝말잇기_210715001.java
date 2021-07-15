package Word_Chain_In_English;

import java.util.HashSet;

public class WordChainInEnglish_210715001 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n= 3;

        int[] answer =new int[2];
        HashSet<String> hs = new HashSet<>();
        char ch = words[0].charAt(words[0].length() - 1);
        hs.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (ch != words[i].charAt(0) || hs.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            ch = words[i].charAt(words[i].length() - 1);
            hs.add(words[i]);
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
