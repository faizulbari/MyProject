package StringBuffer;// Java program to demonstrate
// the ensureCapacity() Method.

class GFG {
	public static void main(String[] args)
	{

		StringBuffer sb = new StringBuffer("Hello");
		System.out.println("size="+sb.length()+"capacity="+sb.capacity()); // default 16
		sb.append("HelloAyishaSiddiqa");
		System.out.println("size="+sb.length()+"capacity="+sb.capacity()); // now 16
		sb.append("java is my favourite language");
		System.out.println("size="+sb.length()+"capacity="+sb.capacity());
		sb.append("java is my favourite language");
		System.out.println("size="+sb.length()+"capacity="+sb.capacity());
		sb.append("java is my favourite language");
		System.out.println("size="+sb.length()+"capacity="+sb.capacity());
		System.out.println("SB=" + sb);
		// create a StringBuffer object
		StringBuffer
			str
			= new StringBuffer("Geeks For Geeks");

		// print string capacity
		System.out.println("Before ensureCapacity "
						+ "method capacity = "
						+ str.length()
						+ str.capacity());

		// apply ensureCapacity()
		str.ensureCapacity(42);

		// print string capacity
		System.out.println("After ensureCapacity"
						+ " method capacity = "
						+ str.capacity());
	}
}
