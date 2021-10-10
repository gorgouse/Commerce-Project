package xmt.item.webmanage.entity;

public class CarouselInfo {
    private String id;

    private String goodsId;

    private String carousel;

    private String slideState;

    public String getSlideState() {
        return slideState;
    }

    public void setSlideState(String slideState) {
        this.slideState = slideState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCarousel() {
        return carousel;
    }

    public void setCarousel(String carousel) {
        this.carousel = carousel;
    }
}
