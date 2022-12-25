package javabasiccourse.textanalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer{
    private final String[] keywords = new String[3];

    public NegativeTextAnalyzer(){
        this.keywords[0] = ":(";
        this.keywords[1] = "=(";
        this.keywords[2] = ":|";
    };

    @Override
    public String[] getKeywords(){
        return keywords;
    }

    @Override
    public Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
}
