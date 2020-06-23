package programs;
import classes.Trie;

public class timers {

    public static long addMeasure(Trie trie, String[] words, String[] values) {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            trie.Add(words[i % 21], values[i % 21]);
        }
        en = System.nanoTime();
        return en - st;
    }

    public static long removeMeasure(Trie trie, String[] words) {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            trie.Remove(words[i % 21]);;
        }
        en = System.nanoTime();
        return en - st;
    }

    public static long searchMeasure(Trie trie, String[] words) {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            trie.TrySearch(words[i % 21]);
        }
        en = System.nanoTime();
        return en - st;
    }

    public static long prefixMeasure(Trie trie, String[] words) {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            trie.SearchByPrefix(words[i % 21]);;
        }
        en = System.nanoTime();
        return en - st;
    }

    public static void main(String[] args) {
        String[] words = {"акация", "аккаунт", "академия", "аккордеон", "аккаунт", "аккорд", "акиба", "акинфеев",
                "акция", "акклиматизация", "акула", "аккумулятор", "фразеологизм", "франция", "француз",
                "фракция", "фрагмент", "фрезеровщик", "фрактал", "фрисби", "фриланс"};

        String[] values = {"дерево", "страница", "организация", "инструмент", "сеть", "созвучие", "что-то", "футболист",
                "распродажа", "явление", "рыба", "питание", "выражение", "старна", "житель франции",
                "партия", "кусок", "мастер", "структура", "тарелка", "вид работы"};

        Trie trie = new Trie();

        System.out.println("Add");
        System.out.println("cold start time " + String.format("%,12d",addMeasure(trie, words, values)) + " ns");
        System.out.println("warmed JRE time " + String.format("%,12d",addMeasure(trie, words, values)) + " ns");

        System.out.println("Remove");
        System.out.println("cold start time " + String.format("%,12d",removeMeasure(trie, words)) + " ns");
        System.out.println("warmed JRE time " + String.format("%,12d",removeMeasure(trie, words)) + " ns");

        System.out.println("Add again");
        System.out.println("cold start time " + String.format("%,12d",addMeasure(trie, words, values)) + " ns");
        System.out.println("warmed JRE time " + String.format("%,12d",addMeasure(trie, words, values)) + " ns");

        System.out.println("Search word");
        System.out.println("cold start time " + String.format("%,12d",searchMeasure(trie, words)) + " ns");
        System.out.println("warmed JRE time " + String.format("%,12d",searchMeasure(trie, words)) + " ns");

        System.out.println("Search prefix");
        System.out.println("cold start time " + String.format("%,12d",prefixMeasure(trie, words)) + " ns");
        System.out.println("warmed JRE time " + String.format("%,12d",prefixMeasure(trie, words)) + " ns");
    }
}


