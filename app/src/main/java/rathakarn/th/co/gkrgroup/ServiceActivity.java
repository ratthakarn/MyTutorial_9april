package rathakarn.th.co.gkrgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Create Toolbar
        createToolbar();

//        Add Fragment

//        getSupportFragmentManager().beginTransaction().add(R.id.contentServiceFragment, new PlayVideoFragment()).commit();

    }

    //Main Method


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemExit) {
//            Change Status Signout
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.signOut();
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_service, menu);
        return super.onCreateOptionsMenu(menu);


    }

    private void createToolbar() {
        try {

            Toolbar toolbar = findViewById(R.id.toobarService);
            setSupportActionBar(toolbar);

            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            String displayName = firebaseUser.getDisplayName();

            getSupportActionBar().setSubtitle(displayName + " Use");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

} // Main Class

