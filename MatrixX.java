package homeworkFall2015;

public class MatrixX {
	
	public static void main(String[] args) {

		int[][] matrix = new int[22][26];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i % matrix[i].length == matrix[i].length - 1 - j
				|| i % matrix[i].length == j) {
					System.out.print("X ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}
