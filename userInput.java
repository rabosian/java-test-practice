
public class userInput {
    public static class TextInput {
        protected StringBuilder currentVal;

        public TextInput() {
            currentVal = new StringBuilder();
        }

        public void add(char c) { // adds given char to current value
            this.currentVal.append(c);
        }

        public String getValue() { // returns current value
            return this.currentVal.toString();
        }
    }

    public static class NumericInput extends TextInput {
        public NumericInput() {
            super();
        }

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                this.currentVal.append(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
