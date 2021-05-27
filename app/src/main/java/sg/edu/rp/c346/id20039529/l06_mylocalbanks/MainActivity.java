package sg.edu.rp.c346.id20039529.l06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    boolean favDBS = false;
    boolean favOCBC = false;
    boolean favUOB = false;
    String wordClicked = "";

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contacts, menu);
        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else {
            wordClicked = "UOB";
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.dbsE);
            tvOCBC.setText(R.string.ocbcE);
            tvUOB.setText(R.string.uobE);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(R.string.dbsC);
            tvOCBC.setText(R.string.ocbcC);
            tvUOB.setText(R.string.uobC);
            return true;
        } else {
            tvDBS.setText(R.string.error);
            tvDBS.setText(R.string.error);
            tvDBS.setText(R.string.error);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == R.id.WebSelection) { //check whether the selected menu item ID is 0
                //code for action
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);

                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.CallSelection) { //check if the selected menu item ID is 1
                //code for action
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.Tel)));
                startActivity(i);
                return true;  //menu item successfully handled
            } else {
                if (!favDBS) {
                    favDBS = true;
                    tvDBS.setTextColor(Color.RED);
                } else {
                    tvDBS.setTextColor(Color.BLACK);
                }
            }

        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == R.id.WebSelection) { //check whether the selected menu item ID is 0
                //code for action
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbc1)));
                startActivity(i);

                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.CallSelection) { //check if the selected menu item ID is 1
                //code for action
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcTel)));
                startActivity(i);
                return true;  //menu item successfully handled

            } else {
                if (!favOCBC) {
                    favOCBC = true;
                    tvOCBC.setTextColor(Color.RED);
                } else {
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }

        } else {
            if (item.getItemId() == R.id.WebSelection) { //check whether the selected menu item ID is 0
                //code for action
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uob1)));
                startActivity(i);

                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.CallSelection) { //check if the selected menu item ID is 1
                //code for action
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uob2)));
                startActivity(i);
                return true;  //menu item successfully handled

            } else {
                if (!favUOB) {
                    favUOB = true;
                    tvUOB.setTextColor(Color.RED);
                } else {
                    tvUOB.setTextColor(Color.BLACK);
                }

            }


        }
        return super.onContextItemSelected(item);
    }
}

