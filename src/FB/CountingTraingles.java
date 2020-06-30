package FB;

import java.util.*;
import java.util.stream.Collectors;

public class CountingTraingles {
    public static void main(String[] args) {
        ArrayList<Sides> s1 = new ArrayList<>();
        s1.add(new Sides(2, 2, 3));
        s1.add(new Sides(3, 2, 2));
        s1.add(new Sides(2, 5, 6));


        System.out.println(new CountingTraingles().countDistinctTriangles2(s1));

    }

    int countDistinctTriangles2(ArrayList<Sides> arr) {
        System.out.println("\n2.Sort list of person objects by firstName then "
                + "by lastName then by age");
        Comparator<Sides> sortByA
                = Comparator.comparingInt(p -> p.a);
        Comparator<Sides> sortByB
                = Comparator.comparingInt(p -> p.b);
        Comparator<Sides> sortByC
                = Comparator.comparingInt(p -> p.c);

        //Sort by first Name then Sort by last name then sort by age
        List<Sides> sortedList = arr
                .stream()
                .sorted(
                        sortByA
                                .thenComparing(sortByB)
                                .thenComparing(sortByC)
                )
                .collect(Collectors.toList());

        int count = 0;
        for(int i =1;i< sortedList.size();i++){
            if(sortedList.get(i).a ==sortedList.get(i-1).a && sortedList.get(i).b == sortedList.get(i-1).b &&
                    sortedList.get(i).c ==sortedList.get(i-1).c){
                count++;
            }
        }
        sortedList.forEach(k-> System.out.println(k));

        return sortedList.size() - count;
    }
    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here

        Set<Sides> sortedList = arr.stream()
                //.sorted(Comparator.comparing(Sides -> Sides.a))
                .collect(Collectors.toSet());

        sortedList.forEach(k -> System.out.println(k));

        System.out.println();
        Set<Sides> set = new HashSet<>(arr);
        List<String> listOfString = Arrays.asList("C", "C", "C++", "Go", "JavaScript", "Python", "Scala");

        Set<String> setOfStringStartsWithC
                = listOfString.stream()
                //.filter(s -> s.startsWith("C"))
                .collect(Collectors.toSet());

        setOfStringStartsWithC.forEach(k-> System.out.println(k));


        for (Sides s : set) {
            //System.out.println(s);
        }

        //set.forEach(k-> System.out.println(k));

        return 1;
    }


    static class Sides {
        int a;
        int b;
        int c;

        Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Sides{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }


    }
}
