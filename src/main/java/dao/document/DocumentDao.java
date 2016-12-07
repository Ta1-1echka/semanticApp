package dao.document;

import entity.Document;

import java.util.List;

/**
 * Created by Tanya on 05.12.2016.
 */
public interface DocumentDao {
    Document saveDocument(Document document);

    void deleteDocument(Document document);

    void updateDocument(Document document);

    Document getDocumentById(int id);

    List<Document> getTenDocuments(int page);

}
