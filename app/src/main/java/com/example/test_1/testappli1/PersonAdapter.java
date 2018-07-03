package com.example.test_1.testappli1;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    public PersonAdapter(Context context, List<Person> persons) {
        super(context, 0, persons);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_item, parent, false);
        }

        PersonItemHolder viewHolder = (PersonItemHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new PersonItemHolder();
            viewHolder.firstName = (TextView) convertView.findViewById(R.id.firstName);
            viewHolder.lastName = (TextView) convertView.findViewById(R.id.lastName);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        // récupere l'item de la liste
        Person person = getItem(position);

        viewHolder.firstName.setText(person.getFirstName());
        viewHolder.lastName.setText(person.getLastName());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(person.getAvatarColor()));

        return convertView;
    }

}
