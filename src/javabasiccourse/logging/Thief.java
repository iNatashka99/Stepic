package javabasiccourse.logging;

/*
Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
Вор принимает в конструкторе переменную int – минимальную стоимость посылки,
которую он будет воровать. Также, в данном классе должен присутствовать метод
getStolenValue, который возвращает суммарную стоимость всех посылок, которые он
своровал. Воровство происходит следующим образом: вместо посылки, которая пришла
вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки
"stones instead of {content}
*/
public class Thief implements MailService {
    private final int minValue;
    private int stolenValue = 0;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    public int getStolenValue() {
        return this.stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package currentContent = ((MailPackage) mail).getContent();
            if (currentContent.getPrice() >= this.minValue) {
                Package newContent = new Package("stones instead of " + currentContent.getContent(), 0);
                MailPackage newMail = new MailPackage(mail.getFrom(), mail.getTo(), newContent);
                stolenValue += currentContent.getPrice();
                return newMail;
            }
        }
        return mail;
    }
}
