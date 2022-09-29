package com.example.MessingAround.utils;


import org.springframework.cache.Cache;

import java.util.Collection;
import java.util.concurrent.Callable;

public class Trie{
    private static TrieNode root;
    private static Character endSymbol;
    private static String name;


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

    public boolean search(String word){
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if (node.children.containsKey(letter)){
                node = node.children.get(letter);
            } else {
                return false;
            }
        }
        return node.children.containsKey(this.endSymbol);
    }

    public boolean containsPrefix(String prefix){
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++){
            char letter = prefix.charAt(i);
            if(!node.children.containsKey(letter)){
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }

}
