package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String [] args) {
        TextJustification textJustification = new TextJustification();
//        System.out.println(textJustification.fullJustify(
//                new String[] {
//                        "This", "is", "an", "example", "of", "text", "justification."
//                },
//                16
//        )); //["This    is    an","example  of text","justification.  "]
//        System.out.println(textJustification.fullJustify(
//                new String[] {
//                        "What","must","be","acknowledgment","shall","be"
//                },
//                16
//        ));
        System.out.println(textJustification.fullJustify(
                new String[] {
                        "ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"
                },
                16
        ));
//        System.out.println(textJustification.fullJustify(
//                new String[] {
//                        "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
//                },
//                20
//        )); //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int lineLength = 0;
        List<String> wordlist = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; ++i) {
            lineLength += words[i].length();
            wordlist.add(words[i]);
            if (lineLength + wordlist.size() - 1 > maxWidth) {
                StringBuilder sb = new StringBuilder();
                lineLength -= wordlist.getLast().length();
                int spacesLeft = maxWidth - lineLength;
                int slotsLeft = ((wordlist.size() - 1) - 1);
                int spacesBetween = spacesLeft / (slotsLeft == 0 ? 1 : slotsLeft);
                int spacesBetweenStart = (spacesLeft % (slotsLeft == 0 ? 1 : slotsLeft)) != 0
                        ?
                        spacesBetween + 1 :
                        spacesBetween;
                if(slotsLeft == 0) {
                    sb.append(wordlist.get(wordlist.size() - 2));
                    sb.append(" ".repeat(spacesLeft));
                }else {
                    for(int j = 0; j < wordlist.size() - 1; ++j) {
                        sb.append(wordlist.get(j));
                        if(j < wordlist.size() - 2) {
                            if((spacesBetween * slotsLeft) == spacesLeft) {
                                sb.append(" ".repeat(spacesBetween));
                                spacesLeft -= spacesBetween;
                            }else{
                                sb.append(" ".repeat(spacesBetweenStart));
                                spacesLeft -= spacesBetweenStart;
                            }
                            --slotsLeft;
                        }
                    }
                }
                ans.add(sb.toString());
                if(i == words.length - 1) {
                    sb = new StringBuilder();
                    sb.append(wordlist.getLast());
                    while(sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                }
                String last = wordlist.getLast();
                wordlist.clear();
                wordlist.add(last);
                lineLength = last.length();
            } else if (i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < wordlist.size(); ++j) {
                    String word = wordlist.get(j);
                    sb.append(word);
                    if(j < wordlist.size() - 1) {
                        sb.append(" ");
                    }
                }
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
            }
        }
        return ans;
    }

    public List<String> fullJustify2(String[] words, int maxWidth) {
        int lineLength = 0;
        List<String> wordlist = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; ++i) {
            lineLength += words[i].length();
            wordlist.add(words[i]);
            if(lineLength + wordlist.size() - 1 == maxWidth) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < wordlist.size(); ++j) {
                    sb.append(wordlist.get(j));
                    if(j < wordlist.size() - 1) {
                        sb.append(" ");
                    }
                }
                ans.add(sb.toString());
                wordlist.clear();
                lineLength = 0;
            } else if (lineLength + wordlist.size() - 1 > maxWidth) {
                StringBuilder sb = new StringBuilder();
                if(wordlist.size() - 1 == 1) {
                    sb.append(wordlist.get(wordlist.size() - 2));
                    while(sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                }else{
                    lineLength -= wordlist.getLast().length();
                    int spacesBetween = (maxWidth  - lineLength) / ((wordlist.size() - 1) - 1);
                    int spacesBetweenStart = (maxWidth  - lineLength) % ((wordlist.size() - 1) - 1) != 0
                            ?
                            spacesBetween + 1 :
                            spacesBetween;
                    int spacesLeft = maxWidth - lineLength;
                    int slotsLeft = ((wordlist.size() - 1) - 1);
                    for(int j = 0; j < wordlist.size() - 1; ++j) {
                        sb.append(wordlist.get(j));
                        if(j < wordlist.size() - 2) {
                            if((spacesBetween * slotsLeft) == spacesLeft) {
                                sb.append(" ".repeat(spacesBetween));
                                spacesLeft -= spacesBetween;
                            }else{
                                sb.append(" ".repeat(spacesBetweenStart));
                                spacesLeft -= spacesBetweenStart;
                            }
                            --slotsLeft;
                        }
                    }
                }
                ans.add(sb.toString());
                if(i == words.length - 1) {
                    sb = new StringBuilder();
                    sb.append(wordlist.getLast());
                    while(sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                }
                String last = wordlist.getLast();
                wordlist.clear();
                wordlist.add(last);
                lineLength = last.length();
            } else if (i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                for(String word : wordlist) {
                    sb.append(word);
                    sb.append(" ");
                }
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
            }
        }
        return ans;
    }

}
