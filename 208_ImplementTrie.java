class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }
}

class TrieNode {
    private boolean isLeaf;
    private Map<Character, TrieNode> children;

    public TrieNode() {
      isLeaf = false;
      children = HashMap<>();
    }

    public void insert(String word) {
      if (word.length() == 0) {
        this.isLeaf = true;

        return;
      }

      char ch = word.charAt(0);

      if (!children.containsKey(ch)) {
        children.put(ch, new TrieNode());
      }

      children.get(ch).insert(word.substring(1));
    }

    public boolean search(String word) {
      if (word.length() == 0) {
        return this.isLeaf;
      }

      char ch = word.charAt(0);

      if (children.containsKey(ch)) {
        return children.get(ch).search(word.substring(1));
      }

      return false;
    }

    public boolean startsWith(String word) {
      if (word.length() == 0) {
        return true;
      }

      char ch = word.charAt(0);

      if (children.containsKey(ch)) {
        return children.get(ch).startsWith(word.substring(1));
      }

      return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */