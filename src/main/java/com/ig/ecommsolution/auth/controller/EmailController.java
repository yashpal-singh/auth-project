/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yashpal.Singh
 *
 */
@RestController
@RequestMapping("/email")
public class EmailController {
	
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	@RequestMapping(value = "/send", method = RequestMethod.GET)
//	public void sendEmail() {
//
//		MessageDTO dto = new MessageDTO("yashpal.singh@infogain.com", "Test Mail Service", "How Do it");
//        try {
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setTo(dto.getTo());
//            helper.setSubject(dto.getSubject());
//            helper.setText(dto.getBody(), true);
//           
//            this.javaMailSender.send(message);
//        } catch (MailException ex) {
//            System.err.println(ex.getMessage());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//		
//	}

}
