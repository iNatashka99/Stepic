package javabasiccourse.logging;

/*
Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу
в виде исключения, если была обнаружена подобная посылка. Если он заметил запрещенную
посылку с одним из запрещенных содержимым ("weapons" и "banned substance"), то он
бросает IllegalPackageException. Если он находит посылку, состоящую из камней (содержит
слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы
должны объявить самостоятельно в виде непроверяемых исключений.
*/
public class Inspector implements MailService {
    public static class IllegalPackageException extends RuntimeException {}
    public static class StolenPackageException extends RuntimeException {}

    public Inspector() {}

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package currentContent = ((MailPackage) mail).getContent();
            if (currentContent.getContent().contains("weapons")|| currentContent.getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }
            if (currentContent.getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }
}
