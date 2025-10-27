package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // use this to ranslate each line in the book
        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";
        
        // this is to split the input into words and translate each one
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result += " ";
            }
            result += translateWord(words[i]);
        }

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')"); 

        if (input.length() == 0) {
            return "";
        }
        
        // to get any punctuation at the end
        String punctuation = "";
        String cleanWord = input;

        while (cleanWord.length() > 0) {
            char lastChar = cleanWord.charAt(cleanWord.length() - 1);
            if (!isLetter(lastChar)) {
                punctuation = lastChar + punctuation;
                cleanWord = cleanWord.substring(0, cleanWord.length() - 1);
            } else {
                break;
            }
        }
        
        if (cleanWord.length() == 0) {
            return input;
        }
        
        // to remember the capitlization
        boolean firstWasCap = isUpperCase(cleanWord.charAt(0));
        String capsPattern = "";
        for (int i = 0; i < cleanWord.length(); i++) {
            if (isUpperCase(cleanWord.charAt(i))) {
                capsPattern += "Y";
            } else {
                capsPattern += "N";
            }
        }
        
        // change it to lowercase for processing
        String lowerWord = toLowerCase(cleanWord);
        
        
        int consonantCount = 0;
        for (int i = 0; i < lowerWord.length(); i++) {
            char c = lowerWord.charAt(i);
            if (isVowel(c) || c == '-') {
                break;
            }
            consonantCount++;
        }

        // Create the pig latin word
        String pigLatinWord = "";
        if (consonantCount == 0) {
            pigLatinWord = lowerWord + "ay";
        } else {
            String consonants = lowerWord.substring(0, consonantCount);
            String rest = lowerWord.substring(consonantCount);
            pigLatinWord = rest + consonants + "ay";
        }

        // Add capitalization
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
                // "ay" suffix stays lowercase
                result = result + c;
            }
        }
        
        return result + punctuation;
    }
    
    // additional helper methods
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
    
    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
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





