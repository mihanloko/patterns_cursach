package patterns.cursach.searcher;

import java.util.Arrays;

public class LevensteinDistance implements Searcher {

    private int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    private int calculate(String str1, String str2) {
        int[] Di_1 = new int[str2.length() + 1];
        int[] Di = new int[str2.length() + 1];

        for (int j = 0; j <= str2.length(); j++) {
            Di[j] = j; // (i == 0)
        }

        for (int i = 1; i <= str1.length(); i++) {
            System.arraycopy(Di, 0, Di_1, 0, Di_1.length);

            Di[0] = i; // (j == 0)
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                Di[j] = min(
                        Di_1[j] + 1,
                        Di[j - 1] + 1,
                        Di_1[j - 1] + cost
                );
            }
        }

        return Di[Di.length - 1];
    }

    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    /**
     *
     * @param errorsCount количество ошибок
     * @param word1 первое слово
     * @param word2 второе слово
     * @return true - слова одинаковые, false - нет
     */
    @Override
    public boolean compare(int errorsCount, String word1, String word2) {
        return calculate(word1, word2) <= errorsCount;
    }
}
