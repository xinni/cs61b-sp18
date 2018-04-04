public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque returnDeque = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            returnDeque.addLast(word.charAt(i));
        }

        return returnDeque;
    }

    public boolean isPalindrome(String word) {
        Deque wordDeque = wordToDeque(word);
        for (int i = 0; i < word.length()/2; i++) {
            if (wordDeque.removeFirst() != wordDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordDeque = wordToDeque(word);
        for (int i = 0; i < word.length()/2; i++) {
            if(!cc.equalChars((char)wordDeque.removeFirst(), (char)wordDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
