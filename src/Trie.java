public class Trie {
    private Node root;
    public int Count;

    public Trie(){
        root = new Node('\0', null);
        Count = 1;
    }

    public void Add (String key, String data){
        AddNode(key, data, root);
    }

    private void AddNode(String key, String data, Node node){
        if (key == null){
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
                Node newNode = new Node(key.charAt(0), data);
                subNode.subTree.Add(key.charAt(0), newNode);
                AddNode(key.substring(1), data, subNode);
            }
        }
    }

    public void Remove(String letter){

    }

    public String Search(String letter){
        return "letter";
    }
}
