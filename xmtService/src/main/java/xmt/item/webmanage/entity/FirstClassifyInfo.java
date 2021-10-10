package xmt.item.webmanage.entity;
import java.util.List;
public class FirstClassifyInfo {

    private String id;

    private String label;

    private String parentId;

//    private String classifyName;


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    private List<SecondClassifyInfo> children;

    public List<SecondClassifyInfo> getChildren() {
        return children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setChildren(List<SecondClassifyInfo> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getClassifyName() {
//        return classifyName;
//    }
//
//    public void setClassifyName(String classifyName) {
//        this.classifyName = classifyName;
//    }


}
