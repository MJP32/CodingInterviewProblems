package AlgoExpert.assessment;

public class DegreesOfSeparation {
    /*public static void main(String[] args) {

        Map<String, String[]> map = new HashMap<>();

        map.put("Aaron", new String[]{"Paul"});
        map.put("Akshay", new String[]{});
        map.put("Alex", new String[]{"Antoine", "Clement", "Ryan", "Simon"});
        map.put("Antoine", new String[]{"Alex", "Clement", "Simon"});
        map.put("Ayushi", new String[]{"Lee"});
        map.put("Changpeng", new String[]{"Kelly", "Sandeep"});
        map.put("Clement", new String[]{"Alex", "Antoine", "Sandeep", "Simon"});
        map.put("Hannah", new String[]{"Lexi", "Paul", "Sandeep"});
        map.put("James", new String[]{"Paul"});
        map.put("Kelly", new String[]{"Changpeng", "Molly"});
        map.put("Lee", new String[]{"Ayushi", "Molly"});
        map.put("Lexi", new String[]{"Hannah"});
        map.put("Molly", new String[]{"Kelly", "Lee"});
        map.put("Paul", new String[]{"Aaron", "James", "Hannah"});
        map.put("Ryan", new String[]{"Alex"});
        map.put("Sandeep", new String[]{"Changpeng", "Clement", "Hannah"});
        map.put("Simon", new String[]{"Alex", "Antoine", "Clement"});

        System.out.println(degreesOfSeparation(map, "Antoine", "Clement"));

    }

    public static String degreesOfSeparation(
            Map<String, String[]> friendsLists, String personOne, String personTwo) {

       var degreeOne = getDegreesofSeparation(friendsLists, personOne);
       var degreeTwo = getDegreesofSeparation(friendsLists, personTwo);
       var numDegreesOverSixOne = getNumDegreesOverSix(friendsLists,degreeOne);
       var numDegreesOverSixTwo = getNumDegreesOverSix(friendsLists,degreeTwo);
        if (numDegreesOverSixOne==numDegreesOverSixTwo) {
            return "";
        }
        return numDegreesOverSixOne <numDegreesOverSixTwo?personOne:personTwo;

    }

    private static int getNumDegreesOverSix(Map<String, String[]> friendsLists, Map<String, Integer> degrees) {
        var numDegreesOverSix =0;
        for (var person : friendsLists.keySet()) {
            var distance = degrees.get(person);
            if (distance >6) {
                numDegreesOverSix++;
            }
        }
        return numDegreesOverSix;
    }

    private static Map<String,Integer> getDegreesofSeparation(Map<String, String[]> friendsLists, String origin) {
        var degrees = new HashMap<String,Integer>();
        var visited = new HashSet<String>();
        var queue = new ArrayDeque<PersonInfo>();
        queue.add(new PersonInfo(origin,0));
        while (queue.size() >0) {
            var info = queue.pollFirst();
            degrees.put(info.person,info.degree);
            for(var friend : friendsLists.get(info.person)){

                if (visited.contains(friend)) {
                    continue;
                }
                visited.add(friend);
                queue.add(new PersonInfo(friend, info.degree+1));
            }
        }
        for (var person : friendsLists.keySet()) {
            if (!visited.contains(person)) {
                degrees.put(person, Integer.MAX_VALUE);
            }
        }
        return degrees;
    }

    static class PersonInfo {
        public String person;
        public int degree;

        public PersonInfo(String person, int degree) {
            this.person = person;
            this.degree = degree;
        }

    }*/
}
