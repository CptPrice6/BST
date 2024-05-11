public class NumberObject {

    private Integer num;
    private Integer pathSum;

    public NumberObject(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPathSum() {
        return pathSum;
    }

    public void setPathSum(Integer pathSum) {
        this.pathSum = pathSum;
    }

    @Override
    public String toString() {
        return "(" + num + ", pathSum:" + pathSum + ")";
    }

}
