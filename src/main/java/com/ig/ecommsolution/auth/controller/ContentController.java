/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ig.ecommsolution.auth.domain.User;
import com.ig.ecommsolution.auth.repository.UserRepository;

/**
 * @author Yashpal.Singh
 *
 */
@RestController
public class ContentController {
	
	private String filePath = "D:\\Content";
	
	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "/files", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addContent(@RequestParam("file") MultipartFile file) {
		try{
			if(file != null && !file.isEmpty()) {
				String imageName = file.getOriginalFilename();
				String extension = getExtension(imageName, ".");
				String newImageName = "user_" + new Date().getTime() + "." + extension;
				String location = filePath + "\\user\\image\\";
				File imageFile = new File(location + newImageName);
				imageFile.mkdirs();
				file.transferTo(imageFile);
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(IllegalStateException ile) {
			ile.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public void getContent(@RequestParam("path") String path, HttpServletResponse response) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try{
			
			File file = new File(filePath + path);
				
//			BufferedImage img = ImageIO.read(inputStream);
//			outputStream = new ByteArrayOutputStream();
//			ImageIO.write(img, getExtension(file.getName(), "."), outputStream);
//			return new ResponseEntity<>(outputStream, HttpStatus.OK);
			response.setContentType(Files.probeContentType(file.toPath()));
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName());
			
			inputStream = Files.newInputStream(file.toPath());
			outputStream = response.getOutputStream();
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(IllegalStateException ile) {
			ile.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(inputStream != null)
					inputStream.close();
				if(outputStream != null)
					outputStream.close();
			} catch(IOException iee) {
				iee.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try{
			response.setContentType("image/jpeg");
			outputStream = response.getOutputStream();
			User user = repository.findOne("5746894c40e8874a110673e6");
			inputStream = new ByteArrayInputStream(user.getImage());
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();			
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(IllegalStateException ile) {
			ile.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(inputStream != null)
					inputStream.close();
				if(outputStream != null)
					outputStream.close();
			} catch(IOException iee) {
				iee.printStackTrace();
			}
		}
	}
	
	
	@RequestMapping(value = "/image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addImage(@RequestParam("file") MultipartFile file) {
		try{
			if(file != null && !file.isEmpty()) {
				byte[] imageBytes = file.getBytes();
				User user = repository.findOne("5746894c40e8874a110673e6");
				user.setImage(imageBytes);
				repository.save(user);
			}
			
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(IllegalStateException ile) {
			ile.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public String getExtension(String name, String extensionSeparator) {
		int dotIndex = name.lastIndexOf(extensionSeparator);		
		return name.substring(dotIndex + 1);
	}
}
