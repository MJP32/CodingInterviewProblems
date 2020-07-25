package Pramp;

import java.util.*;

public class ShortestWordEditPath {
    static int shortestWordEditPath(String source, String target, String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : words) {
            char[] array = s.toCharArray();
            for (int i=0; i<array.length; i++) {
                char ch = array[i];
                array[i] = '*';
                String word = new String(array);
                if (!map.containsKey(new String(array))) {
                    map.put(word, new ArrayList<>());
                }
                map.get(word).add(s);
                array[i] = ch;
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(source);

        Set<String> visited = new HashSet<>();//bit,
        visited.add(source);
        int currentLevel = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                System.out.println(word);
                if (word.equals(target)) return currentLevel;
                char[] array = word.toCharArray();

                for (int j=0; j<array.length; j++) {
                    char ch = array[j];
                    array[j] = '*';
                    String s = new String(array);
                    if (map.containsKey(s)) {//*it ->
                        for (String w : map.get(s)) {
                            if (!visited.contains(s)) {
                                queue.add(w);
                                visited.add(w);
                            }
                        }
                    }
                    array[j] = ch;
                }
            }
            currentLevel++;

        }
        return -1;
    }


    static int shortestWordEditPath2(String source, String target, String[] words) {
        // your code goes here
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);

        //bit -> but -> big ->
        int count =0;
        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i =0; i < size;i++){

                String currWord = queue.poll();

                if(currWord.equals(target)){
                    return count+1;
                }


                for(int j =0; j < currWord.length();j++){

                    for(char next ='a'; next <='z';next++){
                        if(currWord.charAt(j) == next)
                            continue;
                        StringBuilder sb = new StringBuilder(currWord);
                        sb.setCharAt(j, next);

                        if(set.contains(sb.toString())){
                            set.remove(sb.toString());
                            queue.add(sb.toString());
                        }
                    }
                }

            }
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
//        System.out.println(shortestWordEditPath("bit", "dog", new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"}));
        System.out.println(shortestWordEditPath("bit", "dog", new String[]{"but", "put", "big", "pot", "pog", "dog",
                "lot"}));
    }
}
