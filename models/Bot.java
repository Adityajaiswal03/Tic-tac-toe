package models;

public class Bot extends Player {
    private  BotDifficultyLevel level;

    public Bot(String name, Symbol c, PlayerType p, BotDifficultyLevel level) {
        super(name, c, p);
        this.level = level;
    }

    public BotDifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(BotDifficultyLevel level) {
        this.level = level;
    }
    public Move makeMove(Board board){
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getBoard().get(i).get(j).getCellState()==CellState.EMPTY){
                    return new Move(this,board.getBoard().get(i).get(j));
                }
            }
        }
        return null;

    }

}
