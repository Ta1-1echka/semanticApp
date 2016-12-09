package dao.document;

import entity.Document;

import java.util.List;

public interface DocumentDao {
    Document saveDocument(Document document);

    void deleteDocument(Document document);

    void updateDocument(Document document);

    Document getDocumentById(int id);

    List<Document> getTenDocuments(int page);

    int getCountOfDocuments();
}
