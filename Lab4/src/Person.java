import java.util.Objects;

public class Person implements Actions{
    private String name;
    private Place place;
    private GroupOfPeople group;
    private Position position;
    private Bed onBed;
    private Chair onChair;
    private boolean sleeping;

    Person(String name, Place place, Position position) {
        this.name = name;
        this.place = place;
        this.group = null;
        this.position = position;
        this.onBed = null;
        this.sleeping = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sleeping == person.sleeping && Objects.equals(name, person.name) && place == person.place && Objects.equals(group, person.group) && position == person.position && Objects.equals(onBed, person.onBed) && Objects.equals(onChair, person.onChair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, group, position, onBed, onChair, sleeping);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", place=" + place +
                ", group=" + group +
                ", position=" + position +
                ", onBed=" + onBed +
                ", onChair=" + onChair +
                ", sleeping=" + sleeping +
                '}';
    }

    public void goTo(Place place) {
        if(this.place == place || this.position != Position.STANDING || this.onBed != null) return;
        this.place = place;
        System.out.println(this.name + " переходит в другое место. Теперь " + this.name + " " + this.getLocation());
    }

    public void interactWithWindow(RoomWindow window) {
        if(this.position != Position.STANDING || this.place != window.getPlace()) return;
        if(!window.getCondition()) {
            System.out.println(this.name + " распахивает окно");
            window.changeCondition();
        } else {
            System.out.println(this.name + " решает оставить окно открытым");
        }
    }

    public void thinkOf(String name) {
        System.out.println(this.name + " думает о " + name);
    }

    public void cry() {
        System.out.println(this.name + " тихо плачет :'(");
    }

    public void changePosition(Position position) {
        this.position = position;
        System.out.println(this.name + " теперь " + getPosition());
    }

    public void layOnBed(Bed bed) {
        if(this.position != Position.STANDING) throw new IncorrectPositionException(getName() + " имеет некорректную позицию для того, чтобы лечь");
        this.onBed = bed;
        bed.takeLying(this);
    }

    public void standFromBed() {
        if(this.onBed == null) return;
        this.onBed.forgetLying(this);
        this.onBed = null;
    }

    public void sleep() {
        if(this.position != Position.LYING) throw new IncorrectPositionException(getName() + " имеет некорректную позицию для того, чтобы спать");
        if(this.sleeping) System.out.println(this.name + " уже спит");
        else this.sleeping = true;
    }

    public void wakeUp() {
        if(!this.sleeping) System.out.println(this.name + " не спит, чтобы просыпаться");
        else this.sleeping = false;
    }

    public void sitOnChair(Chair chair) {
        if(this.position != Position.STANDING) throw new IncorrectPositionException(getName() + " имеет некорректную позицию для того, чтобы сесть");

        try {
            chair.takeSitter(this);
            this.onChair = chair;
        } catch(PlaceClaimedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void standFromChair() {
        if(this.onChair == null) return;
        this.onChair.forgetSitter(this);
        this.onChair = null;
    }

    public void glueMarks(MarkCollection from, Album to) {
        from.spendOneMark(to);
    }

    public void playTogetherWith(GroupOfPeople group) {
        System.out.println(getName() + " играет с группой: " + group.getName());
    }

    public void joinGroup(GroupOfPeople group) {
        if(this.group == null) {
            group.addMember();
            this.group = group;
            System.out.println(getName() + " присоединятся к группе: " + group.getName());
        } else System.out.println(getName() + " пытается присоединиться к группе: " + group.getName() + " - хотя уже состоит в группе: " + this.group.getName());
    }

    public void leaveGroup() {
        if(this.group != null) {
            this.group.removeMember();
        }
    }

    public void talkAbout(Person person, String theme) {
        System.out.println(getName() + " говорит с " + person.getName() + " о " + theme);
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        switch(this.position) {
            case STANDING:
                return "стоит";
            case SITTING:
                return "сидит";
            case LYING:
                return "лежит";
            default:
                return "находится в неизвестной позиции";
        }
    }

    public String getLocation() {
        switch(this.place) {
            case HOUSE:
                return "в доме";
            case STREET:
                return "на улице";
            case ROOM:
                return "в комнате";
            case KITCHEN:
                return "на кухне";
            case VILLAGE:
                return "в деревне";
            default:
                return "где-то...";
        }
    }
}
