package net.ddns.axlrock.bands.Stage;

public class Stage_Item {

    private int id;
    private int image2;
    private String name;

    public Stage_Item() {
        super();
    }

    public Stage_Item(int id, int image2, String name) {
        super();
        this.id = id;
        this.image2 = image2;
        this.name = name;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
