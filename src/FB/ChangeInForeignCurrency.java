package FB;

public class ChangeInForeignCurrency {
    public static void main(String[] args) {
        System.out.println(new ChangeInForeignCurrency().canGetExactChange(74, new int[]{5, 10, 25, 100, 200}));
        System.out.println(new ChangeInForeignCurrency().canGetExactChange(75, new int[]{4, 17, 29}));
    }
    boolean canGetExactChange(int targetMoney, int[] denominations) {

        if(targetMoney < 0){
            return false;
        }
        if(targetMoney == 0){
            return true;
        }
        for(int i =0;i<denominations.length;i++){
            if(canGetExactChange(targetMoney - denominations[i],denominations)){
                return true;
            }
        }
        return false;
    }


}
