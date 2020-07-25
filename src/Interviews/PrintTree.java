package Interviews;

import java.util.*;

public class PrintTree {
    public static void main(String[] args) {
        List<Relation> input = new ArrayList<>();
        input.add(new Relation("animal", "mammal"));
        input.add(new Relation("animal", "bird"));
        input.add(new Relation("lifeform", "animal"));
        input.add(new Relation("cat", "lion"));
        input.add(new Relation("mammal", "cat"));
        input.add(new Relation("animal", "fish"));
        printTree(input);
    }

    private static void printTree(List<Relation> input) {

        Map<String, List<String>> map = new HashMap<>();

        Set<String> childSet = new HashSet<>();

        for (Relation rel : input) {
            if (!map.containsKey(rel.parent)) {
                map.put(rel.parent, new ArrayList<>());
            }
            map.get(rel.parent).add(rel.child);

            childSet.add(rel.child);
        }
        String root = null;
        for (String k : map.keySet()) {

            if (!childSet.contains(k)) {
                root = k;
            }
        }
        dfs(root, 0, map);
    }

    private static void dfs(String root, int depth, Map<String, List<String>> map) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(root);
        List<String> children;
        if (map.containsKey(root)) {
            children = map.get(root);
        } else {
            return;
        }

        for (String child : children) {
            dfs(child, depth + 1, map);
        }

    }


}

class Relation {
    String parent;
    String child;

    public Relation(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}
