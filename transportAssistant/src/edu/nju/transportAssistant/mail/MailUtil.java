package edu.nju.transportAssistant.mail;
import java.util.Date;
import java.util.Properties;

import java.io.UnsupportedEncodingException;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
    /**
     * �����ʼ�
     * 
     * @param mailServerHost
     *            �ʼ���������ַ
     * @param mailServerPort
     *            �ʼ��������˿�
     * @param validate
     *            �Ƿ�Ҫ�������֤
     * @param fromAddress
     *            �����ʼ���ַ
     * @param toAddress
     *            �����ʼ���ַ
     * @param subject
     *            �ʼ�����
     * @param content
     *            �ʼ�����
     * @param isHTML
     *            �Ƿ���html��ʽ�ʼ�
     * @param isSSL
     *            �ʼ��������Ƿ���Ҫ��ȫ����(SSL)
     * @return true:���ͳɹ�;false:����ʧ��
     */
	public static boolean sendMail(String mailServerHost,
                    String mailServerPort, boolean validate, String fromAddress,
                    String userPass, String toAddress, String subject, String content,
                    boolean isHTML, boolean isSSL) {
            Properties p = new Properties();
            p.put("mail.transport.protocol", "smtp"); 
            p.put("mail.smtp.host", mailServerHost);
            p.put("mail.smtp.port", mailServerPort);
            p.put("mail.smtp.auth", validate ? "true" : "false");
            if (isSSL) {
                    p.put("mail.smtp.starttls.enable", "true");
                    p.put("mail.smtp.socketFactory.fallback", "false");
                    p.put("mail.smtp.socketFactory.port", mailServerPort);
            }
            Authenticator auth = null;
            if (validate) {
                    auth = new MailAuthenticator(fromAddress, userPass);
            }

            try {
                    Session session = Session.getInstance(p, auth);
                    Message message = new MimeMessage(session);
                    Address from = new InternetAddress(fromAddress);
                    Address to = new InternetAddress(toAddress);
                    message.setFrom(from);
                    message.setRecipient(Message.RecipientType.TO, to);
                    message.setSubject(subject);
                    message.setSentDate(new Date());
                    if (isHTML) {
                            Multipart m = new MimeMultipart();
                            BodyPart bp = new MimeBodyPart();
                            bp.setContent(content, "text/html; charset=utf-8");
                            m.addBodyPart(bp);
                            message.setContent(m);
                    } else
                            message.setText(content);
                   System.out.println(message);
                    Transport.send(message);
                    return true;
            } catch (Exception e) {
                    e.printStackTrace();
                    return false;
            }
    }
}
