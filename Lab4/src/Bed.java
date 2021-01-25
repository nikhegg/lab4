public class Bed extends AThing {
    private Person lying;

    Bed(String name, Place location, Person lying) {
        super(name, location);
        this.lying = lying;
    }

    public String getLying() throws NobodyInBedException {
        if(this.lying != null) {
            return this.lying.getName() + " лежит на " + getName();
        } else {
            throw new NobodyInBedException("Никто не лежит на " + getName());
            //return "Никто не лежит на " + getName();
        }
    }

    public void takeLying(Person person) {
        this.lying = person;
        System.out.println(person.getName() + " ложится на " + getName());
        person.changePosition(Position.LYING);
    }

    public void forgetLying(Person person) {
        this.lying = null;
        person.changePosition(Position.STANDING);
        System.out.println(getName() + " теперь свободна, никто на ней не лежит");
    }
}
