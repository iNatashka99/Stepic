package javabasiccourse.textanalyzer;

public class TooLongTextAnalyzer implements TextAnalyzer{
    private int maxLength = 10;

    public TooLongTextAnalyzer(int length){
        maxLength = length;
    }

    @Override
    public Label processText(String text){
        if (maxLength < text.length()) {
            return Label.TOO_LONG;
        }
        else {
            return Label.OK;
        }
    }
}
