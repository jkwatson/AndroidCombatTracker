package com.sleazyweasel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sleazyweasel.data.Combatant;

import java.util.ArrayList;

public class CombatantListAdapter extends ArrayAdapter<Combatant> {

    public CombatantListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, new ArrayList<Combatant>());
        
    }

    public void addCombatant(Combatant combatant) {
        super.add(combatant);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("CombatantListAdapter.getView at position: " + position);
        final Combatant combatant = super.getItem(position);



        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.combatant, null);
            final TextView tt = getCombatantNameEditText(convertView);
//            tt.addTextChangedListener(new TextWatcher() {
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    System.out.println("CombatantListAdapter.beforeTextChanged");
//                }
//
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    System.out.println("CombatantListAdapter.onTextChanged");
//                    combatant.setName(charSequence.toString());
//                }
//
//                public void afterTextChanged(Editable editable) {
//                    System.out.println("CombatantListAdapter.afterTextChanged");
//                }
//            });
        }

        if (combatant != null) {
            final TextView tt = getCombatantNameEditText(convertView);
            tt.setText(combatant.getName());
        }

        return convertView;
    }

    private TextView getCombatantNameEditText(View convertView) {
        return (TextView) convertView.findViewById(R.id.combatantNameField);
    }

    public void onItemSelected(AdapterView<?> listView, View view, int position, long id) {
        System.out.println("position = " + position);
        if (position == 1) {
            // listView.setItemsCanFocus(true);

            // Use afterDescendants, because I don't want the ListView to steal focus
            listView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
            getCombatantNameEditText(view).requestFocus();
        } else {
            if (!listView.isFocused()) {
                // listView.setItemsCanFocus(false);

                // Use beforeDescendants so that the EditText doesn't re-take focus
                listView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                listView.requestFocus();
            }
        }
    }

    public void onNothingSelected(AdapterView<?> listView) {
        // This happens when you start scrolling, so we need to prevent it from staying
        // in the afterDescendants mode if the EditText was focused
        listView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }
}
