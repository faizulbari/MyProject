class StringFunctions {

    public boolean isPalindrome(String s) {
        s =s.toLowerCase().replaceAll("[^a-z0-9]","");
        System.out.println("The String is after replace "+s);
        
        int l=0;
        int r=s.length()-1;
        
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
            
        }
        return true;
    }

    public static void main(String[] args)
    {
        /*String str = "1Too hot to hoot1.***.   ";
        StringFunctions s = new StringFunctions();
        if(s.isPalindrome(str))
        {
            System.out.println("The String is polindrom");
        }
        else
        {
            System.out.println("The String is NO polingrome");
        }*/

        String s1 = "Ayisha";
        //s1 = s1.concat(" Siddiqa");
        System.out.println(s1);

        String s2 = "Ayisha";
        System.out.println(s2);

        if(s1 == s2)
            System.out.println("s1 == s2 is true");
        else
            System.out.println("s1 == s2 is false");

        if(s1.equals(s2))
            System.out.println("s1 equals s2 is true");
        else
            System.out.println("s1 equals s2 is false");

        StringBuffer sb1 = new StringBuffer("Hello");
        sb1.append("world");

        System.out.println(sb1);

    }
}