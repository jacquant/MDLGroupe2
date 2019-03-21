package be.unamur.mdl_groupe2.root.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String author;
    public String title;

    public String [] domaine;

    public String [] tag;

    public Boolean published;

    public String abstractArticle;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public DBFile pdfFiles;

    public String videoUrl;

    public String ref;

    public String journal;

    public String publisher;

}
