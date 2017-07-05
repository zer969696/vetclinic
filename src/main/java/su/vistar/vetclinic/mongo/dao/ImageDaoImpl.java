package su.vistar.vetclinic.mongo.dao;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 22.03.17.
 * VIstar
 */

@Component
public class ImageDaoImpl implements ImageDao {

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public List<GridFSDBFile> getImagesById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));

        return gridFsOperations.find(query);
    }

    @Override
    public GridFSDBFile getImageById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));

        return gridFsOperations.findOne(query);
    }
}
