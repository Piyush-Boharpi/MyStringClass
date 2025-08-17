package string;
import java.util.*;
@SuppressWarnings("serial") 
class MyStringIndexOutOfBoundsException extends RuntimeException
{
	public  MyStringIndexOutOfBoundsException(String message)
	{
		super(message);
	}	
}
final class MyString
{
	char[] arr;
	//No args Constructor
	public MyString()
	{
		arr = new char[0];
	}
	//String str constructor
	public MyString(String str)
	{
		arr = new char[str.length()];
		for(int i =0;i<str.length();i++)
		arr[i] = str.charAt(i);
	}
	//StringBuffer  Constructor
	public MyString(StringBuffer sb)
	{
		this(sb.toString());
	}
	//StringBuilder Constructor
	public MyString(StringBuilder sb)
	{
		this(sb.toString());
	}
	//char[]arr constructor
	public MyString(char[]arr)
	{
		this.arr = new char[arr.length];
		for(int i=0;i<arr.length;i++)
		  this.arr[i] = arr[i];
	}
	//byte[] arr constructor
	public MyString(byte[]arr)
	{ 
		this.arr = new char[arr.length];
		for(int i = 0; i < arr.length; i++) {
			this.arr[i] = (char) arr[i]; 
		}
		
	}
	//byte[] arr,int start,int count constructor
	public MyString(byte[] arr,int start,int count)
	{
		if((start+count)>arr.length) 
			throw new MyStringIndexOutOfBoundsException("INVALID ["+start+"+"+count+"]"
					+ " out of bound of length "+arr.length);
		this.arr = new char[count];
		for(int i = start,j =0;i<(start+count);i++,j++)
		{
			this.arr[j] = (char)arr[i];
		}
	}
	//int[] arr,int start,int count constructor
	public MyString(int[] arr,int start,int count)
	{
		if((start+count)>arr.length) 
			throw new MyStringIndexOutOfBoundsException("INVALID ["+start+"+"+count+"]"
					+ " out of bound of length "+arr.length);
		this.arr = new char[count];
		for(int i = start,j =0;i<(start+count);i++,j++)
		{
			this.arr[j] = (char)arr[i];
		}
	}
	//char[] arr,int start,int count constructor
	public MyString(char[] arr,int start,int count)
	{
		if((start+count)>arr.length) 
			throw new MyStringIndexOutOfBoundsException("INVALID ["+start+"+"+count+"]"
					+ " out of bound of length "+arr.length);
		this.arr = new char[count];
		for(int i = start,j =0;i<(start+count);i++,j++)
		{
			this.arr[j] = arr[i];
		}
	}
	// 1. length Method
	public int length()
	
