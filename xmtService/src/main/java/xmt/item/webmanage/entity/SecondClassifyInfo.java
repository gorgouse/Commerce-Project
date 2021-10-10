package xmt.item.webmanage.entity;
import java.util.List;
public class SecondClassifyInfo {
    private String id;

//    private String classifyName;

    private String remark;

    private String label;

    private String parentId;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
