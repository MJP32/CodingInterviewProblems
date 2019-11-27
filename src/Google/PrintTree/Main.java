package Google.PrintTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Relation> list = new ArrayList<>();
        list.add(new Relation("animal", "mammal"));
        list.add(new Relation("animal", "mammal"));
        list.add(new Relation("animal", "reptile"));
        list.add(new Relation("mammal", "cat"));
        list.add(new Relation("cat", "lion"));
        list.add(new Relation("lifeform", "animal"));

        TreePrinter.printTree(list);
    }
}
