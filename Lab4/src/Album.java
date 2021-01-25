public class Album extends AThing {
    private String type;
    private int gluedContent;
    private Table lyingOnTable;

    Album(String name, Place place, Table table, String type, int glued) {
        super(name, place);
        this.type = type;
        this.gluedContent = glued;
        table.addThing();
        this.lyingOnTable = table;
    }

    public void glueMark() {
        this.gluedContent += 1;
    }

    public String getType() {
        return this.type;
    }

    public int getContentAmount() {
        return this.gluedContent;
    }

}
