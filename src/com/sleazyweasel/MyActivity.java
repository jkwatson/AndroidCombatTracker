package com.sleazyweasel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.sleazyweasel.data.Combatant;
import com.sleazyweasel.data.ObjectRoot;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MyActivity extends Activity {
    private static final String STORAGE_FILENAME = "combatTrackerState.xml";
    private static final String COMBATANTS_BUNDLE_KEY = "combatants";

    private ObjectRoot root = new ObjectRoot();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String xml = new XStream().toXML(root);
        outState.putString(COMBATANTS_BUNDLE_KEY, xml);
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            FileOutputStream fos = openFileOutput(STORAGE_FILENAME, Context.MODE_PRIVATE);
            String xml = new XStream().toXML(root);
            fos.write(xml.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final LinearLayout list = (LinearLayout) findViewById(R.id.combatantsListLayout);

        Button addCombatantButton = (Button) findViewById(R.id.addCombatantButton);
        addCombatantButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Combatant newCombatant = new Combatant("", 3, 4, 5, 6, 7, 7);
                root.addCombatant(newCombatant);
                addCombatantToList(newCombatant, list);
            }
        });


        Button nextInitiativeButton = (Button) findViewById(R.id.nextInitiativeButton);
        nextInitiativeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.requestFocus();
                if (list.getChildCount() > 0) {
                    View first = list.getChildAt(0);
                    list.removeView(first);
                    list.addView(first);
                }
            }
        });

        String xml = null;
        if (savedInstanceState != null) {
            xml = savedInstanceState.getString(COMBATANTS_BUNDLE_KEY);
        }
        if (xml != null) {
            root = (ObjectRoot) new XStream().fromXML(xml);
        } else {
            FileInputStream inputStream;
            try {
                inputStream = openFileInput(STORAGE_FILENAME);
                root = (ObjectRoot) new XStream().fromXML(inputStream);
            } catch (FileNotFoundException e) {
                root = new ObjectRoot();
            }
        }

        List<Combatant> combatants = root.getCombatants();
        for (Combatant combatant : combatants) {
            addCombatantToList(combatant, list);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        final LinearLayout list = (LinearLayout) findViewById(R.id.combatantsListLayout);
        int i = 0;
        for (final Combatant combatant : root.getCombatants()) {
            View v = list.getChildAt(i++);
            EditText combatantNameTextField = (EditText) v.findViewById(R.id.combatantNameField);
            combatantNameTextField.setText(combatant.getName());

            combatantNameTextField.addTextChangedListener(new TextAdapter() {
                public void afterTextChanged(Editable editable) {
                    combatant.setName(editable.toString());
                }
            });
//
        }
    }

    private void addCombatantToList(final Combatant combatant, LinearLayout list) {
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newCombatantView = vi.inflate(R.layout.combatant, null);
        EditText combatantNameTextField = (EditText) newCombatantView.findViewById(R.id.combatantNameField);
        combatantNameTextField.setTag(combatant);
        list.addView(newCombatantView);
    }

    private static class TextAdapter implements TextWatcher {

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void afterTextChanged(Editable editable) {

        }
    }

}
