package dao.document.impl;

import dao.document.DocumentDao;
import entity.Document;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tanya on 05.12.2016.
 */
@Repository
@Transactional(readOnly = false)
public class DocumentDaoImpl implements DocumentDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public Document saveDocument(Document document) {
        hibernateTemplate.save(document);
        return document;
    }

    @Override
    public void deleteDocument(Document document) {
        hibernateTemplate.delete(document);
    }

    @Override
    public void updateDocument(Document document) {
        hibernateTemplate.update(document);
    }

    @Override
    public Document getDocumentById(int id) {
        return hibernateTemplate.get(Document.class, id);
    }

    @Override
    public List<Document> getTenDocuments(int page) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Document.class);
        return (List<Document>) hibernateTemplate.findByCriteria(detachedCriteria, page*10 -9 ,page*10);
    }
}
