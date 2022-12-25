package javabasiccourse.logging;

/*
UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты,
который вместо того, чтобы передать почтовый объект непосредственно в сервис
почты, последовательно передает этот объект набору третьих лиц, а затем, в
конце концов, передает получившийся объект непосредственно экземпляру
RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива
MailService ( результат вызова processMail первого элемента массива передается
на вход processMail второго элемента, и т. д.) и метод getRealMailService, который
возвращает ссылку на внутренний экземпляр RealMailService.
*/
public class UntrustworthyMailWorker implements MailService{
    private final static RealMailService realMailService = new RealMailService();
    private final MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable newMail = mail;
        for (MailService mailService : mailServices) {
            newMail = mailService.processMail(newMail);
        }
        return realMailService.processMail(newMail);
    }
}
