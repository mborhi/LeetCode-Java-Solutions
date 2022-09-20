/**
 * LeetCode problem 929. Unique Email Addresses: https://leetcode.com/problems/unique-email-addresses/
 */
public class Solution {

    /**
     * Returns the number of unique email addresses in the given array.
     * This solution iterates over the given emails, transforming them into a "base" form, and adding them to a Set.
     * Since a Set can only contain unqiue elements, size of the Set is the number of unique emails.
     * <p>
     * Time Complexity: O(N), where N = the number of emails in the given array. The given array is iterated over once.
     * <p>
     * Space Compliexity: O(N), where N = the number of emails in the given array. In the worse case, every given email
     * is unique, and so every email will be stored in the Set.
     *
     * @param emails the array of emails
     * @return the number of unqiue emails
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> emailset = new HashSet<>();
        for (String email : emails) {
            // transform email to basic
            String transformed = transformEmail(email);
            emailset.add(transformed);
        }
        return emailset.size();
    }

    public static String transformEmail(String email) {
        // we are provided valid email, must only contain one @
        String[] parts = email.toLowerCase().split("@");
        String username = parts[0];
        // ignore dots
        username = username.replace(".", "");
        // ignore anything after plus
        int plusIdx = username.indexOf("+");
        if (plusIdx > 0) username = username.substring(0, plusIdx);
        String domain = parts[1];
        return username + "@" + domain;
    }
}