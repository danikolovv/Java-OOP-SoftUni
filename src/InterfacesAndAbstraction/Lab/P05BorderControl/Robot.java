package InterfacesAndAbstraction.Lab.P05BorderControl;

public class Robot implements Identifiable{

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
