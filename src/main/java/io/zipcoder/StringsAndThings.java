package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        String[] array = input.split(" ");
        int count = 0;
        for (String each : array) {
            int compareY = Character.compare(each.charAt(each.length() - 1), 'y');
            int compareZ = Character.compare(each.charAt(each.length() - 1), 'z');
            if (compareY != 0 || compareZ != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String[] array = base.split(remove);
        String newString = "";
        for (String each : array) {
            if (!remove.equals(each)) {
                newString += each;
            }
        }
        return newString;
    }


    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String newString = input.replace("is", "1");
        String newstring2 = newString.replace("not", "2");
        int isCount = 0;
        int notCount = 0;
        char[] array = newstring2.toCharArray();
        for (Character each : array){
            if (each.equals('1')) {
                isCount++;
            } else if (each.equals('2')) {
                notCount++;
            }
        }
        return (isCount == notCount);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        String newString = input.replace("gg", "1");
        String newString2 = newString.replace("g", "2");
        int happyCount = 0;
        int unhappyCount = 0;
        char[] array = newString2.toCharArray();
        for (Character each : array) {
            if (each.equals('1')) {
                happyCount++;
            } else if (each.equals('2')) {
                unhappyCount++;
            }
        }
        return ((happyCount > 0) && (unhappyCount == 0));
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        int count = 0;
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length - 3; i++) {
            int compare1 = Character.compare(array[i], array[i + 1]);
            int compare2 = Character.compare(array[i], array[i + 2]);
            if ((compare1 == 0) && (compare2 == 0)) {
                count++;
            }
        }
        return count;
    }
}
