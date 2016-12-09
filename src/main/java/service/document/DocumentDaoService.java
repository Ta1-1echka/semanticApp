package service.document;

import entity.Document;
import entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentDaoService {

    Document saveDocument(MultipartFile file, String name, User user);

    void deleteDocument(Document document);

    void updateDocument(Document document);

    Document getDocumentById(int id);

    public List<Document> getTenDocuments(int page);

    int getCountOfDocuments();
}
