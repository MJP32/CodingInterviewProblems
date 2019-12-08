package Leetcode.Leetcode_108;



public class SortedArrayToBST {
    public static void main(String[] args) {

        sortedArrayToBST(new int[]{1,2,3,4,5});
    }

    public static TreeNode sortedArrayToBST(int[] nums){

        if(nums.length==0){
            return null;
        }

        return contructTreeFromaArray(nums,0,nums.length-1);


    }

    private static TreeNode contructTreeFromaArray(int[] nums, int start, int end) {


        if(start > end){
            return null;
        }


        int mid = (start+ end)/2;


        TreeNode node = new TreeNode(nums[mid]);

        node.left = contructTreeFromaArray(nums,start, mid -1);
        node.right = contructTreeFromaArray(nums,mid+1, end);


        return node;

    }
}
