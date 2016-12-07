package service.document.impl;

import dao.document.DocumentDao;
import entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.document.DocumentDaoService;

import java.util.List;

/**
 * Created by Tanya on 05.12.2016.
 */
@Service
public class DocumentDaoServiceImpl implements DocumentDaoService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document saveDocument(Document document) {
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
}
