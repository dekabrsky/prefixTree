public class API_Program {
    public static void main(String[] args) {
        TrieConsoleAPI trieAPI = GetTrie();
        String about_akacia = trieAPI.GetWordByKey("акация");
        String about_frukt = trieAPI.GetWordByKey("фрукт");

        String testWord = "Ураган";
        trieAPI.Add(testWord, "нехорошее явление");
        System.out.println(trieAPI.GetWordByKey(testWord));
        trieAPI.Remove(testWord);
        System.out.println(trieAPI.GetWordByKey(testWord));

        System.out.println(trieAPI.GetWordsByPrefix("ак"));
        System.out.println(trieAPI.GetWordsByPrefix("фр"));
        System.out.println(trieAPI.GetWordsByPrefix("пу"));
        System.out.println(trieAPI.GetWordsByPrefix("фрак"));
        System.out.println(trieAPI.GetWordsByPrefix("фра"));
    }

    public static TrieConsoleAPI GetTrie(){
        String[] words = {"акация", "аккаунт", "академия", "аккордеон", "аккаунт", "аккорд", "акиба", "акинфеев",
                "акция", "акклиматизация", "акула", "аккумулятор", "фразеологизм", "франция", "француз",
                "фракция", "фрагмент", "фрезеровщик", "фрактал", "фрисби", "фриланс", "фрак"};
        TrieConsoleAPI trie = new TrieConsoleAPI();
        for (String word:
                words) {
            trie.Add(word, " - нет определения");
        }

        return trie;
    }
}
