import static java.lang.System.out;
import java.util.HashMap;

public class Test {
    
    public class CharacterSet {
        
        private HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();

        private CharacterSet(String inputString) {
            generateCharacterMap(inputString);
        }

        private HashMap getHashMap() {
            return characterMap;
        }
        
        private void generateCharacterMap(String inputString) {
            for (int i = 0; i < inputString.length(); i++) {
                char thisCharacter = inputString.charAt(i);
                Integer thisCharacterCount = characterMap.get(thisCharacter);
                if (thisCharacterCount != null) {
                    characterMap.put(thisCharacter, thisCharacterCount + 1);
                }
                else {
                    characterMap.put(thisCharacter, 1);
                }
            }
        }
    }

    public static void main (String[] args) {
        Test test = new Test();
        test.start();
    }

    public static Integer GetNumberOfCharactersToRemove (HashMap... sets) {
        System.out.println(sets);
        return 0;
        // int numberOfChars = 0;
        // Iterator it = set1.entrySet().iterator();
        // while (it.hasNext()) {
        //     Map.Entry pair = (Map.Entry)it.next();
        //     System.out.println(pair.getKey() + " = " + pair.getValue());
        //     it.remove(); // avoids a ConcurrentModificationException
        // }
        // for (int i = 0; i < set1.length(); i++) {
        //     int x = set1.get(i);
        //     int y = set1.get(i);
            
        // }
    }

    public void start() {
        HashMap x = new CharacterSet("back").getHashMap();
        HashMap y = new CharacterSet("carb").getHashMap();
        int z = GetNumberOfCharactersToRemove(x, y);
        out.println(z);
    }
}