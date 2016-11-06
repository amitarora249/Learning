package com.practice.datastructure.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode(Character.MIN_VALUE);
	}

	public void addWord(String word) {

		int length = word.length();
		char[] charArray = word.toCharArray();
		TrieNode tNode = root;
		TrieNode preNode = root;
		List<TrieNode> childNodes = tNode.getChildNodes();
		for (char c : charArray) {
			preNode = tNode;

			if (childNodes == null || childNodes.isEmpty()) {
				tNode = new TrieNode(c);
				preNode.setChildNode(tNode);
			} else {
				for (TrieNode childNode : childNodes) {
					if (childNode.charVal == c) {
						tNode = childNode;
					}
				}
			}

			if (tNode == preNode) {
				tNode = new TrieNode(c);
				preNode.setChildNode(tNode);
			}

			childNodes = tNode.getChildNodes();
			if (c == word.charAt(length - 1)) {
				tNode.isLeaf = true;
			}
		}

	}

	@Override
	public String toString() {
		return "Trie [root=" + root + "]";
	}

	public boolean findWord(String word) {

		TrieNode tNode = root;
		TrieNode preNode = root;
		char[] charArray = word.toCharArray();
		int length = charArray.length;
		List<TrieNode> childNodes = tNode.getChildNodes();
		boolean isPresent = false;
		for (char c : charArray) {
			preNode = tNode;
			for (TrieNode childNode : childNodes) {
				if (childNode.charVal == c) {
					tNode = childNode;
				}
			}
			if (tNode == preNode) {
				isPresent = false;
			} else {
				isPresent = true;
				childNodes = tNode.getChildNodes();
			}
			if (c == word.charAt(length - 1)) {
				return isPresent;
			}
		}

		return false;
	}

	class TrieNode {

		char charVal;
		List<TrieNode> childNodes = new ArrayList<>();
		boolean isLeaf;

		TrieNode(char c) {
			this.charVal = c;
		}

		public List<TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setChildNode(TrieNode childNode) {
			this.childNodes.add(childNode);
		}

		public boolean isLeaf() {
			return isLeaf;
		}

		@Override
		public String toString() {
			return "TrieNode [charVal=" + charVal + ", childNodes="
					+ childNodes + ", isLeaf=" + isLeaf + "]";
		}
	}

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.addWord("soon");
		trie.addWord("sober");
		System.out.println(trie + "\n" + trie.findWord("son"));
	}
}
