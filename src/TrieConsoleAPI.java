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

    }
}
