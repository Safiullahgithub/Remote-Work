public class literal {

    public static void main(String[] args) {
        // Integer literals
        int intValue = 10;
        int binaryValue = 0b1010; // binary literal
        int octalValue = 012;     // octal literal
        int hexValue = 0xA;       // hexadecimal literal

        System.out.println("Integer literals:");
        System.out.println("Decimal: " + intValue);
        System.out.println("Binary: " + binaryValue);
        System.out.println("Octal: " + octalValue);
        System.out.println("Hexadecimal: " + hexValue);

        // Floating-point literals
        double doubleValue = 3.14;
        float floatValue = 2.0f;   // float literal

        System.out.println("\nFloating-point literals:");
        System.out.println("Double: " + doubleValue);
        System.out.println("Float: " + floatValue);

        // Boolean literals
        boolean trueValue = true;
        boolean falseValue = false;

        System.out.println("\nBoolean literals:");
        System.out.println("true: " + trueValue);
        System.out.println("false: " + falseValue);

        // Character literals
        char charValue = 'A';

        System.out.println("\nCharacter literals:");
        System.out.println("Character: " + charValue);

        // String literals
        String stringValue = "Hello, Java!";

        System.out.println("\nString literals:");
        System.out.println("String: " + stringValue);

        // Null literal
        Object nullValue = null;

        System.out.println("\nNull literal:");
        System.out.println("Null: " + nullValue);
    }
}
