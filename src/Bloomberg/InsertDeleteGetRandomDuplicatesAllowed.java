package Bloomberg;

public class InsertDeleteGetRandomDuplicatesAllowed {
    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.out.println(rc.insert(1));
        System.out.println(rc.remove(2));
        System.out.println(rc.insert(2));
        System.out.println(rc.getRandom());
        System.out.println(rc.remove(1));
        System.out.println(rc.insert(2));
        System.out.println(rc.getRandom());


    }
}


class RandomizedCollection {

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {


        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {

        return 0;
    }
}
