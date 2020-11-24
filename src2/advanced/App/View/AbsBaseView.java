package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

abstract public class AbsBaseView {
    public void displayResult(String message) {
        System.out.println(message);
    }

    public abstract void execute(Scanner scanner, HashMap<String, Object> valueMap);
}
