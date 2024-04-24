package models;

public class Cell {
        private int row;
        private int col;
        private Player player;
        private CellState cellState;

        public Cell(int row, int col) {
                this.row = row;
                this.col = col;
                this.cellState = CellState.EMPTY;
        }

        public int getRow() {
                return row;
        }

        public void setRow(int row) {
                this.row = row;
        }

        public int getCol() {
                return col;
        }

        public void setCol(int col) {
                this.col = col;
        }

        public Player getPlayer() {
                return player;
        }

        public void setPlayer(Player p) {
                this.player= p;
        }

        public CellState getCellState() {
                return cellState;
        }

        public void setCellState(CellState cellState) {
                this.cellState = cellState;
        }
        public Symbol getSymbol(){
                return player.getSymbol();
        }


}
