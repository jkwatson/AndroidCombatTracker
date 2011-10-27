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

public class MyActivity extends Activity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
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

//        List<Combatant> combatants = combatantHolder.getCombatants();
//        for (Combatant combatant : combatants) {
//            addCombatantToList(combatant, list);
//        }


    }

    private void addCombatantToList(final Combatant newCombatant, LinearLayout list) {
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newCombatantView = vi.inflate(R.layout.combatant, null);
        EditText combatantNameTextField = (EditText) newCombatantView.findViewById(R.id.combatantNameField);
        combatantNameTextField.addTextChangedListener(new TextAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                newCombatant.setName(charSequence.toString());
            }
        });
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
