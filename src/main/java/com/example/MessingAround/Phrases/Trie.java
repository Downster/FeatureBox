package com.example.MessingAround.Phrases;

public class Trie {
    private static TrieNode root;
    private static Character endSymbol;


    public Trie(){
        this.root = new TrieNode();
        this.endSymbol = '*';
    }

    public void addWord(String word){
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)){
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.children.put(this.endSymbol, null);
    }




}
