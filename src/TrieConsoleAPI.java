import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrieConsoleAPI {
    private Trie trie;

    public TrieConsoleAPI(){
        trie = new Trie();
    }

    public void Add(String key, String data){
        System.out.println(String.format("Слово %s будет добавлено со значением: %s", key, data));
        trie.Add(key, data);
        System.out.println(String.format("Слово %s добавлено со значением: %s", key, data));
    }

    public void Add(HashMap<String, String> words){
        for (Map.Entry<String, String> entry : words.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            Add(entry.getKey(), entry.getValue());
        }
        System.out.println("Все строки добавлены.");
    }

    public void Remove(String key){
        trie.Remove(key);
        System.out.println(String.format("Слово %s удалено", key));
    }

    public String GetWordByKey(String key){
        String result = trie.TrySearch(key);
        if (result == null) {
            System.out.println(String.format("Слово %s не найдено", key));
            return "Nothing";
        } else {
            System.out.println(String.format("По ключу %s найдено: %s", key, result));
            return result;
        }
    }

    public boolean ContainsKey(String key){
        return (!(GetWordByKey(key).equals("Nothing")));
    }

    public String[] GetWordsByPrefix(String key){
        ArrayList result = trie.SearchByPrefix(key);
        if (result.isEmpty()){
            System.out.println(String.format("По запросу %s ничего не найдено", key));
            return null;
        } else {
            System.out.print(String.format("По запросу %s найдено %d записей:", key, result.size()));
            System.out.println(result);
            return (String[]) result.toArray();
        }
    }
}
