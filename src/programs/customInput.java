package programs;

import classes.TrieConsoleAPI;

import java.util.Scanner;

public class customInput {
    public static void main(String[] args) {
        TrieConsoleAPI trie = new TrieConsoleAPI();
        Scanner sc = new Scanner(System.in);

        label:
        while (true){
            String command = sc.nextLine();
            String[] splitCommand = command.split(":");
            switch (splitCommand[0]) {
                case "add":
                    trie.Add(splitCommand[1], splitCommand[2]);
                    break;
                case "remove":
                    trie.Remove(splitCommand[1]);
                    break;
                case "find word":
                    trie.GetWordByKey(splitCommand[1]);
                    break;
                case "find prefix":
                    trie.GetWordsByPrefix(splitCommand[1]);
                    break;
                case "exit":
                    break label;
                case "all":
                    trie.All();
                case "clear":
                    trie.Clear();
                    break;
                default:
                    System.out.println("Запрос некорректен");
                    break;
            }
        }
    }
}
