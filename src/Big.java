import java.util.*;

public class Big {

    ArrayList<Integer> num = new ArrayList<Integer>();

    Big(boolean rand) {
        if(rand) {
            num.add((int) (Math.random() * 5) * 2 + 1);
            for(int i = 0; i < 299; i++) {
                num.add((int) (Math.random() * 10));
            }
        } else {
            num.add(0);
        }
    }

    Big(ArrayList<Integer> num) {
        this.num = num;
    }

    Big(Big num) {
        this.num = num.getArr();
    }

    public ArrayList<Integer> getArr() {
        return num;
    }

    public int getDigit(int index) {
        int ans;
        if(index < num.size()) {
            ans = num.get(index);
        } else {
            ans = 0;
        }
        return ans;
    }

    public void setBig(int index, int element) {
        while(num.size() < index + 1) {
            num.add(0);
        }
        num.set(index, element);
    }

    /*
    public Big plus(Big num2) {
        int ansSize = 0;
        int sizeDif = 0;

        if(num.size() > num2.getArr().size()) {
            ansSize = num2.getArr().size();
            sizeDif = num.size() - num2.getArr().size();
        }
        if(num.size() < num2.getArr().size()) {
            ansSize = num.size();
            sizeDif = num2.getArr().size() - num.size();
        } else if(num.get(num.size() - 1) + num2.getArr().get(num2.getArr().size() - 1) > 9) {
            ansSize = num.size() + 1;
        }

        Big ans = new Big(false);

        for(int i = 0; i < ansSize; i++) {
            if (num.get(i) + num2.getArr().get(i) > 9) {
                ans.setBig(i + 1, 1);
                ans.setBig(i, ans.getArr().get(i) + num.get(i) + num2.getArr().get(i) - 10);
            } else {
                ans.setBig(i, 0);
                ans.setBig(i, ans.getArr().get(i) + num.get(i) + num2.getArr().get(i));
            }
        }
        return ans;
    }
    */

    public void printBig() {
        for(int i = num.size() - 1; i > -1; i--) {
            System.out.print(num.get(i));
        }
        System.out.print("\n");
    }

    public Big plus(Big num2) {

        Big ans = new Big(false);
        int index = 0;
        boolean adding = index < num.size() || index < num2.getArr().size();

        while(adding) {
            if (this.getDigit(index) + num2.getDigit(index) + ans.getDigit(index) > 9) {
                ans.setBig(index + 1, 1);
                ans.setBig(index, this.getDigit(index) + num2.getDigit(index) + ans.getDigit(index) - 10);
            } else {
                ans.setBig(index, this.getDigit(index) + num2.getDigit(index) + ans.getDigit(index));
            }
            index++;
            adding = index < num.size() || index < num2.getArr().size();
        }
        return ans;
    }

}
