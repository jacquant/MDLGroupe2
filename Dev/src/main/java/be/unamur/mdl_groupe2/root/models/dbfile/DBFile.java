package be.unamur.mdl_groupe2.root.models.dbfile;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "files")
@Data
public class DBFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(max=100)
    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


}
