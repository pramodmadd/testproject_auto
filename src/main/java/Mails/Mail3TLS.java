package Mails;

import org.openqa.selenium.WebDriver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Mail3TLS {

    static WebDriver driver;

    public static void main(String[] args) {

        // change accordingly
        final String username = "728e73a6ce02b9";

        // change accordingly
        final String password = "e60b50f7ca374f";

        // or IP address
        final String host = "smtp.mailtrap.io";

        // Get system properties
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.ssl", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // enable authentication
       // props.put("mail.smtp.auth", "true");

        // enable STARTTLS
        //props.put("mail.smtp.starttls.enable", "true");

        // Setup mail server
        //props.put("mail.smtp.host",host);

        // TLS Port
        //props.put("mail.smtp.port", "25");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication("pramodcrazy063@gmail.com", "Maddu0033734@");
                    }
                });

        try {

            // compose the message
            // javax.mail.internet.MimeMessage class is
            // mostly used for abstraction.
            Message message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress("pramodcrazy063@gmail.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("pramodmaddu7@gmail.com"));

            // Set the subject
            message.setSubject("Testing Subject");

            // Create object to add multiple type content
            BodyPart messageBodyPart = new MimeBodyPart();

            // Set the body of the email
            message.setText("This is the message body");



           /* mimeBodyPart.attachFile(new File("D:\\Training\\Training\\SoftwareAutomationTrainingProposalTest.pdf"));

            mimeBodyPart.setHeader("Content-Type", "text/plain; charset=\"us-ascii\"; " +
                    "name=\"D:\\Training\\Training\\SoftwareAutomationTrainingProposalTest.pdf\"");*/

           /* // Mention the file which you want to send
            String filename = "D:\\Training\\Training\\SoftwareAutomationTrainingProposalTest.pdf";

            // Create data source and pass the filename
            DataSource source = new FileDataSource(filename);

            // set the handler
            mimeBodyPart.setDataHandler(new DataHandler(source));*/

            // set the file
            //mimeBodyPart.setFileName(filename);


            // Create another object to add another content
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            try {
                File file = new File("D:\\Training\\Training\\SoftwareAutomationTrainingProposalTest.pdf");
                mimeBodyPart.attachFile(file);
                multipart.addBodyPart(mimeBodyPart);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // set the content
            message.setContent(multipart);
/*
            // add body part 1
            multipart.addBodyPart(mimeBodyPart);

            // add body part 2
            multipart.addBodyPart(messageBodyPart);*/



            // Send the message
            Transport.send(message);

            System.out.println("Email Sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

       /* System.out.println("This is the starting point of the test");
        //Initialize Chrome Driver
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mailtrap.io/signin");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement emailfield = driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        emailfield.sendKeys("pramodcrazy063@gmail.com");

        WebElement passwordfield = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        passwordfield.sendKeys("Pramod@1234");

        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[2]/div/div/div[3]/div/div[1]/span/a")).click();

        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        //*[@id="new_user"]/div[4]/input

        List<WebElement> allMessages = driver.findElements(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/ul/li/a"));

        if(allMessages.isEmpty()) {
            System.out.println("Test not passed");
        }else {
            System.out.println("Test passed");
        }*/

    }


}
