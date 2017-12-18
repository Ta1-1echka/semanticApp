package service.document.impl;

import dao.document.DocumentDao;
import entity.Document;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.document.DocumentDaoService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Tanya on 05.12.2016.
 */
@Service(value = "documentService")
public class DocumentDaoServiceImpl implements DocumentDaoService {

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private Md5PasswordEncoder encoder;

    @Value("${path}")
    public String path;

    @Override
    public Document saveDocument(MultipartFile file, String name, User user) {
        String fileName = null, fileNameEncoder = null;
        Document document = new Document();
        if (!file.isEmpty()) {
            try {
                fileNameEncoder = encoder.encodePassword(file.getOriginalFilename() + Math.random() * 100000000, null);
                fileName = file.getOriginalFilename();
                fileName = fileName.substring(fileName.length() - 10, fileName.length());
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(path + fileNameEncoder +
                                fileName)));
                buffStream.write(bytes);
                buffStream.close();
//                new SolrService().n(new File(path + fileNameEncoder + fileName));
            } catch (Exception e) {
                System.out.println("You failed to upload " + fileName + ": " + e.getMessage());
            }
        } else {
            System.out.println("Unable to upload. File is empty.");
        }
        document.setName(name);
        document.setUrl(fileNameEncoder + fileName);
        document.setUser(user);
        return documentDao.saveDocument(document);
    }


    @Override
    public void deleteDocument(Document document) {
        documentDao.deleteDocument(document);
    }

    @Override
    public void updateDocument(Document document) {
        documentDao.updateDocument(document);
    }

    @Override
    public Document getDocumentById(int id) {
        return documentDao.getDocumentById(id);
    }

    @Override
    public List<Document> getTenDocuments(int page) {
        return documentDao.getTenDocuments(page);
    }

    @Override
    public int getCountOfDocuments() {
        return documentDao.getCountOfDocuments();
    }
}