	{
		return arr.length;
	}
	//2. isEmptyMethod
	public boolean isEmpty()
	{
		return arr.length ==0;
	}
	//3. charAt method
	public char charAt(int index)
	{
		if(index<0 ||index>=arr.length)
		throw new MyStringIndexOutOfBoundsException("INDEX ["+index+"]"
					+ " out of bound of length "+arr.length);
		return arr[index];
	}
	//4. codePointAt Method
	public int codePointAt(int index)
	{
		if(index<0 ||index>=arr.length)
			throw new MyStringIndexOutOfBoundsException("INDEX ["+index+"]"
						+ " out of bound of length "+arr.length);
			return arr[index];

	}
	//5. codePointBefore Method
	public int codePointBefore(int index)
	{
	  return codePointAt(index-1);	
	}
	//6. codePointCount
	public int codePointCount(int start, int end)
	{
		if(start>end|| start<0 || end <0 ||start>arr.length||end>=arr.length)
		throw new IndexOutOfBoundsException("Range ["+start+","+end+"] out of bounds for length "+ arr.length);
		return end - start;
	}
	//7. toUpperCase
	public MyString toUpperCase()
	{
		char[] newArr = new char[arr.length];
		for(int i =0;i<arr.length;i++)
		{
			char ch = arr[i];
			newArr[i] = (ch>=97 && ch<=122) ? (char)(ch-32):ch;
		}
		return new MyString(newArr);
	}
	//8. toLoweCase
	public MyString toLowerCase()
	{
		char[] newArr = new char[arr.length];
		for(int i =0;i<arr.length;i++)
		{ 
			char ch = arr[i];
			newArr[i] = (ch>=65&&ch<=90)?(char)(ch+32):ch;
		}
		  return new MyString(newArr);
	}
	//9. indexof int ascii && start
	public int indexOf(int ascii,int start)
	{
		for(int i = start;i<arr.length;i++)
		{
			if(ascii== arr[i]) return i;
			
		}
		return -1;
	}
	//10. indexof int ascii && start
	public int indexOf(int ascii)
	{
		return indexOf(ascii,0);
	}
	//11. lastindexof
	public int lastIndexOf(int ascii,int end)
	{
		for(int i = end;i>=0;i--)
		{
			if(ascii== arr[i]) return i;
			
		}
		return -1;
	}
	//12. last int ascii 
	public int lastIndexOf(int ascii)
	{
		return lastIndexOf(ascii,arr.length-1);
	}
	//13. startsWith(String str,int index)
	public boolean startsWith(MyString prefix,int start)
	{
		if(prefix.length()>arr.length || prefix.length()>(arr.length - start)) return false;
		for(int i =0;i<prefix.length();i++)
		if(arr[start++]!=prefix.charAt(i)) return false;
		return true;
	}
	//14. startsWith
	public boolean startsWith(MyString str)
	{
		
		return startsWith(str,0);
	}
	//15. endsWith
	public boolean endsWith(String str)
	{
		if(arr.length<str.length()) return false;
		for(int i =str.length()-1,j =arr.length -1;i>=0;i--,j--)
			if(arr[j]!=str.charAt(i)) return false;
		    return true;
	}
	//16. equals
	public boolean equals(Object obj)
	{
		if(!(obj instanceof MyString)) return false;
		MyString str = (MyString)obj;
		if(arr.length!=str.length()) return false;
		for(int i =0;i<str.length();i++)
		if(arr[i]!=str.charAt(i)) return false;
		return true;
	}
	//17. contentEquals
	public boolean contentEquals(StringBuffer sb)
	{
		MyString obj = new MyString(sb);
		return this.equals(obj);
	}
	//18. equalsIgnoreCase
	public boolean equalsIgnoreCase(MyString str)
	{
		return this.toLowerCase().equals(str.toLowerCase());
	}
	//19. replace
	public MyString replace(char oldChar,char newChar)
	{
		char[] newArr = arr.clone();
		for(int i =0;i<arr.length;i++)
		{
			if(newArr[i]==oldChar)
				newArr[i] = newChar;
		}
		return new MyString(newArr);
		
	}
	//20. toCharArray
	public char[] toCharArray()
	{
		char[] newArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) 
			newArr[i] = arr[i];
		   return newArr;
	}
	//21. contains
	public boolean contains(MyString str)
	{
		for(int i =0;i<arr.length;i++)
		if(startsWith(str,i)) return true;
		return false;
		
	}
	//22. substring
	public MyString substring(int start,int end)
	{
		if(start>end || start<0 || end<0 || end>arr.length)
			throw new MyStringIndexOutOfBoundsException
			("Range ["+start+","+end+"] out of bounds for length "+ arr.length);
		char[] newArr = new char[end-start];
		for(int i =0;i<newArr.length;i++)
			newArr[i] = arr[start++];
		return new MyString(newArr);
	}
	//23. substring
	public MyString substring(int offset)
	{
		if(offset == 0) return new MyString(arr);
		return substring(offset,arr.length);
	}
	//24. trim
	public MyString trim()
	{
		int left =0,right =0;
		for(int i =0;i<arr.length;i++)
		if(arr[i]==' ') left++;
		else break;
		for(int i = arr.length-1;i>=0;i--)
		 if(arr[i]==' ') right++;
		 else break;
		return substring(left,(arr.length)-right);
	}
	//25. spilt
	public MyString[] split(MyString regex)
	{
		int count =0;
		for(int i =0 ;i<arr.length;i++)
		
			if(arr[i] ==regex.charAt(0)) count++;
			MyString[] newArr = new MyString[count+1];
			int indx =0;
			MyString str = new MyString("");
			for(char ele : arr)
			{
				if(ele!=' ')
				{
					str = str.concat(new MyString(ele+""));
				}
				else
				{
					newArr[indx++] = str;
					str = new MyString("");
				}
			}
			newArr[indx] = str;
		return newArr;
		}
		 //26.replaceAll
		public MyString replaceAll(MyString searchStr,MyString repStr)
		{

			MyString[] newArr = new MyString(arr).split(new MyString(" "));
			MyString op = new MyString("");
			int indx = 0;
			for(MyString ele : newArr)
			{
				if(ele.equals(searchStr))
				{
					newArr[indx] = repStr;
				}
				op = op.concat(new MyString(newArr[indx++]+" "));
				
			}
			return op.trim();
         }
	

		//27. toString
          @Override
          public String toString() {
             String str ="";
           for(char ele : arr)
    	    str+=ele;
           return str;
         }
         //28. concat
          public MyString concat(MyString merge)
          {
        	  char[] newArr = new char[arr.length+merge.length()];
        	  int indx =0;
        	  for(char ele : arr)
        	    newArr[indx++] = ele;
        		  for(int i = 0;i<merge.length();i++)
        			newArr[indx++] = merge.charAt(i);
        		  
        	 return new MyString(newArr);
          }
          
          public MyString replaceFirst(MyString searchStr, MyString repStr)
          {
          	MyString[] newArr = new MyString(arr).split(new MyString(" "));
          	MyString op = new MyString("");
          	int indx = 0;
          	boolean flag = false; 

          	for(MyString ele : newArr)
          	{
          		if(ele.equals(searchStr) && !flag)
          		{
          			newArr[indx] = repStr;
          			flag = true; 
          		}
          		op = op.concat(new MyString(newArr[indx++] + " "));
          	}

          	return op.trim();
          }
       
}

public class StringDriver 
{
	public static void main(String[] args) 
	{ 
   
		byte[] arr = {65,66,67,68};
		MyString str = new MyString(arr,1,3);
		System.out.println(str);
		MyString str6 = new MyString("HELLO JAVA IS JAVA ESAY");
		
        	MyString str1 = new MyString("  is Esay");
         	MyString str2 = new MyString(" HELLO JAVA IS JAVA ESAY    ");
		System.out.println(str2.replaceAll(new MyString("JAVA"),new MyString("java")));
		
	}

}
