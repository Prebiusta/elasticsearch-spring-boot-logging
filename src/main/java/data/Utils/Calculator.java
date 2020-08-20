package data.Utils;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double sq(int a) {
        return Math.sqrt(a);
    }
}
