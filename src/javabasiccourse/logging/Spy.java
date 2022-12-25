package javabasiccourse.logging;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Spy – шпион, который логгирует о всей почтовой переписке, которая проходит
через его руки. Объект конструируется от экземпляра Logger, с помощью которого
шпион будет сообщать о всех действиях. Он следит только за объектами класса
MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить
части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно
написать в лог сообщение с уровнем WARN: Detected target mail correspondence:
from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual
correspondence: from {from} to {to}
*/
public class Spy implements MailService {
    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if ((Objects.equals(mail.getFrom(), "Austin Powers")) || (Objects.equals(mail.getTo(), "Austin Powers"))) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            }
            else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{mail.getFrom(), mail.getTo()});
            }
        }
        return mail;
    }
}
