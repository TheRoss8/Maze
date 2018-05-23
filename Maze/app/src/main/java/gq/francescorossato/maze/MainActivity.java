package gq.francescorossato.maze;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private Maze maze = new Maze();

    private float xDown;
    private float yDown;
    private final static float MIN_DIST = 100.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDown = event.getX();
                yDown = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                float xUp = event.getX();
                float yUp = event.getY();
                float deltaX = Math.abs(xUp - xDown);
                float deltaY = Math.abs(yUp - yDown);
                if(deltaX > deltaY && deltaX > MIN_DIST) {
                    if (xUp > xDown) {
                        Log.d("lol", "LEFT");
                        move('L');
                    } else {
                        Log.d("lol", "RIGHT");
                        move('R');
                    }
                }
                else if(deltaY > deltaX && deltaY > MIN_DIST){
                    if(yUp > yDown){
                        Log.d("lol", "UP");
                        move('T');
                    }
                    else {
                        Log.d("lol", "DOWN");
                        move('B');
                    }
                } else Log.d("lol", "TAP");
        }

        return super.onTouchEvent(event);

    }

    public void move(char direction){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Log.d("LOL", "moved");
        Cell next = maze.move(direction);
        switch(direction){
            case 'T':
                ft.setCustomAnimations(R.animator.slide_top, R.animator.fade_out);
                Log.d("LOL", "top");
                break;
            case 'R':
                ft.setCustomAnimations(R.animator.slide_right, R.animator.fade_out);
                Log.d("LOL", "right");
                break;
            case 'B':
                ft.setCustomAnimations(R.animator.slide_down, R.animator.fade_out);
                Log.d("LOL", "bottom");
                break;
            case 'L':
                ft.setCustomAnimations(R.animator.slide_left, R.animator.fade_out);
                Log.d("LOL", "left");
                break;
        }
        if(next != null)
            ft.replace(R.id.fragment_container, next);
        ft.commit();
        if(maze.hasWon()){
            startActivity(new Intent(this, YouWon.class));
        }
    }
}
