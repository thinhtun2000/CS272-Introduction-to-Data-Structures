package lab9;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		// Create a scanner object
		Scanner scnr = new Scanner(System.in);
		
		// Input the string
		String sentence;
		System.out.println("Please input the sentence to check: ");
		sentence = scnr.nextLine();
		
		// Because it doesn't matter if the letter are upper or lower case
		// The operation will make everything lower case for it to be easier to compare
		sentence = sentence.toLowerCase();
		
		// Create a copy of the input string
		String sentence1 = sentence;
		
		// Create a new object of LinkedList that will hold each word of the input
		LinkedQueue<String> palindrome = new LinkedQueue<String>();
		
		// Splut the String into words and put them into a queue
		while (sentence.length() >= 0) {
			String firstWord;
			if (sentence.indexOf(' ') != -1) {
				
				firstWord = sentence.substring(0, sentence.indexOf(" "));
				// Check if the word contains any non-letter char at the end, if it does, trim that
				char c = firstWord.charAt(firstWord.length() - 1);
				if(!Character.isLetter(c))
					firstWord = firstWord.substring(0, firstWord.length() - 1);
				palindrome.enqueue(firstWord);
				sentence = sentence.substring(sentence.indexOf(' ') + 1);
				
			}
			else {
				
				// Check if the word contains any non-letter char at the end, if it does, trim that
				char c = sentence.charAt(sentence.length() - 1);
				if(!Character.isLetter(c))
					sentence = sentence.substring(0, sentence.length() - 1);
				palindrome.enqueue(sentence);
				break;
				
			}	
		}
		
		// Create another queue that holds words but in reverse order using the copy of the input String
		LinkedQueue<String> revpalindrome = new LinkedQueue<String>();
		
		// Cut the input String from the end and put the words into the queue
		while (sentence1.length() > 0) {
			String firstWord;
			if (sentence1.indexOf(' ') != -1) {
				
				firstWord = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
				// Check if the word contains any non-letter char at the end, if it does, trim that
				char c = firstWord.charAt(firstWord.length() - 1);
				if(!Character.isLetter(c))
					firstWord = firstWord.substring(0, firstWord.length() - 1);
				revpalindrome.enqueue(firstWord);
				sentence1 = sentence1.substring(0, sentence1.lastIndexOf(" "));
				
			}
			else {
				
				// Check if the word contains any non-letter char at the end, if it does, trim that
				char c = sentence.charAt(sentence.length() - 1);
				if(!Character.isLetter(c))
					sentence = sentence.substring(0, sentence.length() - 1);
				revpalindrome.enqueue(sentence1);
				break;
				
			}	
		}
		
		// Create a count number to count the number of time the words are compared
		// If it hits 0. it means that every word is the same, the string input is a palindrome
		// Otherwise, it is not a palindrome
		int count = palindrome.size();
		while (!palindrome.isEmpty() || !revpalindrome.isEmpty()) {
			if(palindrome.front().equals(revpalindrome.front())) {
				palindrome.dequeue();
				revpalindrome.dequeue();
				count--;
			}
			else
				break;
		}
		if (count == 0)
			System.out.println("The input String is a word-by-word palindrome.");
		else
			System.out.println("The input String is not a word-by-word palindrome.");

	}

}
