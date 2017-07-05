package su.vistar.vetclinic.mongo.dao;

import com.mongodb.gridfs.GridFSDBFile;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 22.03.17.
 * VIstar
 */
public interface ImageDao {

    List<GridFSDBFile> getImagesById(String id);

    GridFSDBFile getImageById(String id);
}
