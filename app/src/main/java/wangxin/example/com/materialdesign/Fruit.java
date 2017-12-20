package wangxin.example.com.materialdesign;

/**
 * Created by wangxin on 17-12-7.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int id){
        this.name = name;
        imageId = id;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
