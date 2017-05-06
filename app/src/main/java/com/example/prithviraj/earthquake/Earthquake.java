package com.example.prithviraj.earthquake;

/**
 * Created by PRITHVIRAJ on 14-02-2017.
 */

public class Earthquake {

    private Double mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;

    public Earthquake(Double magnitude,String Location,Long TimeInMilliseconds)
    {
        mMagnitude = magnitude;
        mLocation = Location;
        mTimeInMilliseconds = TimeInMilliseconds;
    }

    public Double getMagnitude(){return mMagnitude;};

    public String getLocation(){return mLocation;};

    public Long getTimeInMilliseconds(){return mTimeInMilliseconds;};
}
