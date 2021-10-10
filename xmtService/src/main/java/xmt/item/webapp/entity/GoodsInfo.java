package xmt.item.webapp.entity;

import java.math.BigDecimal;

public class GoodsInfo {

  private String id;

  private String gName;

  private String gTotal;

  private String gType;

  private String gProp;

  private BigDecimal gPrice;

  private String gDesc;

  private String gImg;

  private String gSort;

  private String storeId;

  private String firstClassify;

  private String secondClassify;

    public String getFirstClassify() {
        return firstClassify;
    }

    public void setFirstClassify(String firstClassify) {
        this.firstClassify = firstClassify;
    }

    public String getSecondClassify() {
        return secondClassify;
    }

    public void setSecondClassify(String secondClassify) {
        this.secondClassify = secondClassify;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getgProp() {
        return gProp;
    }

    public void setgProp(String gProp) {
        this.gProp = gProp;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public String getgTotal() {
        return gTotal;
    }

    public void setgTotal(String gTotal) {
        this.gTotal = gTotal;
    }

    public String getgSort() {
        return gSort;
    }

    public void setgSort(String gSort) {
        this.gSort = gSort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public String getgDesc() {
        return gDesc;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }
}
