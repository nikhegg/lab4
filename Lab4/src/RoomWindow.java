public class RoomWindow extends AThing {
    private boolean condition;
    private static int glassRows;

    RoomWindow(String name, Place place, boolean condition) {
        super(name, place);
        this.condition = condition; // true - opened; false - closed
        glassRows = 2;
    }

    public class WindowHandle {
        public int durability;

        WindowHandle(int durability) {
            this.durability = durability;
        }

        public int getDurability() {
            return this.durability;
        }

        public void interactWith() {
            if(this.durability > 0) this.durability -= 1;
        }

    }

    public static class WindowRows {
        public static int getWindowRows() {
            return glassRows;
        }
    }

    WindowHandle handle = new WindowHandle(1565);
    WindowRows rows = new WindowRows();

    public boolean getCondition() {
        return this.condition;
    }

    public void changeCondition() {
        if(handle.getDurability() <= 0) System.out.println("Ручка окна сломалась, нужно её поменять, а потом открывать или закрывать окно!");
        if(!this.condition) {

            this.condition = true;
            for(int i = 0; i<rows.getWindowRows(); i++) {
                handle.interactWith();
            }
            System.out.println("Теперь " + getName() + " открыто");

        }
        else this.condition = false;
    }

}
