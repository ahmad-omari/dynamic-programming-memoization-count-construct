import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/21/2022, Friday
 * @project : dynamic-programming-memoization-count-construct
 **/
public class CountConstruct {
    public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo){
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        if (target.equals(""))
            return 1;

        int count = 0;
        for (String word : wordBank) {
            if (target.startsWith(word)){
                int numberOfWays = countConstruct(target.substring(word.length()), wordBank, memo);
                memo.put(target, numberOfWays);
                count += numberOfWays;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "ef", "abcd"}, new HashMap<>()));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }
}
