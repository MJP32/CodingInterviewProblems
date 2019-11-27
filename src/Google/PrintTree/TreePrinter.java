package Google.PrintTree;

import java.util.*;

public class TreePrinter {
    public static void printTree(List<Relation> list) {

        Map<String, List<String>> map = new HashMap<>();
        List<String> newList;
        Set<String> children = new HashSet<>();


        for (Relation rel : list) {
            //add child to set
            children.add(rel.child);
            //put in map
            if (map.containsKey(rel.parent))
                map.get(rel.parent).add(rel.child);
            else {
                newList = new ArrayList<>();
                newList.add(rel.child);
                map.put(rel.parent,newList);
            }
        }


        String root ="";

        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            if(!children.contains(entry.getKey())){
                root = entry.getKey();
                break;
            }
        }

        dfs(root, 0 ,map);



    }

    private static void dfs(String root, int level, Map<String, List<String>> map){

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(root);
        List<String> children;
        if(map.containsKey(root)){
            children= map.get(root);
        }
        else
            return;

        for(String child : children){
            dfs(child, level +1, map);
        }
    }
}
