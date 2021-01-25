public class Main {
    public static void main(String[] args) {
        Person malysh = new Person("Малыш", Place.VILLAGE, Position.STANDING);
        Person karlson = new Person("Карлсон", Place.SOMEWHERE, Position.STANDING);
        Person randomBoy = new Person("Случайный мальчик", Place.VILLAGE, Position.STANDING);
        GroupOfPeople villageGuys = new GroupOfPeople("Деревенские ребята", 5, true) {
            private final Place location = Place.VILLAGE;
        };
        randomBoy.joinGroup(villageGuys);
        villageGuys.takeLeader(randomBoy);
        System.out.println(malysh.getName() + " находится " + malysh.getLocation());
        malysh.joinGroup(villageGuys);
        malysh.playTogetherWith(villageGuys);
        malysh.thinkOf("том, как хорошо играется с: " + villageGuys.getName() + " - и почти не вспоминает о " + karlson.getName());
        malysh.leaveGroup();

        malysh.goTo(Place.HOUSE);
        Person mother = new Person("Мама Малыша", Place.HOUSE, Position.STANDING);
        malysh.talkAbout(mother, karlson.getName());
        System.out.println(malysh.getName() + " находится " + malysh.getLocation());
        System.out.println(karlson.getName() + " находится " + karlson.getLocation());

        malysh.goTo(Place.ROOM);
        RoomWindow window = new RoomWindow("окно из комнаты Малыша", Place.ROOM,false);
        Bed malyshBed = new Bed("кровать Малыша", Place.ROOM, null);
        Table malyshTable = new Table("стол в комнате Малыша", Place.ROOM);
        Chair tableChairOne = new Chair("стул", malyshTable.getPlace(), malyshTable);
        MarkCollection malyshMCol = new MarkCollection("коллекция марок Малыша", malyshTable.getPlace(), 16, malyshTable);
        Album album = new Album("альбом Малыша", malyshTable.getPlace(), malyshTable, "Marks", 0);

        try {
            System.out.println(malyshBed.getLying());
        } catch(NobodyInBedException e) {
            System.out.println(e.getMessage());
        }

        malysh.interactWithWindow(window);
        malysh.layOnBed(malyshBed);
        malysh.thinkOf(karlson.getName());
        if(Math.random()*10 >= 6) {
            malysh.cry();
            malysh.thinkOf("том, что больше не увидит: " + karlson.getName());
        }
        malysh.sleep();

        Week week = new Week("дни");
        School schoolOne = new School("школа", Place.STREET);
        LessonsPack lessonsPackOne = new LessonsPack("уроки");
        week.goes();
        schoolOne.exists();
        lessonsPackOne.exists();
        System.out.println(karlson.getName() + " находится " + karlson.getLocation() + "\n");

        malysh.wakeUp();
        malysh.standFromBed();
        malysh.goTo(Place.KITCHEN);
        malysh.goTo(Place.ROOM);

        malysh.sitOnChair(tableChairOne);
        System.out.println(malyshTable.getConnections());
        for(int i = malyshMCol.getMarks(); i >= 0; i--) {
            malysh.glueMarks(malyshMCol, album);
            if(i > 0) System.out.println(malysh.getName() + " быстро вклеивает в альбом марку номер " + i);
        }
        System.out.println("В " + album.getName() + " вклеено " + album.getContentAmount() + " марок");
    }
}
