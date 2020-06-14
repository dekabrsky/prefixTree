import java.util.Scanner;

public class TreeProgram {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner in = new Scanner(System.in);
        while (true){
            String method = in.next();
            String message = in.next();
            switch (method){
                case ("add"):
                    String value = in.next();
                    trie.Add(message, value);
                case ("remove"):
                    trie.Remove(message);
                case ("search"):
                    System.out.println(trie.TrySearch(message));
                case ("exit"):
                    break;
            }
        }
    }
}
