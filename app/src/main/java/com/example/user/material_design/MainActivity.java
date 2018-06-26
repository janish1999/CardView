package com.example.user.material_design;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<set> book = new ArrayList<>();
    ListView drawerlist;
    DrawerLayout drawerlayout;
    ArrayAdapter<String> adapter;
    ActionBarDrawerToggle drawerToggle;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView=findViewById(R.id.view);
        RecyclerAdapter adapter= new RecyclerAdapter(book,this);
        recyclerView.setAdapter(adapter);
        add();
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));




    }
    private void switchFragment(int position){
        Fragment fragment=null;
        String FragmentID="";
        switch (position){
            case 0:{
                FragmentID ="Titles";
                Bundle args =new Bundle();
                args.putString("Tag","_NO_TAG");
                fragment=new TitlesFragment();
                fragment.setArguments(args);
                break;
            }
            case 1:{
                FragmentID="Tags";
                fragment=new TagsFragment();
            }
            default:
                break;

        }
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentholder,fragment,FragmentID).commit();
        drawerlayout.closeDrawer(drawerlist);
    }

    
    public void add(){
        book.clear();
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Playing_card_heart_A.svg/200px-Playing_card_heart_A.svg.png","Ace"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/2000px-Playing_card_heart_2.svg.png","Two"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Playing_card_heart_3.svg/2000px-Playing_card_heart_3.svg.png","Three"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Playing_card_heart_4.svg/2000px-Playing_card_heart_4.svg.png","Four"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Playing_card_heart_5.svg/2000px-Playing_card_heart_5.svg.png","Five"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Playing_card_heart_6.svg/2000px-Playing_card_heart_6.svg.png","Six"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Playing_card_heart_7.svg/2000px-Playing_card_heart_7.svg.png","Seven"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_8.svg/2000px-Playing_card_heart_8.svg.png","Eight"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_9.svg/2000px-Playing_card_heart_9.svg.png","Nine"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Playing_card_heart_10.svg/2000px-Playing_card_heart_10.svg.png","Ten"));
        book.add(new set("https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/English_pattern_jack_of_hearts.svg/2000px-English_pattern_jack_of_hearts.svg.png","Jack"));
        book.add(new set("https://i.pinimg.com/originals/ae/11/29/ae112908c5ada6e5d067d7392ebb2aa8.jpg","Queen"));
        book.add(new set("https://media.gettyimages.com/vectors/king-of-hearts-playing-card-vector-id165069587","King"));
    }
    public void SetRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.view);
        RecyclerAdapter adapter= new RecyclerAdapter(book,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.appbar,menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
            {Toast.makeText(this,"Search clicked",Toast.LENGTH_SHORT).show();

                break;}
            case R.id.overflow:
            {Toast.makeText(this,"Shuffle clicked",Toast.LENGTH_SHORT).show();
                Collections.shuffle(book);
                SetRecyclerView();
                break;}
            case R.id.reset:
            {Toast.makeText(this,"Reset shuffle",Toast.LENGTH_SHORT).show();
                add();
                SetRecyclerView();}

        }
        return super.onOptionsItemSelected(item);
    }
}
