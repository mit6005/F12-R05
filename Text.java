/** Text is an immutable data type representing English text. 
 * This is not free from problems! Where are they?
 */
public class Text {
    private final String text;
    private final String[] words;
    
    // Rep invariant:
    //    text != null; words != null;
    //    concatenation of words (words[0]+words[1]+...+words[words.length-1])
    //       is the same as text with spaces and punctuation removed
    // Abstraction function:
    //    represents the English text in the string variable text
    
    /**
     * Make a Text object.
     * Is this a CREATOR, PRODUCER, OBSERVER, or MUTATOR?
     * @param sentence a sentence in English.  Requires sentence != null.
     */
    public Text(String sentence) {
        this.text = sentence;
        this.words = sentence.split(" ");
    }
    
    /** @return the words in the sentence 
     * Is this a CREATOR, PRODUCER, OBSERVER, or MUTATOR?
     */
    public String[] getWords() { 
        return words;
    }
    
    /** @return the sentence as a string 
     * Is this a CREATOR, PRODUCER, OBSERVER, or MUTATOR?
     */
    public String toString() {
        return text;
    }
    
    /** concatenates this Text to that Text. Requires that != null. 
     * Is this a CREATOR, PRODUCER, OBSERVER, or MUTATOR?
     */
    public Text add(Text that) {
        return new Text(this.text + that.text);
    }
 
    /** Is this a CREATOR, PRODUCER, OBSERVER, or MUTATOR? 
     * @return true if and only if the word w is in the sentence. 
          Requires w != null */
    public boolean contains(String w) { 
        for (String v : words) { if (w.equals(v)) { return true; } }
        return false;
    }
    
}
