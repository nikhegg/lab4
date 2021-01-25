public class GroupOfPeople {
    private String name;
    private int members;
    private boolean dependsOnLocation;

    GroupOfPeople(String name, int members, boolean dependsOnLocation) {
        this.name = name;
        this.members = members;
        this.dependsOnLocation = dependsOnLocation;
    }

    public void addMember() {
        this.members += 1;
    }

    public void removeMember() {
        if(this.members <= 0) throw new LessThanZeroException("В группе " + this.name + " отрицательное число участников");
        this.members -= 1;
    }

    public void takeLeader(Person person) {
        class GroupLeader {
            private Person person;
            GroupLeader(Person person) {
                this.person = person;
            }
            public String getName() {
                return this.person.getName();
            }
        }
        GroupLeader leader = new GroupLeader(person);
        System.out.println(leader.getName() + " становится лидером группы " + this.name);
    }

    public String getName() {
        return this.name;
    }
}
