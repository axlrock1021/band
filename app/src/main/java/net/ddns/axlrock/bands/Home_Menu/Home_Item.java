package net.ddns.axlrock.bands.Home_Menu;

public class Home_Item {

    private int id;
    private int image;
    private String name;

    public Home_Item() {
        super();
    }

    public Home_Item(int id, int image, String name) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
