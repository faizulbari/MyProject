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
        String str = "1Too hot to hoot1.***.   ";
        StringFunctions s = new StringFunctions();
        if(s.isPalindrome(str))
        {
            System.out.println("The String is polindrom");
        }
        else
        {
            System.out.println("The String is NO polingrome");
        }

    }
}