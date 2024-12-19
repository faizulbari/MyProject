public class AddBinary {
    public static String addBinary(String a, String b) {
        // StringBuilder to store the result of the binary sum
        StringBuilder result = new StringBuilder();
        // Indices to iterate through the strings from the end to the start
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        // Carry will be used for the addition if the sum of two bits is greater than 1
        int carry = 0;
        // Loop until all characters are processed or there is no carry left
        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            // If still within the bounds of string a, add the numeric value of the bit to carry
            if (indexA >= 0) {
                carry += a.charAt(indexA) - '0';
                indexA--; // Decrement index for string a
            }
            // If still within the bounds of string b, add the numeric value of the bit to carry
            if (indexB >= 0) {
                carry += b.charAt(indexB) - '0';
                indexB--; // Decrement index for string b
            }
            // Append the remainder of dividing carry by 2 (either 0 or 1) to the result
            result.append(carry % 2);
            // Carry is updated to the quotient of dividing carry by 2 (either 0 or 1)
            carry /= 2;
        }
        // Since the bits were added from right to left, the result needs to be reversed to match the correct order
        return result.reverse().toString();
    }

    public static void main(String args[]){
        String strA = "101011";
        String strB = "101011";
        System.out.println(addBinary(strA,strB));

    }
}
