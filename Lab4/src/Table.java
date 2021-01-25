public class Table extends AThing {
    private int thingsOnIt;
    private int connectedChairs;

    Table(String name, Place place) {
        super(name, place);
        this.thingsOnIt = 0;
        this.connectedChairs = 0;
    }

    public void addThing() {
        this.thingsOnIt += 1;
    }

    public void removeThing() {
        if(this.thingsOnIt == 0) throw new LessThanZeroException("Нет вещей, которые можно убрать с: " + getName());
        this.thingsOnIt -= 1;
    }

    public void addChair() {
        this.connectedChairs += 1;
    }

    public void removeChair() {
        if(this.connectedChairs == 0) throw new LessThanZeroException("Нет стульев, которые можно убрать от: " + getName());
        this.connectedChairs -= 1;
    }

    public String getConnections() {
        return "\n---------------\nСтатистика для: " + getName() + "\n• Вещей на столе: " + this.thingsOnIt + "\n• Стульев: " + this.connectedChairs + "\n---------------\n";
    }

}
