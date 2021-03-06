package classes;

import java.util.HashMap;

public class Node {
    public char Letter;
    public String Data;
    public boolean isLeaf;
    public HashMap<Character, Node> subTree;
    public String Prefix;

    public Node(String data){
        Data = data;
    }

    public Node(char letter, String data, String prefix){
        Letter = letter;
        Data = data;
        subTree = new HashMap<>();
        Prefix = prefix;
    }

    public Node TryFind(char letter){
        return subTree.getOrDefault(letter, null);
    }

    @Override
    public String toString(){
        return String.format("Letter: %s, Prefix: %s", Letter, Prefix);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Node nodeObj = (Node) obj;
        return nodeObj.Data.equals(this.Data);
    }
}
