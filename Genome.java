package homeworkFall2015;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Genome {
	
	class WordComparator implements Comparator<Word> {
		@Override
		public int compare(Word o1, Word o2) {
			return o1.compareTo(o2);
		}
	}
	
	class Word implements Comparable<Word> {
		String _s;
		int _i;
		Word(String s, int i) {
			_s = s;
			_i = i;
		}

		@Override
		public int compareTo(Word o) {
			return compare(this._s, o._s);	
		}

		private int compare(String s1, String s2) {
			int diff = s1.charAt(0) - s2.charAt(0);
			for (int i=1; i<s1.length(); i++) {
				if (diff == 0) {					
				diff = s1.charAt(i) - s2.charAt(i);
				}
			}
			return diff;
		}
	}

	public static int GENOME_SIZE = 10_000_000;
	public static char[] letters = { 'A', 'C', 'G', 'T' };

	char[] sequence;

	public void generateSequence() {
		Random random = new Random();
		sequence = new char[GENOME_SIZE];

		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = letters[random.nextInt(letters.length)];
		}
	}

	public void searchDuplicatesBruteForce(char[] data, int M) {
		for (int i = 0; i < data.length - M + 1; i++) {
			for (int j = i + 1; j < data.length - M + 1; j++) {
				// System.out.println(data[i] + "," + data[j]);
				int k = i;
				int m = j;
				int n = 0;
				while (data[k++] == data[m++] && ++n < M) {
				}
				if (n == M) {
					System.out.println("Match at " + i + " and " + j);
				}
			}
		}
	}

	public void searchDuplicatesSorting(char[] data, int M, WordComparator c) {
		List<Word> words = new LinkedList<>();

		System.out.println("start");

		for (int i = 0; i < data.length - M + 1; i++) {
			String word = new String(data, i, M);
			Word w = new Word(word, i);
			words.add(w);
			if (i % 1000000 == 0) {
				System.out.println(i);
				System.out.println(w._s);
			}
		}

		System.out.println("sort");

		Collections.sort(words, c);

		System.out.println("search");
		Iterator<Word> it = words.iterator();
		Word last = new Word("", 0);
		while (it.hasNext()) {
			Word word = it.next();
			if (word._s.equals(last._s)) {
				System.out.println("Match at " + word._i + ": " + word._s);
			}
			last = word;
		}
	}

	public static void main(String[] args) {

		Genome genome = new Genome();
		
		WordComparator comp = genome.new WordComparator();

		genome.searchDuplicatesBruteForce(new char[] { 'A', 'A', 'C', 'T', 'A', 'A', 'C' }, 3);

		System.out.println("Generating");
		genome.generateSequence();
		// genome.searchDuplicatesBruteForce(genome.sequence, 10);

		System.out.println("Searching");
		genome.searchDuplicatesSorting(genome.sequence, 10, comp);

	}

}