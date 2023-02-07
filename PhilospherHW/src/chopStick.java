public class chopStick {
    private boolean isFree = true;

    public boolean isFree() {
        return isFree;
    }

    public void use() {
        isFree = false;
    }

    public void stopUse() {
        isFree = true;
    }
}
