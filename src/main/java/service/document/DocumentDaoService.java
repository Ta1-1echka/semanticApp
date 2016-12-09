package service.document;

import entity.Document;
import entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Tanya on 05.12.2016.
 */
public interface DocumentDaoService {
    Document saveDocument(MultipartFile file, String name, User user);

    void deleteDocument(Document document);

    void updateDocument(Document document);

    Document getDocumentById(int id);

    public List<Document> getTenDocuments(int page);

    int getCountOfDocuments();
}
