import java.util.*;

public class StringUtils {
    public static int countVowels(String str){
        if (str == null)
            return 0;

        String vowels = "aeiou";
        int count = 0;
        for (char ch: str.toLowerCase().toCharArray()){
            if (vowels.indexOf(ch) != -1){
                count++;
            }
        }
        return count;
    }

    public static String reverseString(String str){
        if (str == null)
            return "";

        StringBuilder finalString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            finalString.append(str.charAt(i));
        }
        return finalString.toString();
    }

    public static String reverseWords(String str){
        if (str == null)
            return "";

        String[] strArray = str.trim().split(" ");
        StringBuilder reversedString = new StringBuilder();

        for (int i = strArray.length - 1; i >= 0; i--){
            reversedString.append(strArray[i]).append(" ");
        }

        return reversedString.toString().trim();
    }

    public static boolean areRotations(String str1, String str2){
        if (str1 == null || str2 == null)
            return false;

        if (str1.length() != str2.length())
            return false;

        if (!(str1+str2).contains(str2))
            return false;

        return true;
    }

    public static String removeDuplicates(String str){
        if (str == null)
            return "";
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char ch: str.toCharArray()){
            if(!seen.add(ch)){
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccuringChar(String str){
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char ch: str.toCharArray()){
            if (frequencies.containsKey(ch)){
                frequencies.replace(ch, frequencies.get(ch)+1);
            }
            else
                frequencies.put(ch, 1);
        }


        char maxChar = '\0';
        int maxCount = -1;

        for (Map.Entry<Character, Integer> entry: frequencies.entrySet()){
            if (entry.getValue() > maxCount){
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxChar;
    }

    public static String capitalize(String sentence){
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence.trim().replaceAll(" +", " ").split(" ");

        for (var i = 0; i < words.length; i++){
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second){
        if (first == null || second == null || first.length() != second.length())
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean areAnagram2(String first, String second){
        if (first == null || second == null || first.length() != second.length())
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (var i =0; i < first.length(); i++){
            frequencies[first.charAt(i) - 'a']++;
        }

        second = second.toLowerCase();
        for (var i =0; i < second.length(); i++){
            if (frequencies[second.charAt(i) - 'a'] == 0)
                return false;
            frequencies[second.charAt(i) - 'a']--;
        }

        return true;
    }

    public static boolean isPalindrome(String word){
        if (word == null)
            return false;

        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }
}
