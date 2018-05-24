package codewars;

public class JadenCase {

    public static void main(String... args) {
        System.out.println(new JadenCase().toJCase("test  test"));
    }

    private String toJCase(String phrase) {
        String[] arr = phrase.split(" ");
        StringBuilder jprase = new StringBuilder();
        for (String word : arr) {
            jprase.append(capitalizeWord(word));
            jprase.append(" ");
        }
        return jprase.toString().trim();
    }

    private String capitalizeWord(String word) {
        return word.isEmpty() ? word : word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
