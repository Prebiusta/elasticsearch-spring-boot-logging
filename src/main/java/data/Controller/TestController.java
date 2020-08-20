package data.Controller;

import data.Utils.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final Calculator calculator;

    public TestController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/anotherTest")
    public int test() {
        return calculator.subtract(calculator.add(5, (int)calculator.sq(9)), 1);
    }
}
