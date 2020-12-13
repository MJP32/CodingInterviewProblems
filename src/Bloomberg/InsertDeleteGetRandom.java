package Bloomberg;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());


    }
}


class RandomizedSet {
    Set<Integer> randomSet;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        randomSet= new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(randomSet.contains(val)){
            return false;
        }
        randomSet.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomSet.contains(val)){
            randomSet.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = randomSet.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(int obj : randomSet)
        {
            if (i == item)
                return obj;
            i++;
        }
        return -1;
    }
}
