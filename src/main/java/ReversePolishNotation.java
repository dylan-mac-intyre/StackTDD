public class ReversePolishNotation {

    private static final String DEFAULT_ERROR_MESSAGE = "Error: Incorrect Format";

    public boolean isANumber(String element) {
        return element.matches("[0-9]+");
    }

    public String performCalculation(String elements) {
        Stack robStack = new Stack(10);
        String[] splitElements = elements.split(" ");
        int stackReturnElement1, stackReturnElement2;

        for (int i = 0; i < splitElements.length; i++) {
            if (isANumber(splitElements[i])) {
                robStack.push(Integer.parseInt(splitElements[i]));
            } else if (robStack.size() > 1) {
                stackReturnElement1 = Integer.parseInt(String.valueOf(robStack.pop()));
                stackReturnElement2 = Integer.parseInt(String.valueOf(robStack.pop()));

                switch (splitElements[i]) {
                    case "+":
                        robStack.push(stackReturnElement1 + stackReturnElement2);
                        break;
                    case "-":
                        robStack.push(stackReturnElement2 - stackReturnElement1);
                        break;
                    case "*":
                        robStack.push(stackReturnElement2 * stackReturnElement1);
                        break;
                    case "/":
                        robStack.push(stackReturnElement2 / stackReturnElement1);
                        break;
                    default:
                        return DEFAULT_ERROR_MESSAGE;
                }
            } else {
                return DEFAULT_ERROR_MESSAGE;
            }
        }
        if (robStack.size() > 1) return DEFAULT_ERROR_MESSAGE;
        return String.valueOf(robStack.pop());
    }
}