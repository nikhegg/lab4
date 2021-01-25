abstract class UnrealThing implements UnrealThingActions{
    private String name;
    UnrealThing(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void exists() {
        System.out.println("Было: " + this.name);
    }

    public void goes() {
        System.out.println("Проходит: " + this.name);
    }
}
