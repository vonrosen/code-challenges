package org.hunter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlphaBase52 {
    private static final List<Character> ALPHABET_UPPER = List.of(
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G',
            'H',
            'I',
            'J',
            'K',
            'L',
            'M',
            'N',
            'O',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'U',
            'V',
            'W',
            'X',
            'Y',
            'Z'
    );
    private static final List<Character> ALPHABET = Stream.concat(
            ALPHABET_UPPER.stream(),
            ALPHABET_UPPER
                    .stream()
                    .map(Character::toLowerCase))
            .collect(Collectors.toList());

    private final String value;

    private AlphaBase52(String value){
        this.value = value;
    }

    public static void main(String [] args){
//        System.out.println(AlphaBase52.valueOf(0));//A
//        System.out.println(AlphaBase52.valueOf(10));//K
//        System.out.println(AlphaBase52.valueOf(51));//z
//        System.out.println(AlphaBase52.valueOf(52));//AA
//        System.out.println(AlphaBase52.valueOf(53));//AB
//        System.out.println(AlphaBase52.valueOf(78));//Aa
//        System.out.println(AlphaBase52.valueOf(1555444421));

//        System.out.println(AlphaBase52.valueOf(155544442139L));
//        System.out.println(AlphaBase52.valueOf(155544442140L));
//        System.out.println(AlphaBase52.valueOf(155544442141L));
//        System.out.println(AlphaBase52.valueOf(155544442142L));
//        System.out.println(AlphaBase52.valueOf(155544442143L));
//        System.out.println(AlphaBase52.valueOf(155544442144L));

//        System.out.println(AlphaBase52.valueOf(2703));
//        System.out.println(AlphaBase52.valueOf(2704));
        System.out.println(AlphaBase52.valueOf(2703));
//        System.out.println(AlphaBase52.valueOf(2755));//zAz
//        System.out.println(AlphaBase52.valueOf(2756));//should be zBA but is BAA , 2756 / 52 = 53, 2755 / 52 = 52
//        System.out.println(AlphaBase52.valueOf(2757));


        //Math.pow(155544442144d, -52);
        //IcfFtGo


//        for(int i = 100; i < 200; ++i){
//            System.out.println(AlphaBase52.valueOf(i));
//        }
    }

    //O(n log 52)
    public static AlphaBase52 valueOf(long value){
        long quotient = value;
        StringBuilder sb = new StringBuilder();
        while(true){
            quotient /= ALPHABET.size();
            if(quotient > 0){
                if(quotient > ALPHABET.size()){
                    int rem = (int)value % ALPHABET.size();
                    sb.append(ALPHABET.get((ALPHABET.size() - rem - 1)));
                }else{
                    sb.append(ALPHABET.get((int)(quotient - 1)));
                }
            }else{
                int rem = (int)value % ALPHABET.size();
                sb.append(ALPHABET.get(rem));
                break;
            }
        }
        return new AlphaBase52(sb.toString());
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof AlphaBase52)){
            return false;
        }
        AlphaBase52 that = (AlphaBase52) object;
        if(that.value == null && this.value == null){
            return true;
        }
        if(this.value == null){
            return false;
        }
        if(that.value == null){
            return false;
        }
        return this.value.equals(that.value);
    }
}
