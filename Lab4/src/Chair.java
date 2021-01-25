public class Chair extends AThing {
    private Table nearbyTable;
    private Person sitter;

    Chair(String name, Place place, Table table) {
        super(name, place);
        table.addChair();
        nearbyTable = table;
    }

    public void connectToTable(Person person, Table table) {
        if(this.nearbyTable != null || table.getPlace() != getPlace()) return;
        table.addChair();
        this.nearbyTable = table;
    }

    public void breakConnectionToTable(Person breaker) {
        this.nearbyTable.removeChair();
        this.nearbyTable = null;
    }

    public void takeSitter(Person person) throws PlaceClaimedException {
        if(this.sitter ==  null) {
            this.sitter = person;
            person.changePosition(Position.SITTING);
        } else {
            throw new PlaceClaimedException("Стул занят, поэтому " + person.getName() + " не может сесть на него");
        }

    }

    public void forgetSitter(Person person) {
        this.sitter = null;
        person.changePosition(Position.STANDING);
        System.out.println(getName() + " теперь свободен, никто на нём никто не сидит");
    }
}
