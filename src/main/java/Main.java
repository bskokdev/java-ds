public class Main {
  public static void main(String[] args){
    Trie trie = new Trie();
    trie.insertWord("boris");
    trie.insertWord("pepa");
    System.out.println(trie.containsWord("boris"));
  }
}
