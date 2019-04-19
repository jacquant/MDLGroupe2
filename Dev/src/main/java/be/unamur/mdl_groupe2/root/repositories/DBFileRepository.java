package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.dbfile.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long> {
}
