package Practice;

public class trycatch {
	private String name;

	/*
	 * public static void main(String[] args) { int n = 9; int m = 0; try { int ans
	 * = n/m; System.out.println("answer: "+ans);
	 * 
	 * } catch (ArithmeticException e) {
	 * System.out.println("Error: "+e.getMessage()); } }
	 * 
	 * }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		trycatch obj = new trycatch();
		obj.setName("pradeep");
		System.out.println(obj.getName());

		/*
		 * String str="Republic";
		 * 
		 * String str1=str.substring(5);
		 * 
		 * System.out.println(str1);
		 * 
		 * char ch= str.charAt(1); String str2= str.substring(1,4);
		 * 
		 * System.out.println(ch); System.out.println(str2); int str3 = str.indexOf('e',
		 * -1); System.out.println(str3);
		 */
		/*
		 * String str2="Java ";
		 * 
		 * String str1="Java Selenium";
		 * 
		 * int x= str1.compareTo(str2);
		 * 
		 * System.out.println(x);
		 */

		/*
		 * String str="Java is easy";
		 * 
		 * String []s1=str.split(" ");
		 * 
		 * for(String x:s1) { String rev=""; for(int i=x.length()-1; i>=0; i--) { rev=
		 * rev+x.charAt(i); } System.out.println(rev+ " "); }
		 */

		/*
		 * String str="abcd@#$%1234ABCD";
		 * 
		 * str=str.replaceAll("[^a-zA-Z0-9]", "");
		 * 
		 * System.out.println(str);
		 */

		/*
		 * String str="India"; /// Through String literal
		 * 
		 * String str1="India";
		 * 
		 * String str3=new String ("Nepal");
		 * 
		 * String str4=new String ("Nepal");
		 * 
		 * System.out.println(str==str1);
		 * 
		 * System.out.println(str3==str4);
		 * 
		 * String str5= new String("India").intern();
		 * 
		 * System.out.println(str==str5);
		 */

		/*
		 * int[] a = { 12, 56, 3, 9, 34 };
		 * 
		 * for (int i = 0; i < a.length; i++) { for (int j = i + 1; j < a.length; j++)//
		 * j=5 { if (a[i] < a[j])/// { int temp = a[i]; a[i] = a[j]; a[j] = temp;
		 * 
		 * } } }
		 * 
		 * for (int x : a) { System.out.print(x + " "); }
		 */
		/*
		 * String word = "tomorrow"; StringBuilder sb = new StringBuilder();
		 * 
		 * int count = 1;
		 * 
		 * for (char ch : word.toCharArray()) {
		 * 
		 * if (ch == 'o') {
		 * 
		 * for (int i = 0; i < count; i++) //i=0,0<3//1<3//2<3 { sb.append("@");// }
		 * count++;//count=2 }
		 * 
		 * else { sb.append(ch); } }
		 * 
		 * System.out.println(sb.toString());
		 * 
		 */
	
		
	}

}
