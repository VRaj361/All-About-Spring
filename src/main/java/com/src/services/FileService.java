package com.src.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {
//	public String filePath = "//media//vraj//New Volume//ComputerLanguages//Springlinux//all-about-spring//src//main//resources//static//images//";
	public String filePath = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	public FileService() throws IOException{
		
	}
	public boolean isFileUpload(MultipartFile file) {
		try {
			
			//concept of reading and writing files
//			InputStream is =  file.getInputStream();
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			//fileoutputstream
//			FileOutputStream f = new FileOutputStream(filePath+File.separator+file.getOriginalFilename());
//			f.write(data);
//			f.close();
//			is.close();

			// in one line
			
			Files.copy(file.getInputStream(), Paths.get(filePath+File.separator+file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
