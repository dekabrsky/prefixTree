package programs;

import classes.TrieConsoleAPI;

public class API_Program {
    public static void main(String[] args) {
        TrieConsoleAPI trieAPI = GetTrie();
        String about_akacia = trieAPI.GetWordByKey("акация");
        String about_frukt = trieAPI.GetWordByKey("фрукт");

        String testWord = "Ураган";
        trieAPI.Add(testWord, "нехорошее явление");
        trieAPI.GetWordByKey(testWord);
        trieAPI.Remove(testWord);
        trieAPI.GetWordByKey(testWord);

        trieAPI.GetWordsByPrefix("ак");
        trieAPI.GetWordsByPrefix("фр");
        trieAPI.GetWordsByPrefix("хе");
        trieAPI.GetWordsByPrefix("фрак");
        trieAPI.GetWordsByPrefix("фра");
        trieAPI.All();
    }

    public static TrieConsoleAPI GetTrie(){
        String[] words = {"акация", "аккаунт", "академия", "аккордеон", "аккаунт", "аккорд", "акиба", "акинфеев",
                "акция", "акклиматизация", "акула", "аккумулятор", "фразеологизм", "франция", "француз",
                "фракция", "фрагмент", "фрезеровщик", "фрактал", "фрисби", "фриланс", "фрак"};
        TrieConsoleAPI trie = new TrieConsoleAPI();
        for (String word:
                words) {
            trie.Add(word, "нет определения");
        }
        return trie;
    }
}
