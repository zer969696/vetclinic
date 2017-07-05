package su.vistar.vetclinic.mongo.service;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 22.03.17.
 * VIstar
 */

public interface ImageService {

    List<GridFSDBFile> getImagesById(String id);

    GridFSDBFile getImageById(String id);
}
