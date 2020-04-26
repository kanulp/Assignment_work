package com.example.employeeproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.employeeproject.data.Employee;
import com.example.employeeproject.data.Manager;
import com.example.employeeproject.data.Programmer;
import com.example.employeeproject.data.Tester;

import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends ArrayAdapter<Employee> implements Filterable {

    ArrayList<Employee> employeeArrayList= new ArrayList<>();
    List<Employee> tempList = null;

    Context context;
    private Filter employeeFilter;


    public CustomAdapter(Context context, ArrayList<Employee> employeeArrayList) {
        super(context,R.layout.itemlist,employeeArrayList);
        this.employeeArrayList=employeeArrayList;
        this.context=context;
        this.context = context;
        this.tempList = new ArrayList<Employee>();
        this.tempList.addAll(employeeArrayList);
    }

    @Override
    public int getCount() {
        return employeeArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Employee e=employeeArrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.itemlist, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView tittle=convertView.findViewById(R.id.txt);
            tittle.setText("Name : "+e.getFirst_name()+" "+e.getLast_name().substring(0,1)+"\nId    :"+e.getId());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String log ="";
                    Intent i = new Intent(context,DisplayActivity.class);
                    if ( e instanceof Manager){
                        log = e.toDisplay();
                    } else if(e instanceof Programmer){
                        log = e.toDisplay();
                    }else if(e instanceof Tester){
                        log = e.toDisplay();
                    }
                    i.putExtra("data",log);
                    context.startActivity(i);
                }
            });
        }
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (employeeFilter == null)
            employeeFilter = new EmployeeFilter();

        return employeeFilter;
    }
    private class EmployeeFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = tempList;
                results.count = tempList.size();
            }
            else {
                List<Employee> employees = new ArrayList<Employee>();

                for (Employee e : employeeArrayList) {
                    if (e.getFirst_name().toUpperCase().startsWith(constraint.toString().toUpperCase())
                    || e.getLast_name().toUpperCase().startsWith(constraint.toString().toUpperCase())
                    )
                        employees.add(e);
                }
                results.values = employees;
                results.count = employees.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                employeeArrayList = (ArrayList<Employee>) results.values;
                notifyDataSetChanged();
            }

        }

    }

}