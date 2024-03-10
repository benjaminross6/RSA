import java.math.*;
import java.util.*;
import java.util.function.DoubleToLongFunction;

public class RSAEncryptor {
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            BigInteger num = new BigInteger(Long.toString((long) (Long.MAX_VALUE * Math.random())));
            if(isPrime(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean isPrime(BigInteger num) {
        return BigInteger.TWO.modPow(num, num).equals(BigInteger.ZERO);
    }
}
