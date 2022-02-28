package org.hunter;

public class SpiralPrint{

	public static void main(String [] args){
		char [][] array = {
				{'a', 'b', 'c'},
				{'d', 'e', 'f'},
				{'g', 'h', 'i'},
		};

		char [][] array2 = {
				{'a', 'b', 'c', '1'},
				{'d', 'e', 'f', '2'},
				{'g', 'h', 'i', '4'},
				{'x', 'z', '9', '0'},
		};

		printSpiral(array, 0, 0, array.length);
		System.out.println("");
		printSpiral(array2, 0, 0, array2.length);
	}

	//time=O(N) space=O(1)
	public static void printSpiral(char [][] array, int rowStart, int colStart, int length){
		if(length < 1){
			return;
		}
		if(length == 1){
			System.out.println(array[rowStart][colStart]);
			return;
		}
		for(int i = colStart; i < colStart + length; ++i){
			System.out.println(array[rowStart][i]);
		}
		for(int i = rowStart + 1; i < rowStart + length; ++i){
			System.out.println(array[i][colStart + length - 1]);
		}
		for(int i = colStart + (length - 2); i >= colStart; --i){
			System.out.println(array[rowStart + (length - 1)][i]);
		}
		for(int i = rowStart + (length - 2); i > rowStart; --i){
			System.out.println(array[i][colStart]);
		}
		printSpiral(array, ++rowStart, ++colStart, length - 2);
	}

}
