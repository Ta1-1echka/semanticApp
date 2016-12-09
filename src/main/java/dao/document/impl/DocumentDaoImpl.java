package dao.document.impl;

import dao.document.DocumentDao;
import entity.Document;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return (List<Document>) hibernateTemplate.findByCriteria(detachedCriteria, page * 10 - 10, page * 10-1);
    }

    @Override
    public int getCountOfDocuments() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Document.class);
        detachedCriteria.setProjection(Projections.rowCount());
        return ((List<Long>) hibernateTemplate.findByCriteria(detachedCriteria)).get(0).intValue();
    }

}
