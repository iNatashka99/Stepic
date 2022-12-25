package javabasiccourse.textanalyzer;

public class SpamAnalyzer extends KeywordAnalyzer{
    private String[] keywords;

    public SpamAnalyzer(String[] spamKeywords){
        this.keywords = spamKeywords.clone();
    }

    @Override
    public String[] getKeywords(){
        return keywords;
    }

    @Override
    public Label getLabel(){
        return Label.SPAM;
    }
}
