abstract class AThing implements AThingActions {
    private String name;
    private Place place;
    AThing(String name, Place place) {
        this.name = name;
        this.place = place;
    }
    public String getName() {
        return this.name;
    }

    public Place getPlace() {
        return this.place;
    }

    public void exists() {
        System.out.println("Было: " + this.name);
    }
}
