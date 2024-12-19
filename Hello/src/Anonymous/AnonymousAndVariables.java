package Anonymous;

public class AnonymousAndVariables {
    public static void main(String arg[])
    {
        OutterClass out = new OutterClass();
        out.createAnonymousInnerClass();
        out.createShadowVariableClass();
    }
}

interface InnerInterface{
    void printMessage();
}

class OutterClass{
    String message = "outter class member variable message";

    void createAnonymousInnerClass()
    {
        int methodLocalVariable = 5;
        //methodLocalVariable++;

        InnerInterface inner = new InnerInterface() {
            @Override
            public void printMessage() {
                System.out.println("Inner class method accessed" + message);
                // outter method should be final or effectively final
                System.out.println("Inner method variable " + methodLocalVariable);
            }
        };
        inner.printMessage();
    }

    void createShadowVariableClass()
    {
        String message = "local method member variable message";

        InnerInterface inner1 = new InnerInterface() {
            String message = "inner class member variable message";
            @Override
            public void printMessage() {
                System.out.println("accessing member " + message);
                //inorder to access outter class variable with the same name
                System.out.println("outter accessing member " + OutterClass.this.message);
            }
        };
        inner1.printMessage();
    }

}