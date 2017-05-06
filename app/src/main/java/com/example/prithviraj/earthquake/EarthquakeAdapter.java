package com.example.prithviraj.earthquake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prithviraj.earthquake.Earthquake;
import com.example.prithviraj.earthquake.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;


/**
 * Created by PRITHVIRAJ on 08-01-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    private static final String LOCATION_SEPRATOR = "of";

    public EarthquakeAdapter(Activity context,ArrayList<Earthquake> Earthquakes) {
        super(context,0, Earthquakes);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;

        if(listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(

                    R.layout.earthquake_list_item, parent, false);

        }



        // Get the {@link AndroidFlavor} object located at this position in the list

        Earthquake currentEarthquake = getItem(position);



        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);



        /*
        // Find the TextView in the list_item.xml layout with the ID version_number

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.location);

        // Get the version number from the current AndroidFlavor object and

        // set this text on the number TextView

        defaultTextView.setText(currentEarthquake.getLocation());
        */
        String originallocation = currentEarthquake.getLocation();

        String primaryLocation,locationOffset;

        if(originallocation.contains(LOCATION_SEPRATOR))
        {
            String[] parts = originallocation.split(LOCATION_SEPRATOR);
            locationOffset = parts[0]+LOCATION_SEPRATOR;
            primaryLocation = parts[1];
        }else
        {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originallocation;
        }

        TextView primaryLocationView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationoffsetView = (TextView)listItemView.findViewById(R.id.location_offset);
        locationoffsetView.setText(locationOffset);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)

        // so that it can be shown in the ListView
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView  dateview= (TextView)listItemView.findViewById(R.id.date);

        String formatedDate = formatDate(dateObject);

        dateview.setText(formatedDate);



        TextView  timeview= (TextView)listItemView.findViewById(R.id.time);

        String formatedTime = formatTime(dateObject);

        timeview.setText(formatedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;


    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat  =  new SimpleDateFormat("LLL dd,yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
