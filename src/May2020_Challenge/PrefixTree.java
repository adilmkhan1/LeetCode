package May2020_Challenge;

import java.util.HashMap;
import java.util.Map;

//class Trie {
//	Map<Character, Trie> children;
//	boolean endOfWord;
//
//	Trie() {
//		children = new HashMap<>();
//		endOfWord = false;
//	}
//}

//
//	Trie root;
//
//	PrefixTree() {
//		root = new Trie();
//	}
//
//	/** Inserts a word into the trie. */
//	public void insert(String word) {
//
//		Trie current = root;
//
//		for (Character c : word.toCharArray()) {
//			Trie node;
//
//			if (!current.children.containsKey(c)) {
//				node = new Trie();
//				current.children.put(c, node);
//			}
//
//			current = current.children.get(c);
//		}
//
//		current.endOfWord = true;
//
//	}
//
//	/** Returns if the word is in the trie. */
//	public boolean search(String word) {
//
//		Trie current = root;
//
//		for (Character c : word.toCharArray()) {
//			Trie node = current.children.get(c);
//
//			if (node == null) {
//				return false;
//			}
//
//			current = node;
//		}
//
//		return current.endOfWord;
//
//	}
//
//	/**
//	 * Returns if there is any word in the trie that starts with the given prefix.
//	 */
//	public boolean startsWith(String prefix) {
//
//		Trie current = root;
//
//		for (Character c : prefix.toCharArray()) {
//			Trie node = current.children.get(c);
//
//			if (node == null) {
//				return false;
//			}
//
//			current = node;
//		}
//
//		return true;
//
//	}

public class PrefixTree
{

    static class Trie {
    
    private Trie children[];
    
	private boolean endOfWord;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
		endOfWord = false;
    }
    
   
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Trie current = this;
    	
    	for(char c : word.toCharArray())
    	{
    		
    		if(current.children[c -'a'] == null)
    		{
    			current.children[c - 'a'] = new Trie();
    		}
    		
    		current = current.children[c - 'a'];
    	}
    	
    	current.endOfWord = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Trie current = this;
    	
    	for(char c : word.toCharArray())
    	{
    		current = current.children[c - 'a'];
    		
    		if(current == null)
    		{
    			return false;
    		}
    	}
    	
    	return current.endOfWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
     Trie current = this;
    	
    	for(char c : prefix.toCharArray())
    	{
    		current = current.children[c - 'a'];
    		
    		if(current == null)
    		{
    			return false;
    		}
    	}
    	
    	return true;
        
    }
    
}


	public static void main(String[] args) {

		Trie trie = new Trie();

		 trie.insert("apple");

		System.out.println(trie.search("apple")); // true

		System.out.println(trie.search("app")); // false

		System.out.println(trie.startsWith("app")); // true

		trie.insert("app");

		System.out.println(trie.search("app")); // true

	}

}
