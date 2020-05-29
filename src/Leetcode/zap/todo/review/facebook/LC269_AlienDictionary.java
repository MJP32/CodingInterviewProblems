package Leetcode.zap.todo.review.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC269_AlienDictionary {

    public static void main(String[] args) {
        String[] words = new String[]{"wrt","wrf","er","ett","rftt"};

        System.out.println(new LC269_AlienDictionary().alienOrder(words));

    }

    public String alienOrder(String[] words) {

        return "";

    }

    static class LetterGraph{

        public List<Letter> nodes;
        public Map<Character, Letter> graph;

        public LetterGraph(String word){
            nodes = new ArrayList<Letter>();
            graph = new HashMap<>();

            for(Character c : word.toCharArray()){
                addNode(c);
            }
        }

        public void addNode(Character c){
            graph.put(c, new Letter(c));
            nodes.add(graph.get(c));
        }
        public void addPrereq(Character c, Character prereq){
            Letter letter = getNode(c);
        }
        public Letter getLetter(Character letter){
            if(!graph.containsKey(letter)){
                addNode(letter);
            }
            return graph.get(letter);
        }
        public Letter getNode(Character c){
            if(!graph.containsKey(c)){
                addNode(c);
            }
            return graph.get(c);
        }



    }

    static class Letter{
        char letter;
        boolean visited;
        boolean visiting;
        public List<Letter> prereqs;

        public Letter(char letter){
            this.letter = letter;
            this.visited = false;
            this.visiting = false;
            this.prereqs = new ArrayList<Letter>();


        }
    }
    }

