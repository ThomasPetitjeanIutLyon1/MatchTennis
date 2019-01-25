public class Player {
    private  String name;
    private TennisSet tennisSet;
    private String points;

    public void setPoints(String points) {
        this.points = points;
    }

    public Player(String name) {
        this.tennisSet = new TennisSet();
        this.name = name;
        this.points = "0";
    }

    public void winPoint(){

    }

    public String getPoints(){
        return tennisSet.getPts();
    }

    public int getWinnedGamesInSets(){
        return tennisSet.getWinnedSet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
