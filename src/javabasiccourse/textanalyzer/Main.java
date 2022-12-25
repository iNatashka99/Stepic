package javabasiccourse.textanalyzer;

public class Main {

    // Возвращает первую не-OK метку в порядке данного набора анализаторов, и OK, если все анализаторы вернули OK
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label returnLabel;
        for (TextAnalyzer analyzer : analyzers) {
            returnLabel = analyzer.processText(text);
            if (returnLabel != Label.OK) {
                return returnLabel;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        String[] spamKeywords = {"спам", "фу"};
        int MaxLength = 40;
        // Несколько комбинаций
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(MaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new TooLongTextAnalyzer(MaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(MaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // Тесты
        String[] tests = new String[8];
        tests[0] = "Тут все норм.";                                             // OK
        tests[1] = "Тут кто-то налил очень много воды.................";        // TOO_LONG
        tests[2] = "Тут кто-то расстроился :(";                                 // NEGATIVE_TEXT
        tests[3] = "Тут спам...";                                               // SPAM
        tests[4] = "Тут кто-то расстроился :( и налил очень много воды";        // NEGATIVE_TEXT or TOO_LONG
        tests[5] = "Тут спам и кто-то налил очень много воды...........";       // SPAM or TOO_LONG
        tests[6] = "Тут спам и кто-то расстроился :(";                          // SPAM or NEGATIVE_TEXT
        tests[7] = "Тут спам и кто-то налил очень много воды и расстроился :("; // SPAM or TOO_LONG or NEGATIVE_TEXT
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3};
        int analyzerNumber;
        int testNumber = 0;
        for (String test : tests) {
            analyzerNumber = 1;
            System.out.print("Тест |" + testNumber + "|: ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(analyzerNumber + ": ");
                System.out.println(checkLabels(analyzers, test));
                analyzerNumber++;
            }
            testNumber++;
        }
    }
}