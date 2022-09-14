package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchTwo {
    public static void main(String[] args) {
        // [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        // ["oath","pea","eat","rain"]
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> foundWords = findWords(board, words);
        System.out.println(foundWords);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root, board, result);
                }
            }
        }

        return result;
    }

    private static void backtracking(int row, int col, TrieNode parent, char[][] board, List<String> result) {
        Character letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode, board, result);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
