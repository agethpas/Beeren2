package com.afemsc.beeren;

/**
 * Created by Pascal on 07.12.2016.
 */

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int forms[];
    String[] formNames;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] forms, String[] formNames) {
        this.context = applicationContext;
        this.forms = forms;
        this.formNames = formNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return forms.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(forms[i]);
        names.setText(formNames[i]);
        return view;
    }
}