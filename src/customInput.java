import java.util.Scanner;

public class customInput {
    public static void main(String[] args) {
        TrieConsoleAPI trie = new TrieConsoleAPI();
        Scanner sc = new Scanner(System.in);

        while (true){
            String command = sc.nextLine();
            String[] splitCommand = command.split(":");
            if (splitCommand[0].equals("add"))
                trie.Add(splitCommand[1], splitCommand[2]);
            else if (splitCommand[0].equals("remove"))
                trie.Remove(splitCommand[1]);
            else if (splitCommand[0].equals("find word"))
                trie.GetWordByKey(splitCommand[1]);
            else if (splitCommand[0].equals("find prefix"))
                trie.GetWordsByPrefix(splitCommand[1]);
            else if (splitCommand[0].equals("exit"))
                break;
            else if (splitCommand[0].equals("clear"))
                trie.Clear();
            else
                System.out.println("Запрос некорректен");
        }
    }
}
