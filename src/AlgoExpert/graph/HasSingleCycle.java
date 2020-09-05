package AlgoExpert.graph;

public class HasSingleCycle {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1, -4, -4, 2};
        System.out.println(hasSingleCycle(array));
    }
    public static boolean hasSingleCycle(int[] array){
        int numElementsvisited =0;
        int currentIdx =0;
        while(numElementsvisited < array.length){
            if (numElementsvisited > 0 && currentIdx ==0)
                return false;
            numElementsvisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx ==0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        return nextIdx >=0 ? nextIdx :nextIdx+array.length;
    }
}
