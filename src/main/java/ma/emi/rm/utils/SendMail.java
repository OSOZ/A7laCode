package ma.emi.rm.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmailAttachment;
import it.ozimov.springboot.mail.service.EmailService;

@Component
public class SendMail {
	@Autowired
	public EmailService emailService;

	public void sendEmail(ByteArrayInputStream out,String enseignantMail) throws UnsupportedEncodingException {
		DefaultEmailAttachment attachment = null;
		try {
			attachment = DefaultEmailAttachment.builder().attachmentName("Nouvelle_Demande.pdf")
					.attachmentData(IOUtils.toByteArray(out)).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Email email = DefaultEmail.builder()
				.from(new InternetAddress(enseignantMail, enseignantMail))
				.to(Lists.newArrayList(new InternetAddress("meskine.wassif@gmail.com", "meskine wassif")))
				.subject("Demande")
				.body("Firmamentum autem stabilitatis constantiaeque eius, quam in amicitia quaerimus, fides est.").attachment(attachment)
				.encoding("UTF-8").build();
		
		
		emailService.send(email);
	}
}
