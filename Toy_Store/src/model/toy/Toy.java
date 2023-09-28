package model.toy;

public class Toy {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer weight;

    public Toy(int id, String name, Integer quantity, Integer weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getToyInfo() {
        return getId() + "," + getName() + "," + getQuantity() + "," + getWeight();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Toy ID: ");
        stringBuilder.append(getId());
        stringBuilder.append("\n");
        stringBuilder.append("Toy name: ");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        stringBuilder.append("Toy quantity: ");
        stringBuilder.append(getQuantity());
        stringBuilder.append("\n");
        stringBuilder.append("Toy weight: ");
        stringBuilder.append(getWeight());
        return stringBuilder.toString();
    }
}
