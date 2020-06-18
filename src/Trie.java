public class Trie {
    private Node root;
    public int Count;
    private String searchResult;

    public Trie(){
        root = new Node('\0', "", "");
        Count = 1;
    }

    public void Add (String key, String data){
        AddNode(key, data, root);
        System.out.println(String.format("Слово %s добавлено со значением: %s", key, data));
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
                Node newNode = new Node(key.charAt(0), data, node.Prefix + key.charAt(0));
                node.subTree.put(key.charAt(0), newNode);
                AddNode(key.substring(1), data, newNode);
                //System.out.println(newNode.toString());
            }
        }
    }

    public void Remove(String key){
        RemoveHelper(key, root);
        System.out.println(String.format("Слово %s удалено", key));
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
        searchResult = "No results";
        SearchHelper(key, root);
        return searchResult;
    }

    private void SearchHelper(String key, Node node) {
        if (key == null || key.isEmpty()) {
            if (node.isLeaf) {
                searchResult = String.format("Результат по запросу: %s", node.Data);
            }
        } else {
            Node subNode = node.TryFind(key.charAt(0));
            if (subNode != null) {
                SearchHelper(key.substring(1), subNode);
            }
        }
    }
}
