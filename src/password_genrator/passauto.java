package password_genrator;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class passauto {

	    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	    private static final String NUMBERS = "0123456789";
	    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:,<.>?";
	    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;


	    private static final int MIN_LENGTH = 8;
	    private static final int MAX_LENGTH = 12;

	    private static final SecureRandom random = new SecureRandom();

	    public static void main(String[] args) {
	        String password = generatePassword();
	        System.out.println("Generated Password: " + password);
	    }

	    public static String generatePassword() {
	        StringBuilder password = new StringBuilder();
	        List<Character> charSet = new ArrayList<>();

	        // Add characters based on complexity requirements
	        charSet.addAll(getRandomChars(UPPERCASE_LETTERS, 1));
	        charSet.addAll(getRandomChars(LOWERCASE_LETTERS, 1));
	        charSet.addAll(getRandomChars(NUMBERS, 1));
	        charSet.addAll(getRandomChars(SPECIAL_CHARACTERS, 1));

	        // Add additional random characters to meet the minimum length requirement
	        int remainingLength = MIN_LENGTH - charSet.size();
	        charSet.addAll(getRandomChars(ALL_CHARACTERS, remainingLength));

	        // Shuffle the characters to randomize the order
	        Collections.shuffle(charSet);

	        // Convert List<Character> to String
	        for (Character ch : charSet) {
	            password.append(ch);
	        }

	        return password.toString();
	    }

	    private static List<Character> getRandomChars(String characterSet, int count) {
	        List<Character> chars = new ArrayList<>();
	        for (int i = 0; i < count; i++) {
	            chars.add(characterSet.charAt(random.nextInt(characterSet.length())));
	        }
	        return chars;
	    }
	}
