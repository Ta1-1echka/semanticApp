package entity;

import javax.persistence.*;

/**
 * Created by Tanya on 01.12.2016.
 */
@Entity
public class Document {
    private int idDocument;
    private String name;
    private String url;
    private User user;

    @Id
    @Column(name = "idDocument", nullable = false)
    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;

        Document document = (Document) o;

        if (idDocument != document.idDocument) return false;
        if (name != null ? !name.equals(document.name) : document.name != null) return false;
        if (url != null ? !url.equals(document.url) : document.url != null) return false;
        return user != null ? user.equals(document.user) : document.user== null;
    }

    @Override
    public int hashCode() {
        int result = idDocument;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
