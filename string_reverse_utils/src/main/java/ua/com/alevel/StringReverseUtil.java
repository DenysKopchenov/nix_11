package ua.com.alevel;

public class StringReverseUtil {
    private static final String DOES_NOT_CONTAINS_WORD = "'%s' does not contains word '%s'";
    private static final String DOES_NOT_CONTAINS_SYMBOL = "'%s' does not contains symbol '%s'";
    public static String reverse(String source) {
        StringBuilder builder = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i--) {
            builder.append(source.charAt(i));
        }
        return builder.toString();
    }

    public static String reverseEachWord(String input) {
        String[] eachWord = input.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : eachWord) {
            builder.append(StringReverseUtil.reverse(word)).append(" ");
        }
        return builder.toString().strip();
    }

    public static String reverseFirstMatchedWord(String source, String word) throws Exception {
        String[] eachWord = source.split(" ");
        if (checkContainsSingleWord(source, word)) {
            for (int i = 0; i < eachWord.length; i++) {
                if (eachWord[i].equals(word)) {
                    eachWord[i] = StringReverseUtil.reverse(word);
                    break;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (String s : eachWord) {
                builder.append(s).append(" ");
            }
            return builder.toString().strip();
        } else {
            throw new Exception(String.format(DOES_NOT_CONTAINS_WORD, source, word));
        }
    }

    public static String reverseAllMatchedWord(String source, String word) throws Exception {
        String[] eachWord = source.split(" ");
        if (checkContainsSingleWord(source, word)) {
            for (int i = 0; i < eachWord.length; i++) {
                if (eachWord[i].equals(word)) {
                    eachWord[i] = StringReverseUtil.reverse(word);
                }
            }
            StringBuilder builder = new StringBuilder();
            for (String s : eachWord) {
                builder.append(s).append(" ");
            }
            return builder.toString().strip();
        } else {
            throw new Exception(String.format(DOES_NOT_CONTAINS_WORD, source, word));
        }
    }

    public static String reverseFromIndex(String source, int index) {
        String toReverse = source.substring(index);
        String reversed = reverse(toReverse);
        return source.replace(toReverse, reversed);
    }

    public static String reverseFromToIndex(String source, int start, int end) {
        String toReverse = source.substring(start, end + 1);
        String reversed = reverse(toReverse);
        return source.replace(toReverse, reversed);
    }

    public static String reverseFromSymbol(String source, String start) throws Exception {
        if (source.contains(start)) {
            return reverseFromIndex(source, source.indexOf(start));
        } else {
            throw new Exception(String.format(DOES_NOT_CONTAINS_SYMBOL, source, source));
        }
    }

    public static String reverseFromToSymbol(String source, String start, String end) throws Exception {
        if (source.contains(start) && source.contains(end)) {
            return reverseFromToIndex(source, source.indexOf(start), source.indexOf(end));
        } else {
            throw new Exception(String.format("'%s' does not contains symbol '%s' or '%s'", source, start, end));
        }
    }

    public static String reverseFromWord(String source, String word) throws Exception {
        if (source.contains(word)) {
            return reverseFromIndex(source, source.indexOf(word));
        } else {
            throw new Exception(String.format(DOES_NOT_CONTAINS_WORD, source, word));
        }
    }

    public static String reverseFromToWord(String source, String start, String end) throws Exception {
        if (source.contains(start) && source.contains(end)) {
            if (source.indexOf(start) >= source.indexOf(end)) {
                throw new Exception("Start cant be after end or == end");
            } else {
                int from = source.indexOf(start);
                int to = source.indexOf(end) - 1;
                return reverseFromToIndex(source, from, to);
            }
        } else {
            throw new Exception(String.format("'%s' does not contains '%s' or '%s'", source, start, end));
        }
    }

    private static boolean checkContainsSingleWord(String source, String word) {
        String[] eachWord = source.split(" ");
        for (String s : eachWord) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
