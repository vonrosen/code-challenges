package org.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoxStacks{

	public static void main(String [] args){
		int [] boxesA = new int[]{10};
		int [] boxesB = new int[]{20};
		int [] boxesC = new int[]{30};

		BoxStacks boxStacks = new BoxStacks();
		System.out.println(boxStacks.stackCommands(boxesA, boxesB, boxesC));

		boxesA = new int[]{500, 10};
		boxesB = new int[]{20, 600};
		boxesC = new int[]{1, 4000, 30};
		System.out.println(boxStacks.stackCommands(boxesA, boxesB, boxesC));
	}

	/**
	 * first value in array is top of stack
	 * @param stackA
	 * @param stackB
	 * @param stackC
	 * @return
	 */
	public String[] stackCommands(int [] boxesA, int [] boxesB, int [] boxesC){

		Stack<Integer> stackA = new Stack<>();
		Stack<Integer> stackB = new Stack<>();
		Stack<Integer> stackC = new Stack<>();
		List<String> commands = new ArrayList<>();

		for(int i = boxesA.length - 1; i >= 0; --i){
			stackA.push(boxesA[i]);
		}

		for(int i = boxesB.length - 1; i >= 0; --i){
			stackB.push(boxesB[i]);
		}

		for(int i = boxesC.length - 1; i >= 0; --i){
			stackC.push(boxesC[i]);
		}

		while(!stackA.isEmpty()){
			stackC.push(stackA.pop());
			commands.add("A C");
		}

		while(!stackB.isEmpty()){
			stackC.push(stackB.pop());
			commands.add("B C");
		}

		while(!stackB.isEmpty() || !stackC.isEmpty()){
			int maxValue = stackC.get(0);
			for(int i = 0; i < stackC.size(); ++i){
				if(maxValue < stackC.get(i)){
					maxValue = stackC.get(i);
				}
			}

			int sizeC = stackC.size();
			for(int i = 0; i < sizeC; ++i){
				int value = stackC.pop();
				stackB.push(value);
				commands.add("C B");
				if(maxValue == value){
					break;
				}
			}

			stackA.push(stackB.pop());
			commands.add("B A");

			while(!stackB.isEmpty()){
				stackC.push(stackB.pop());
				commands.add("B C");
			}
		}

		String [] s = new String[commands.size()];
		for(int i = 0; i < commands.size(); ++i){
			s[i] = commands.get(i);
		}

		return s;
	}

}
