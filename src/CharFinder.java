import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public static char findFirstNonRepeatedChar(String inputString){
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: inputString.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);

        for (char i: map.keySet()){
            if (map.get(i) == 1){
                System.out.println(i);
                return i;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String inputString){
        Set<Character> set = new HashSet<>();

        for (char ch: inputString.toCharArray()){
            if (set.contains(ch)){
                return ch;
            } else {
                set.add(ch);
            }
        }
        return Character.MIN_VALUE;
    }
}
