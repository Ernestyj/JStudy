package onlinealgo;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by eugene on 16/4/8.
 */
public class Solu2 {

    public static void main(String[] args) {

    }

    class Account{
        private BigDecimal deposit;
        public synchronized BigDecimal getDeposit() {
            return deposit;
        }
        public synchronized void setDeposit(BigDecimal deposit) {
            this.deposit = deposit;
        }
        public synchronized boolean transferOut(BigDecimal out){
            if (this.deposit.compareTo(out)<0) return false;
            else{
                this.deposit.subtract(out);
                return true;
            }
        }
        public synchronized void transferIn(BigDecimal in){
            this.deposit.add(in);
        }

    }
    public synchronized boolean transfer(Account out, Account in, BigDecimal money){
        boolean isSuccess = out.transferOut(money);
        if (isSuccess){
            in.transferIn(money);
            return true;
        }
        else return false;
    }

}
