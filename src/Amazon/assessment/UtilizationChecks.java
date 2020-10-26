package Amazon.assessment;

import java.util.Arrays;
import java.util.List;

public class UtilizationChecks {
    public static void main(String[] args) {
        List<Integer> averageUtil = Arrays.asList(25,23,1,2,3,4,5,6,7,8,9,10,76,80);
        int instances = 2;
        System.out.println(finalInstances(instances, averageUtil));
    }
    private static final int LIMIT = 2 * 100_000_000;

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        for (int i = 0; i < averageUtil.size(); i++) {
            int util = averageUtil.get(i);
            if (util < 25) {
                if (instances > 1) {
                    instances = instances / 2 + ((instances % 2 == 0) ? 0 : 1);
                    i += 10;
                }
            } else if (util > 60) {
                int newInstances = 2 * instances;
                if (newInstances <= LIMIT) {
                    instances = newInstances;
                    i += 10;
                }
            }
        }
        return instances;
    }
}
