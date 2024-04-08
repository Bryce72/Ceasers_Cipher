public enum Priority {
    HIGH(1),
    MEDIUM(50),
    LOW(99);

    //for objective 4
    private final int value;

    Priority(int value){
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }


}
