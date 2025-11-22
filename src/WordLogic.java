public class WordLogic {
    private int userLinesCount;
    private int userCharactersCount;
    private int userWordsCount;
    private String longestWord = "";
    private String[] longestWordArray = new String[0];
    private int longestWordArrayCount = 0;

    public boolean userCount(String userText) {
        // Använder .toLowerCase() om användaren skulle skriva "stop" med stora bokstäver
        if (userText.toLowerCase().equals("stop"))
            return false;

        // Sparar antal rader
        userLinesCount++;

        // Sparar antal tecken
        userCharactersCount += userText.length();

        // Om användaren inte skriver något på en rad bryts det här
        // så att den inte räknas med på antal ord nedan
        if (userText.equals(""))
            return true;

        // Sparar antal ord. Använder .split om användaren skriver flera ord på samma rad
        String[] userTextArray = userText.split(" ");
        userWordsCount += userTextArray.length;

        for (int i = 0; i < userTextArray.length; i++) {

            // Sparar de längsta ordet och lägger den i array longestWordArray
            // Återställer även arrayn om ett nytt längsta ord kommer.
            if (userTextArray[i].length() > longestWord.length()){
                longestWord = userTextArray[i];
                longestWordArray = new String[1];
                longestWordArray[0] = userTextArray[i];
                longestWordArrayCount = 1;
            }
            // Om det finns ett till ord som är lika långt som
            // det längsta ordet läggs det till i array
            else if (userTextArray[i].length() == longestWord.length()) {

                // En ny tillfällig array som ökar med 1
                String[] newLongestWordArray = new String[longestWordArrayCount + 1];

                for (int j = 0; j < longestWordArrayCount; j++) {
                    newLongestWordArray[j] = longestWordArray[j];
                }

                // Lägg in det nya ordet
                newLongestWordArray[longestWordArrayCount] = userTextArray[i];

                // Lägg till nya tillfälliga array till den sparade array
                longestWordArray = newLongestWordArray;

                // Ökar antalet med sparade antal längsta ord med 1
                longestWordArrayCount++;
            }
        }
        return true;
    }

    public int getLines() {
        return userLinesCount;
    }

    public int getCharacters() {
        return userCharactersCount;
    }

    public int getWords() {
        return userWordsCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String[] getLongestWords() {
        return longestWordArray;
    }

}
