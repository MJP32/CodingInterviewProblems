package AlgoExpert.binarytrees;

public class YoungestCommonAncestor {

    public static void main(String[] args) {

    }
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        //get depth from root to see which is closer to root
        int depthOne = getDepths(topAncestor, descendantOne);
        int depthTwo = getDepths(topAncestor, descendantTwo);
        System.out.println(depthOne);
        System.out.println(depthTwo);
        return topAncestor;
    }

    private static int getDepths(AncestralTree topAncestor, AncestralTree descendant) {
        int count=0;
        while(descendant != topAncestor){
            count++;
            descendant =descendant.ancestor;
        }
        return count;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
