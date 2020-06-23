package programs;

import classes.Trie;

public class TreeProgram {
    public static void main(String[] args) {
        Trie trie = GetTrie();
        trie.TrySearch("акация");
        trie.TrySearch("фрукт");
        String testWord = "Ураган";
        trie.Add(testWord, "нехорошее явление");
        System.out.println(trie.TrySearch(testWord));
        trie.Remove(testWord);
        System.out.println(trie.TrySearch(testWord));
        System.out.println(trie.TrySearch("акация"));
        System.out.println(trie.SearchByPrefix("ак"));
    }

    public static Trie GetTrie(){
        String[] words = {"акация", "аккаунт", "академия", "аккордеон", "аккаунт", "аккорд", "акиба", "акинфеев",
                          "акция", "акклиматизация", "акула", "аккумулятор", "фразеологизм", "франция", "француз",
                          "фракция", "фрагмент", "фрезеровщик", "фрактал", "фрисби", "фриланс"};
        Trie trie = new Trie();
        for (String word:
             words) {
            trie.Add(word, " - нет определения");
        }

        return trie;
    }
}
