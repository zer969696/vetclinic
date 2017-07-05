package su.vistar.vetclinic.mongo.service;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import su.vistar.vetclinic.mongo.dao.ImageDao;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 22.03.17.
 * VIstar
 */

@Component
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao dao;

    @Override
    public List<GridFSDBFile> getImagesById(String id) {
        return dao.getImagesById(id);
    }

    @Override
    public GridFSDBFile getImageById(String id) {
        return dao.getImageById(id);
    }
}
