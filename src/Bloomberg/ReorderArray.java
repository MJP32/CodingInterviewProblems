package Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderArray {
    public static void main(String[] args) {
        String[][] employees = {{"John", "Manager"}, {"Sally", "CTO"}, {"Sam", "CEO"}, {"Drax", "Engineer"}, {"Bob",
                "CFO"}, {"Daniel", "Engineer"}};
        String[][] management = {{"CTO", "CEO"}, {"Manager", "CTO"}, {"Engineer", "Manager"}, {"CFO", "CEO"}};

        reorderArray(employees, management);
    }

    private static void reorderArray(String[][] employees, String[][] management) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<String>> employeesMap = new HashMap<>();

        for (String[] title : management) {
            graph.putIfAbsent(title[1], new ArrayList<>());
            graph.get(title[1]).add(title[0]);
        }

        for (String[] emp : employees) {
            employeesMap.putIfAbsent(emp[0], new ArrayList<>());
            employeesMap.get(emp[0]).add(emp[1]);
        }

        graph.forEach((k, v) -> System.out.println(k+ ": " + v));
        System.out.println("---");
        employeesMap.forEach((k, v) -> System.out.println(k+ ": " + v));
    }
}
