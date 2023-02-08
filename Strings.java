/*
 * 1. Strings are immutable in java:
 * https://www.youtube.com/watch?v=to9DPVsdByE
 * 
 * String s1 = "abc";
 * String s2 = "abc";
 * Both s1 and s2 are referencing the same object "abc" in the string pool
 * (memory), this helps java to save space
 * 
 * String s3 = "def";
 * s3 gets it's separate space by creating a new obj "def"
 * 
 * s1 = "xyz";
 * this will create a new object int the pool "xyz" but the older string "abc"
 * will still remain unchanged in the pool, it's just that the s1 will refer to
 * a new location in the memory hence making the string impossible to be changed
 * directly. StringBuilder and Stringbuffer can be used to do the same.
 * 
 * String s4 = new String ("abc");
 * this will create a new string object inside the heap and not inside the
 * string pool(part of heap memory)
 * s1 == s2 //true, because they are refencing to the same location in the
 * memory
 * s1 == s4 //false, because they are not...
 * s1.equals(s4) //true, because this function compares the content of the
 * string and not the loocation in the memory
 */

public class Strings {
    public static void main(String args[]) {
        Notes();
    }

    public static void Notes() {
        // important methods:
        String s = "shjdbfhsbdjfasb";
        // s h j d b f h s b d j f a s b
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

        char chx = s.charAt(5);
        int length = s.length();

        // indexOf() gives the index of FIRST occurance of character or string
        System.out.println(s.indexOf('f'));// 5
        System.out.println(s.indexOf("bdj"));// 8
        System.out.println(s.indexOf("xyz")); // -1

        // contains() checks if the given substring exists or not
        System.out.println(s.contains("bdj"));// true

        // toLowerCase & toUpperCase alters the case of the string and saves it as a new
        // string

        // replace(target, replacement) creates a new string by replaceing the required
        // part of original string
        // if there are multiple occurances of the target value, all of them will be
        // replaced
        String s2 = s.replace("bfh", "abc");

        // substring(index) from index to end of the string OR substring(startindex,
        // endindex) result will be from startindex to endindex-1
        System.out.println(s.substring(4, 10));

        // STRINGBUILDER makes strings mutable
        StringBuilder sb = new StringBuilder("this is the string");

        sb.append(" I created");// adds a string to the end of existing one
        System.out.println(sb);

        sb.insert(11, " new"); // inserts a new string in the middle of existing one
        System.out.println(sb);

        sb.replace(11, 15, " old"); // replaces the part of string with a new one
        System.out.println(sb);

        sb.delete(11, 15);
        System.out.println(sb);

        String str = sb.toString(); // stringBuilder to string
        System.out.println(str);

        StringBuilder newSb = new StringBuilder(str); // string to stringbuilder
        System.out.println(newSb);
    }
}

//Alphabets to numbers
char ch = 'h';
int pos = ch - 'a' + 1;