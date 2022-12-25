package javabasiccourse.textanalyzer;

abstract public class KeywordAnalyzer implements TextAnalyzer{

    @Override
    public Label processText(String text){
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    abstract protected String[] getKeywords();

    abstract protected Label getLabel();
}
