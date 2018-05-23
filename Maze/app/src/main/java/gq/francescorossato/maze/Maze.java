package gq.francescorossato.maze;

public class Maze {
    public static final String TRBL = "TRBL";
    public static final String TRL = "TRL";
    public static final String TRB = "TRB";
    public static final String RBL = "RBL";
    public static final String TBL = "TBL";
    public static final String TR = "TR";
    public static final String RB = "RB";
    public static final String BL = "BL";
    public static final String TL = "TL";
    public static final String RL = "RL";
    public static final String TB = "TB";
    public static final String TT = "TT";
    public static final String RR = "RR";
    public static final String BB = "BB";
    public static final String LL = "LL";

    private int[] position = {0, 0};

    private String[][] maze =
            {
                    {RB, RL, RBL, BL, BB},
                    {TRB, BL, TB, TR, TL},
                    {TT, TR, TRBL, RL, BL},
                    {RR, RBL, TRBL, LL, TB},
                    {RR, TL, TT, RR, TL}
            };


    private boolean canIMove(char direction) {
        switch (direction) {
            case 'T':
                if(position[1] - 1 >= 0 && maze[position[1]][position[0]].contains(String.valueOf(direction)))
                    return true;
                break;
            case 'R':
                if(position[0] + 1 < maze[0].length && maze[position[1]][position[0]].contains(String.valueOf(direction)))
                    return true;
                break;
            case 'B':
                if(position[1] + 1 < maze.length && maze[position[1]][position[0]].contains(String.valueOf(direction)))
                    return true;
                break;
            case 'L':
                if(position[0] - 1 >= 0 && maze[position[1]][position[0]].contains(String.valueOf(direction)))
                    return true;
                break;

        }
        return false;
    }

    public Cell move(char direction) {
        Cell out = null;
        if (canIMove(direction)) {
            switch (direction) {
                case 'T':
                    position[1]--;
                    break;
                case 'R':
                    position[0]++;
                    break;
                case 'B':
                    position[1]++;
                    break;
                case 'L':
                    position[0]--;
                    break;
            }
            out = Cell.makeNext(maze[position[1]][position[0]]);
        }
        return out;
    }

    public boolean hasWon(){
        return position[1] == 4 && position[0] == 4;
    }

}
