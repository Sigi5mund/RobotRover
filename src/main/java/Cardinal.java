public enum Cardinal {


    N ("y", +1),
    E ("x", +1),
    S ("y", -1),
    W ("x", -1);


    private String  changeAxis;
    private Integer changePosition;


    Cardinal(String changeAxis, Integer changePosition) {
        this.changeAxis = changeAxis;
        this.changePosition = changePosition;
    }

    public String seeAxis(){
    return this.changeAxis;
    }

    public Integer seeChangePosition() {
        return changePosition;
    }


}