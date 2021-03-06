package classes;
import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    private final Node root;
    private String searchResult;
    private ArrayList<String> prefixResult;
    private Node prefixNode;
    private HashMap<String, String> dict;

    public Trie(){
        root = new Node('\0', "", "");
    }

    public void Add (String key, String data){
        AddNode(key, data, root);
    }

    private void AddNode(String key, String data, Node node){
        if (key.isEmpty()){
            if (!node.isLeaf){
                node.Data = data;
                node.isLeaf = true;
            }
        }
        else {
            char letter = key.charAt(0);
            Node subNode = node.TryFind(letter);
            if (subNode != null){
                AddNode(key.substring(1), data, subNode);
            }
            else{
                Node newNode = new Node(letter, data, node.Prefix + letter);
                node.subTree.put(key.charAt(0), newNode);
                AddNode(key.substring(1), data, newNode);
                //System.out.println(newNode.toString());
            }
        }
    }

    public void Remove(String key){
        RemoveHelper(key, root);
    }

    private void RemoveHelper(String key, Node node){
        if (key == null || key.isEmpty()){
            if (node.isLeaf){
                node.isLeaf = false;
            }
        } else {
            Node subNode = node.TryFind(key.charAt(0));
            if (subNode != null) {
                RemoveHelper(key.substring(1), subNode);
            }
        }
    }

    public String TrySearch(String key){
        searchResult = null;
        SearchHelper(key, root);
        return searchResult;
    }

    private void SearchHelper(String key, Node node) {
        if (key == null || key.isEmpty()) {
            if (node.isLeaf) {
                searchResult = node.Data;
            }
        } else {
            Node subNode = node.TryFind(key.charAt(0));
            if (subNode != null) {
                SearchHelper(key.substring(1), subNode);
            }
        }
    }

    public ArrayList<String> SearchByPrefix(String prefix){
        prefixResult = new ArrayList<>();
        prefixNode = root;
        FindPrefixNode(prefix, root, prefix);
        if (!prefixNode.equals(root)) {
            GetSubNodes(prefixNode);
        }
        return prefixResult;
    }

    private void FindPrefixNode(String key, Node node, String prefix) {
        if (node.Prefix.equals(prefix)) {
            prefixNode = node;
        } else {
            Node subNode = node.TryFind(key.charAt(0));
            if (subNode != null) {
                FindPrefixNode(key.substring(1), subNode, prefix);
            }
        }
    }

    private void GetSubNodes(Node node){
        if (!node.subTree.isEmpty()){
            if (node.isLeaf)
                prefixResult.add(node.Prefix);
            for (Node subNode:
                 node.subTree.values()) {
                GetSubNodes(subNode);
            }
        } else {
            if (node.isLeaf)
                prefixResult.add(node.Prefix);

        }
    }

    public HashMap<String, String> toHashMap(){
        dict = new HashMap<String, String>();
        GetAll(root);
        return dict;
    }

    private void GetAll(Node node){
        if (!node.subTree.isEmpty()){
            if (node.isLeaf)
                dict.put(node.Prefix, node.Data);
            for (Node subNode:
                    node.subTree.values()){
                GetAll(subNode);
            }

        } else
            if (node.isLeaf)
                dict.put(node.Prefix, node.Data);
    }
}
