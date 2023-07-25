class TrieNode {

  public char c;
  public TrieNode[] children;
  public boolean isWord;

  public TrieNode(char c) {
    this.c = c;
    this.children = new TrieNode[26];
    this.isWord = false;
  }
}

public class Trie {

  private final TrieNode root;

  public Trie() {
    this.root = new TrieNode('\0');
  }

  public void insertWord(String word) {
    TrieNode cur = this.root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }

  public boolean containsWord(String word) {
    TrieNode cur = findNode(word);
    return cur != null && cur.isWord;
  }

  public boolean hasPrefix(String prefix) {
    return findNode(prefix) != null;
  }

  private TrieNode findNode(String s) {
    TrieNode cur = this.root;
    for (char c : s.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return null;
      }
      cur = cur.children[c - 'a'];
    }
    return cur;
  }
}
