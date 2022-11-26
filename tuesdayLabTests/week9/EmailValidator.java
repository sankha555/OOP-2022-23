import java.util.Scanner;

class EmailReceiverException extends Exception {
    // private String message;

    public EmailReceiverException(String message) {
        super(message);
        // this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Exiting the program...";
    }
}

interface IEmailReceiver {
    public void onEmail(Email email) throws EmailReceiverException;
}

class EmailReceiver implements IEmailReceiver {
    @Override
    public void onEmail(Email email) throws EmailReceiverException {
        if (email != null) {
            processEmail(email);
        } else {
            throw new EmailReceiverException("The email object is null.");
        }
    }

    private void processEmail(Email email) throws EmailReceiverException {
        if (email.getBody() != null && !email.getBody().isEmpty()) {
            System.out.println("Process the email for sending.");
        } else {
            throw new EmailReceiverException("The body of the email is empty.");
        }
    }
}

class Email {
    private String to;
    private String from = "";
    private String subject = "";
    private String body;

    public Email(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() { return to; }
    public String getFrom() { return from; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }

    public void setFrom(String from) { this.from = from; }
    public void setSubject(String subject) { this.subject = subject; }
}

public class EmailValidator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        try {
            for (int i = 0; i < n; i++) {
                int t = Integer.parseInt(sc.nextLine());
                EmailReceiver er = new EmailReceiver();
                if (t == 1) {
                    String to = "student@pilani.bits-pilani.ac.in";
                    String body = "Non-empty body";
                    Email email = new Email(to, body);
                    er.onEmail(email);
                }
                else if (t == 2){
                    Email email = null;
                    er.onEmail(email);
                }
                else if (t == 3) {
                    String to = "student@pilani.bits-pilani.ac.in";
                    String body = "";  // Empty body
                    Email email = new Email(to, body);
                    er.onEmail(email);
                }
            }
        }
        catch (EmailReceiverException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Email handling successful.");
        }
    }
}
