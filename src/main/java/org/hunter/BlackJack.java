package org.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

// AJ = 21
// AAJ = 12
// AA = 12
// A6JK = 27
public class BlackJack{

	public static void main(String [] args){
		Hand hand1 = new Hand(List.of(
				new ConcreteCard(11),
				new ConcreteCard(10)));
		System.out.println(hand1.getScore());

		Hand hand2 = new Hand(List.of(
				new ConcreteCard(11),
				new ConcreteCard(11),
				new ConcreteCard(10)));
		System.out.println(hand2.getScore());

		Hand hand3 = new Hand(List.of(
				new ConcreteCard(11),
				new ConcreteCard(11)));
		System.out.println(hand3.getScore());

		Hand hand4 = new Hand(List.of(
				new ConcreteCard(11),
				new ConcreteCard(6),
				new ConcreteCard(10),
				new ConcreteCard(10)));
		System.out.println(hand4.getScore());
	}

	interface Card{
		int getLowValue();
		int getHighValue();
	}

	static class ConcreteCard implements Card{
		int value;
		ConcreteCard(int value){
			this.value = value;
		}

		public int getHighValue(){
			return value;
		}

		public int getLowValue(){
			return value == 11 ? 1 : value;
		}
	}

	static class Hand{
		final List<Card> cards;

		Hand(List<Card> cards){
			this.cards = cards;
		}

		int getScore(){
			boolean hasAces = cards
					.stream()
					.anyMatch(card -> card.getHighValue() == 11);
			Stack<Card> aces = new Stack<>();
			cards.stream()
					.filter(card -> card.getHighValue() == 11)
					.forEach(card -> aces.add(card));
			int sum = cards.stream()
					.mapToInt(Card::getHighValue)
					.sum();
			if(!hasAces){
				return sum;
			}
			List<Card> lowAces = new ArrayList<>();
			while(sum > 21 && aces.size() > 0){
				lowAces.add(aces.pop());
				sum = 0;
				for(Card card : cards){
					if(lowAces.stream().anyMatch(c -> c == card)){
						sum += card.getLowValue();
					}else{
						sum += card.getHighValue();
					}
				}
			}
			return sum;
		}
	}

}
