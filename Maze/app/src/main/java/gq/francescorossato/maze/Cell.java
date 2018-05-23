package gq.francescorossato.maze;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Cell extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle layout = this.getArguments();
        if(layout != null && layout.containsKey("direction"))
            return inflater.inflate(layout.getInt("direction"), container, false);
        return inflater.inflate(R.layout.fragment_rb, container, false);
    }

    public static Cell makeNext(String layout){
        Log.d("lol", "making next...");
        Cell c = new Cell();
        Bundle format = new Bundle();
        switch(layout){
            case Maze.TRBL:
                format.putInt("direction", R.layout.fragment_trbl);
                break;
            case Maze.TRL:
                format.putInt("direction", R.layout.fragment_trl);
                break;
            case Maze.TRB:
                format.putInt("direction", R.layout.fragment_trb);
                break;
            case Maze.RBL:
                format.putInt("direction", R.layout.fragment_rbl);
                break;
            case Maze.TBL:
                format.putInt("direction", R.layout.fragment_tbl);
                break;
            case Maze.TR:
                format.putInt("direction", R.layout.fragment_tr);
                break;
            case Maze.RB:
                format.putInt("direction", R.layout.fragment_rb);
                break;
            case Maze.BL:
                format.putInt("direction", R.layout.fragment_bl);
                break;
            case Maze.TL:
                format.putInt("direction", R.layout.fragment_tl);
                break;
            case Maze.RL:
                format.putInt("direction", R.layout.fragment_rl);
                break;
            case Maze.TB:
                format.putInt("direction", R.layout.fragment_tb);
                break;
            case Maze.TT:
                format.putInt("direction", R.layout.fragment_tt);
                break;
            case Maze.RR:
                format.putInt("direction", R.layout.fragment_rr);
                break;
            case Maze.BB:
                format.putInt("direction", R.layout.fragment_bb);
                break;
            case Maze.LL:
                format.putInt("direction", R.layout.fragment_ll);
                break;
        }
        c.setArguments(format);
        Log.d("lol", "setting args");
        return c;
    }
}