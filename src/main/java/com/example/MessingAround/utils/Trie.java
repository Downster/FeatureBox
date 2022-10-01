package com.example.MessingAround.utils;


import java.util.ArrayList;

public class Trie{
    private static TrieNode root;
    private static Character endSymbol;

    public Trie(){
        root = new TrieNode();
        endSymbol = '*';
    }

    public void addWord(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)){
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);
    }

    public boolean search(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if (node.children.containsKey(letter)){
                node = node.children.get(letter);
            } else {
                return false;
            }
        }
        return node.children.containsKey(endSymbol);
    }

    public boolean containsPrefix(String prefix){
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            char letter = prefix.charAt(i);
            if(!node.children.containsKey(letter)){
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }

    public TrieNode getPrefixEnd(String prefix){
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            char letter = prefix.charAt(i);
            node = node.children.get(letter);
        }
        return node;
    }

    public void dfs(String prefix, TrieNode node, ArrayList<String> words){
        if (node.children.containsKey(endSymbol)){
            words.add(prefix);
            return;
        }
        for (Character c: node.children.keySet()){
            dfs(prefix + c, node.children.get(c), words);
        }
    }

    public String[] prefixList(String prefix){
        ArrayList<String> result = new ArrayList<>();
        if (this.containsPrefix(prefix)) {
            TrieNode prefixEnd = this.getPrefixEnd(prefix);
            if (!prefixEnd.children.containsKey(endSymbol)) {
                dfs(prefix, prefixEnd, result);
            } else {
                result.add(prefix);
            }
        }
        return result.toArray(new String[0]);
    }
}
