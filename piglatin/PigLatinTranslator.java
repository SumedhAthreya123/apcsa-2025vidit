package piglatin;
import java.util.Scanner;


public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')"); 

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
         // delete this line
        if (input.length() == 0) {
            return "";
        }
        // to find any punctuation
        String punctuation = "";
        String cleanWord = input;

        // to remove the puncuation
        while (cleanWord.length() > 0) {
            char lastChar = cleanWord.charAt(cleanWord.length() - 1);
            if (!isLetter(lastChar)) {
                punctuation = lastChar + punctuation;
                cleanWord = cleanWord.substring(0, cleanWord.length()-1);
            } else {
                break;
            }
        }
        
        if (cleanWord.length() == 0) {
            return input;
        }
        // to remember if first letter was capital or not
        boolean firstWasCap = isUpperCase(cleanWord.charAt(0));
        

        String capsPattern = "";
        for (int i = 0; i < cleanWord.length(); i++) {
            char c = lowerWord.charAt(i);
            if (isVowel(c) || c == "-") {
                break;
            }
            consonantCount ++;d

        }


        String pigLatinWord = "";
        if (consonantCount == 0) {
            pigLatinWord = lowerWord + "ay";
        } else {
            String consonants = lowerWord.substring(0, consonantCount);
            String rest = lowerWord.substring(consonantCount);
            pigLatinWord = rest + consonants + "ay";
        }

        String result = "";
        for (int i = 0; i < pigLatinWord.length(); i++) {
            char c = pigLatinWord.charAt(i);

            if (i == 0 && firstWasCap) {
                result = result + toUpperCase(c);
            } else if (i == 0 && !firstWasCap) {
                result = result + toLowerCase(c);
            } else if (i < pigLatinWord.length() - consonantCount - 2) {
                int originalIndex = i + consonantCount;
                if (originalIndex < capsPattern.length() && capsPattern.charAt(originalIndex) == 'Y' && originalIndex != 0) {
                    result = result + toUpperCase(c);
                } else {
                    result = result + c;
                }
            } else if (i >= pigLatinWord.length() - consonantCount - 2 && i < pigLatinWord.length() - 2) {
                int originalIndex = i - (pigLatinWord.length() - consonantCount - 2);
                if (originalIndex < capsPattern.length() && capsPattern.charAt(originalIndex) == 'Y' && originalIndex != 0) {
                    result = result + toUpperCase(c);
                } else {
                    result = result + toLowerCase(c);

                }
            } else {
                result = result + c;
            }
            return result + punctuation;
            
        }
    
    
    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)
        private static boolean isVowel(char c) {
            c = toLowerCase(c);
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        private static boolean isLetter(char c) {
            c = toLowerCase(c);
            return (c >= 'a' && c <= 'z');
        }
        private static boolean isUpperCase(char c) {
            return (c >= 'A' && c <= 'Z');
        }
        private static char toLowerCase() {
            if (c >= 'A' && c <= 'Z') {
                return (char)(c + 32);
            }   
        }
        private static String toLowerCase(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                result += toLowerCase(s.charAt(i));
            }
        return result;
        }
        private static char toUpperCase(char c) {
            if (c >= 'a' && c <= 'z') {
                return (char)(c - 32);
            }
            return c;
        }

}
}




