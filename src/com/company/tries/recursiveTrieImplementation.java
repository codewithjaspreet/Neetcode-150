package com.company.tries;

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node root, String word, int index) {
        if (root == null) root = new Node();
        if (index == word.length()) {
            root.val = true;
            return root;
        }
        char c = word.charAt(index);
        root.next[c - 'a'] = insert(root.next[c - 'a'], word, index+1);
        return root;
    }

    public boolean search(String word) {
        Node node = search(root, word, 0);
        if (node == null) return false;
        return node.val;
    }

    private Node search(Node node, String word, int index) {
        if (node == null) return null;
        if (index == word.length()) return node;
        char c = word.charAt(index);
        return search(node.next[c - 'a'], word, index + 1);
    }

    public boolean startsWith(String prefix) {
        Node node = startsWith(root, prefix, 0);
        if (node == null) return false;
        return true;
    }

    private Node startsWith(Node node, String prefix, int index) {
        if (node == null) return null;
        if (index == prefix.length()) return node;
        char c = prefix.charAt(index);
        return startsWith(node.next[c - 'a'], prefix, index + 1);
    }

    private static class Node {
        boolean val;
        Node[] next = new Node[26];
    }
}
