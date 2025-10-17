package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

public class StringPatternFinder implements SearchStrategy<String> {
    public int searchBeads(String beadString, char firstTarget, char secondTarget, int minSize) {
        int totalLength = beadString.length();
        int validPatterns = 0;

        for (int startPos = 0; startPos < totalLength; startPos++) {
            if (beadString.charAt(startPos) == firstTarget) {
                if (firstTarget == secondTarget && minSize == 1) {
                    validPatterns++;
                }
                for (int endPos = startPos + 1; endPos < totalLength; endPos++) {
                    if (beadString.charAt(endPos) == secondTarget) {
                        if (endPos - startPos + 1 >= minSize) {
                            validPatterns++;
                        }
                    }
                }
            }
        }
        return validPatterns;
    }
}