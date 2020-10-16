package com.sppot.sid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sppot.sid.dao.CategorieDocumentDao;
import com.sppot.sid.dao.DocumentDao;
import com.sppot.sid.exceptions.FileStorageException;
import com.sppot.sid.models.CategorieDocument;
import com.sppot.sid.models.Document;
import com.sppot.sid.properties.FileStorageProperties;
import org.springframework.util.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileStorageService {
  private final Path fileStorageLocation;
  
  @Autowired
  private DocumentDao repos;
  
  @Autowired
  private CategorieDocumentDao dao;
  
  @Autowired
 	public FileStorageService(FileStorageProperties fileStorageProperties) {
     	this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                 .toAbsolutePath().normalize();
 		 try {
 	            Files.createDirectories(this.fileStorageLocation);
 	        } catch (Exception ex) {
 	            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
 	        }
 	}
  
  
  public Document storeFile(MultipartFile file,Long id,String motcles,boolean statusdoc) {
      // Normalize file name
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());

      try {
          // Check if the file's name contains invalid characters
          if (fileName.contains("..")) {
              throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
          }

          // Copy file to the target location (Replacing existing file with the same name)
          Path targetLocation = this.fileStorageLocation.resolve(fileName);
          Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
          //create object dbfile
          
          String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                  .path("/downloadFile/")
                  .path(fileName)
                  .toUriString();

          Document doc = new Document(fileName,file.getContentType());
          doc.setFiledownloadURI(fileDownloadUri);
          doc.setDateFile(new Date());
          doc.setMotcles(motcles);
          CategorieDocument categorie = dao.findById(id).get();
          doc.setCategorieDocument(categorie);
          if(statusdoc==false) {
        	  doc.setStatus("Non archivé");
          }else {
        	  doc.setStatus("Archivé"); 
          }
          doc.setStatusdoc(statusdoc);
          return repos.save(doc);

      } catch (IOException ex) {
          throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
      }
  }
  
  
}
