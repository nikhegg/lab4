public class MarkCollection extends AThing {
    public int marksInCol;
    public Table connectedTable;

    MarkCollection(String name, Place place, int marksInCol, Table lyingOn) {
        super(name, place);
        this.marksInCol = marksInCol;
        lyingOn.addThing();
        this.connectedTable = lyingOn;
    }

    public void spendOneMark(Album album) {
        if(this.marksInCol <= 0) System.out.println("В кучке больше нет марок");
        else {
            if (album.getType().equals("Marks")) {
                this.marksInCol -= 1;
                album.glueMark();
            }
        }
    }

    public int getMarks() {
        return this.marksInCol;
    }

}
