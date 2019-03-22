package be.unamur.mdl_groupe2.root.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String title;

    private String [] domaine;

    private String [] tag;

    private Boolean published;

    private String abstractArticle;
    
    private DBFile pdfFiles;

    private String videoUrl;

    private String ref;

    private String journal;

    private String publisher;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String [] getDomaine() {return domaine ;}

    public void setDomaine(String[] domaine) {this.domaine = domaine; }

    public String [] getTag() {return tag ;}

    public void setTag(String[] domaine) {this.tag = tag; }

    public Boolean getPublished() {return published; }

    public void setPublished(Boolean published) {this.published = published;}

    public String getAbstractArticle(){return abstractArticle;}

    public void setAbstractArticle(String abstractArticle) {this.abstractArticle = abstractArticle; }

    public DBFile getPdfFiles(){return pdfFiles; }

    public void setPdfFiles(DBFile pdfFiles){this.pdfFiles=pdfFiles; }

    public String getVideoUrl(){return videoUrl; }

    public void setVideoUrl(String videoUrl){this.videoUrl=videoUrl; }

    public String getRef() { return ref; }

    public void setRef(String ref) { this.ref = ref; }

    public String getJournal() { return journal; }

    public void setJournal(String journal) { this.journal = journal; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
}
