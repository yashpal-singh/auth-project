/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.ecommsolution.auth.dto.MessageDTO;

/**
 * @author Yashpal.Singh
 *
 */
@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public void sendEmail() {

		MessageDTO dto = new MessageDTO("yashpal.singh@infogain.com", "Test Mail Service", "How Do it");
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(dto.getTo());
            helper.setSubject(dto.getSubject());
            helper.setText(dto.getBody(), true);
           
            this.javaMailSender.send(message);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
		
	}

}
