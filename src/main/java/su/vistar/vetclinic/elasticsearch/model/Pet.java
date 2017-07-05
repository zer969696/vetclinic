//package su.vistar.vetclinic.elasticsearch.model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.util.List;
//
//
///**
// * Created by Evgeniy Evzerov on 29.03.17.
// * VIstar
// */
//@Document(indexName = "my_pet", type = "petel")
//public class Pet {
//
//    @Id
//    private String id;
//
//    public Pet(String id) {
//        this.id = id;
//    }
//
//    public Pet(String id, String animalName) {
//        this.id = id;
//        this.animalName = animalName;
//    }
//
//    private String animalName;
//
////    @Field(type = FieldType.Nested)
////    private List<Pet> pets;
////
////    @Field(type = FieldType.Nested)
////    private List<String> nicknames;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPetName() {
//        return animalName;
//    }
//
//    public void setPetName(String petName) {
//        this.animalName = petName;
//    }
//}
